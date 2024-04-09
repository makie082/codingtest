import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14235 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값 먼저 나오게 된다
        for (int i = 0; i < n; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            int place = Integer.parseInt(st.nextToken());
            for (int j = 0; j < place; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
            if (place == 0){
                // 아이들에게 선물 줘야함
                if (pq.isEmpty()) System.out.println(-1);
                else{
                    System.out.println(pq.poll());
                }

            }

        }




    }


}
