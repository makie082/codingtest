import java.util.*;
import java.io.*;

public class BOJ_15591 {

    static ArrayList<Node>[] arr; // arraylist가 아니라 그냥 배열로 두면 시간초과!
  // 최소신장트리 형태이기 때문에 노드의 수 > 간선의 수 라서 arraylist를 사용해야한다
    static boolean[] visited;
    static int N;
    static int Q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for (int i = 0; i < N +1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            arr[p].add(new Node(q,r));
            arr[q].add(new Node(p,r));
        }



        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 기준점
            int v = Integer.parseInt(st.nextToken()); // 동영상
            visited = new boolean[N+1];
            System.out.println(bfs(v,k));
        }

    }

    static int bfs(int start, int check){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int ans = 0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
//            System.out.println(tmp+"는!!!!! ");
            for (int i = 0; i < arr[tmp].size(); i++) {
                if (!visited[arr[tmp].get(i).x] && arr[tmp].get(i).usado >= check){
                    queue.offer(arr[tmp].get(i).x);
//                    System.out.println(arr[tmp].get(i).x+"와 연결!!!!");
                    visited[arr[tmp].get(i).x] = true;
                    ans++;
                }
            }
        }
        return ans;


    }

    static class Node{
        int x, usado;

        public Node(int x, int usado){
            this.x=x;
            this.usado=usado;
        }
    }

}
