
import java.util.*;
import java.io.*;

public class BOJ_7682 {

    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            map = new char[3][3];

            int cntX = 0;
            int cntO = 0;
            int idx = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = input.charAt(idx++);
                    if (map[i][j] == 'X') cntX++;
                    else if (map[i][j] == 'O') cntO++;
                }
            }

            if (cntX == cntO + 1) { // x를 마지막에 두고 끝냈을 경우
                if (cntX + cntO == 9 && !bingo('O')) { // 꽉 채우고 o이 이기지 않았을 때
                    sb.append("valid").append("\n");
                } else if (!bingo('O') && bingo('X')) { // 덜 채워짐) o이 이기지 않았고, x가 이겼을 때
                    sb.append("valid").append("\n");
                } else { // 덜채워졌는데 o이 이겼을 경우(이거 순서 틀림) or x가 이기지 않았을 경우(이거는 다음 차례로 넘어가야하므로)
                    sb.append("invalid").append("\n");
                }
            } else if (cntX == cntO) { // o를 마지막에 두고 끝냈을 경우 => 빙고 판을 다 채울 수는 없다
                if (!bingo('X') && bingo('O')) { // x가 졌고, o가 이겼을 경우만 가능한 경우
                    sb.append("valid").append("\n");
                } else { // 이외의 모든 경우는 불가능!
                    sb.append("invalid").append("\n");
                }
            }else{ // 놓는 순서가 아에 틀렸을 경우 -> 불가능
                sb.append("invalid").append("\n");
            }

        }

        System.out.print(sb);
    }
    static boolean bingo(char c){
        // 가로
        for (int i = 0; i < 3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c){
                return true;
            }
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                return true;
            }
        }
        // 대각선
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c){
            return true;
        }

        if(map[0][2] == c && map[1][1] == c && map[2][0] == c){
            return true;
        }
        return false;
    }
}
