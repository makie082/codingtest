import java.io.*;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class BOJ_1620 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제 개수

        // 포켓몬들
        String[] pokemons = new String[N+1];
        HashMap<String, Integer> map = new HashMap<>();
        for (int n = 1; n <= N; n++) {
            pokemons[n] = br.readLine();
            map.put(pokemons[n], n);
        }

        StringBuilder sb = new StringBuilder();
        // 문제
        for (int m = 0; m < M; m++) {
            String check = br.readLine();
            // 숫자 -> 포켓몬 번호에 해당하는 문자
            if (check.charAt(0) >= 49 && check.charAt(0) <= 57){
                int num = Integer.parseInt(check);
                sb.append(pokemons[num]).append("\n");
            }else{ // 알파벳 -> 포켓몬 번호
                sb.append(map.get(check)).append("\n");
            }
        }

        System.out.println(sb);


    }



}
