import java.sql.Array;
import java.util.*;
import java.io.*;

public class BOJ_13913 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 목적지

        int[] list = new int[100001];
        // 자신의 부모 위치를 지정해줌 !!!! 따라서 가기만 하면 된당
        // 앞선 위치를 계속 기억해야 하므로
        int[] parent = new int[100001];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        list[N]=1;

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            if (tmp == K) {
                System.out.println(list[tmp]-1);
                break;
            }

            if(tmp+1 < 100001 && list[tmp+1] ==0) { // 한 번 방문한 곳은 이전에 방문했을 때가 최소임
                list[tmp+1] = list[tmp]+1;
                parent[tmp+1] = tmp;
                queue.offer(tmp+1);
            }

            if(tmp-1 >= 0 && list[tmp-1] ==0) {
                list[tmp-1] = list[tmp]+1;
                parent[tmp-1] = tmp;
                queue.offer(tmp-1);
            }

            if(tmp*2 < 100001 && list[tmp*2] ==0) {
                list[tmp*2] = list[tmp]+1;
                parent[tmp*2] = tmp;
                queue.offer(tmp*2);
            }

        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(K);
        while(true){
            int last = result.size()-1;
            int tmp = result.get(last);
            if (tmp == N) break;
            result.add(parent[tmp]);
        }

        for (int i = result.size()-1; i >-1 ; i--) {
            System.out.print(result.get(i)+" ");
        }
    }



}
