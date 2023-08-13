import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, k, l, cnt, x, y, d;
    static int[][] board;
    static int[] sec;
    static List<int[]> snake = new ArrayList<>();
    static int[] dx = {0,1,0,-1}; // 동남서북
    static int[] dy = {1,0,-1,0};
    static String[] dir;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 보드 크기
        k = Integer.parseInt(br.readLine()); // 사과 개수

        board = new int[n+2][n+2];
        board[1][1] = 1; // 뱀이 있는 곳을 1로 표시
        snake.add(new int[] {1,1});

        // 벽을 3으로 표시
        for (int i = 0; i < n+2; i++) {
            board[0][i] = 3;
            board[i][n+1] = 3;
            board[n+1][i] = 3;
            board[i][0] = 3;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        l = Integer.parseInt(br.readLine()); // 방향 변환 횟수
        sec = new int[l];
        dir = new String[l];

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            sec[i] = Integer.parseInt(st.nextToken());
            dir[i] = st.nextToken();
        }

        x=1;
        y=1; // 뱀 머리 현재 위치
        d=0; // 현재 뱀 머리가 향하고 있는 방향
        int time= 0;
        while(true){
            cnt++; // 이동
            // 방향 바꾸어주고
            d += 4;
            x = x + dx[d%4];
            y = y + dy[d%4];

            if (board[x][y] == 1 || board[x][y] == 3){ // 벽이나 자기 자신을 만나면
                break;
            }
            else if(board[x][y] == 2) { // 사과를 만나면
                board[x][y] = 1;
                snake.add(new int[] {x,y});
            }
            else{
                // 뱀 머리 부분 전진
                board[x][y] = 1;
                snake.add(new int[] {x,y});
                // 뱀 꼬리 부분 당겨주기
                board[snake.get(0)[0]][snake.get(0)[1]] = 0;
                snake.remove(0);
            }


            for (int i = time; i < l; i++) {
                if (cnt == sec[i]){ // 방향을 바꾸어야함
                    time = i;
                    if (dir[i].equals("L")) d--;
                    else if (dir[i].equals("D")) d++;
                    break;
                }
            }



        }
        System.out.println(cnt);

    }
}
