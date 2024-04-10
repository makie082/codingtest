import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13335 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 최대 하중

        int[] trains = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trains[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;


        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }
        int idx = 0;
        while( !queue.isEmpty() ){

            queue.poll();

            int sum = 0;
            for(Integer value:queue){
                sum += value;
            }

            if (idx<n){
                if (sum + trains[idx] <= L) {
                    queue.offer(trains[idx]);
                    idx++;
                }
                else queue.offer(0);
            }


            time++;
//            System.out.println(queue);
        }

        System.out.println(time);


    }



}
