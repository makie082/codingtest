import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, min, max=0;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. ---- : 완성
        int[] type1x = {0, 1, 2, 3};
        int[] type1y = {0, 0, 0, 0}; // | 형태

//        System.out.println("세로 직선 만들기 =======");
        check(type1x, type1y);
//        System.out.println("max = " + max);


//        System.out.println("가로 직선 만들기 =======");
        check(type1y, type1x); // ㅡ 형태
//        System.out.println("max = " + max);


        // 2. ---|: 완성한듯?
        int[] type2x = {0, 0, 0};
        int[] type2y = {0, 1, 2};
        // 가로형태일 때 빼줘야하는 칸
        int[][] del1 = {{0, 0, 0, 1}, {0, 1, 0, 2}, {1, 0, 1, 1}, {1, 1, 1, 2}};
//        System.out.println("가로 형태의 ㄴ=======");
        check2(type2x, type2y, del1);
//        System.out.println("max = " + max);


        // 세로형태 ㄴ
        int[][] del2 = {{0, 1, 1, 1}, {1, 1, 2, 1}, {0, 0, 1, 0}, {1, 0, 2, 0}};
//        System.out.println("세로 형태의 ㄴ========");
        check3(type2y, type2x, del2);
//        System.out.println("max = " + max);


        // 3. 네모 : 완성
        int[] type3x = {0, 0, 1, 1};
        int[] type3y = {0, 1, 0, 1};
//        System.out.println("정사각형 만들기======");
        check(type3x, type3y);
//        System.out.println("max = " + max);


        // 4. ㅗ
        // 가로모양 ㅗ
        int[][] del4 = {{0, 0, 0, 2}, {1, 0, 1, 2}};
//        System.out.println("ㅗ =========");
        check2(type2x, type2y, del4);
//        System.out.println("max = " + max);


        // 세로모양 ㅏ
        int[][] del5 = {{0, 0, 2, 0}, {0, 1, 2, 1}};
//        System.out.println("ㅏ =========");
        check3(type2y, type2x, del5);
//        System.out.println("max = " + max);


        // 5. ㄴㄱ
        // 가로모양 ㅗ
        int[][] del6 = {{0, 0, 1, 2}, {0, 2, 1, 0}};
//        System.out.println("ㄹ =========");
        check2(type2x, type2y, del6);
//        System.out.println("max = " + max);


        // 세로모양 ㅏ
        int[][] del7 = {{0, 1, 2, 0}, {0, 0, 2, 1}};
//        System.out.println("ㄴㄱ =========");
        check3(type2y, type2x, del7);
        System.out.println(max);

    }


    // 해당 그림
    static void check(int[] typex, int[] typey) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < typex.length; k++) {
                    int nx = i+typex[k];
                    int ny = j+typey[k];
                    if ( nx > -1 && nx < n && ny > -1 && ny < m) {
                        sum += map[nx][ny];
                    }else {
                        break;
                    }
                }
                max = Math.max(sum, max);
//                System.out.println("시작점:"+i+" "+j);
//                System.out.println(max);
            }
        }

    }

    // 가로 직사각형을 만들어서 뺀거
    static void check2(int[] typex, int[] typey, int[][] del) {
        int sum=0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-2; j++) {
//                System.out.println("시작점:" + i + " " + j);
                sum = 0;
                for (int k = 0; k < typex.length; k++) {
                    int nx = i+typex[k];
                    int ny = j+typey[k];
                    sum += (map[nx][ny] + map[nx+1][ny]);
                }
//                System.out.println("직사각형:"+sum);

                // 직사각형에서 빼주기
                min = Integer.MAX_VALUE;
                for (int k = 0; k < del.length; k++) {
                    min = Math.min(min, map[i + del[k][0]][j + del[k][1]] + map[i + del[k][2]][j + del[k][3]]);
                }
//                System.out.println("뺀 거:"+(sum-min));
                max = Math.max(sum - min, max);
            }
        }
    }

    // 세로 직사각형을 만들어서 뺀거
    static void check3(int[] typex, int[] typey, int[][] del) {
        int sum=0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-1; j++) {
//                System.out.println("시작점:" + i + " " + j);
                sum = 0;
                for (int k = 0; k < typex.length; k++) {
                    int nx = i+typex[k];
                    int ny = j+typey[k];
                    sum += (map[nx][ny] + map[nx][ny+1]);
                }
                // 직사각형에서 빼주기
                min = Integer.MAX_VALUE;
                for (int k = 0; k < del.length; k++) {
                    min = Math.min(min, map[i + del[k][0]][j + del[k][1]] + map[i + del[k][2]][j + del[k][3]]);
                }
                max = Math.max(sum - min, max);
            }
        }


    }




}
