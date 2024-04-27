import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_20437 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = 0;

            // 전체 알파벳을 가지고 있는 배열
            ArrayList<Integer>[] list = new ArrayList[26];

            for (int i = 0; i < 26; i++) {
                // 한 알파벳 당 위치 정보 넣어주기
                list[i] = new ArrayList<Integer>();
            }

            int len = W.length();
            for (int i = 0; i < len; i++) {
                list[W.charAt(i) - 'a'].add(i);
                if (list[W.charAt(i)-'a'].size() >= K){
                    min = Math.min(min, i - list[W.charAt(i) - 'a'].get(list[W.charAt(i)-'a'].size() - K));
                    max = Math.max(max, i - list[W.charAt(i) - 'a'].get(list[W.charAt(i)-'a'].size() - K));
                }
            }

            if (min == Integer.MAX_VALUE && max == 0) System.out.println(-1);
            else System.out.println((min+1) + " " + (max+1));

        }

    }


}
