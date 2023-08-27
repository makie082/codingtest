import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static char[][] wheel;
    private static int order;
    static int[] dirArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheel = new char[4][8];
        for (int i = 0; i < 4; i++) {
            wheel[i] = br.readLine().toCharArray();
        }

        order = Integer.parseInt(br.readLine());
        for (int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1; // 바퀴 번호
            int dir = Integer.parseInt(st.nextToken()); // 방향

            dirArr = new int[4];
            check(num,dir);
            for (int j = 0; j < 4; j++) {
                turn(j,dirArr[j]);
            }
        }
        System.out.println(sumScore());
    }

    static int sumScore(){
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += (wheel[i][0]-'0')*(1<<i);
        }
        return result;
    }
    static void check(int num, int dir){
        dirArr[num] = dir;
        for (int i = num-1; i>=0; i--) {
            if (wheel[i][2] == wheel[i+1][6]) break;
            else {
                dirArr[i] = 0-dirArr[i+1];
            }
        }
        for (int i = num; i < 3; i++) {
            if (wheel[i][2] == wheel[i+1][6]) break;
            else dirArr[i+1] = 0-dirArr[i];
        }
        
    }

    static void turn(int w, int dir) {
        char tmp;
        if (dir == 1) { // 시계 방향
            tmp = wheel[w][7];
            for (int i = 7; i > 0; i--) {
                wheel[w][i] = wheel[w][i-1];
            }
            wheel[w][0] = tmp;
        }
        else if (dir == -1) { // 반시계 방향
            tmp = wheel[w][0];
            for (int i = 0; i < 7; i++) {
                wheel[w][i] = wheel[w][i+1];
            }
            wheel[w][7] = tmp;
        }
    }

}
