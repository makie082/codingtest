
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int M;
    private static int N;
    private static int[] parent;
    private static ArrayList<Node> list;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a,b,c));
        }

        Collections.sort(list);
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        int result = 0;
        int maxcost = 0;
        for (int i = 0; i < list.size(); i++) {
            Node tmp = list.get(i);

            int x = tmp.x;
            int y = tmp.y;
            int cost = tmp.cost;

            // 부모가 다르면 킵고잉
            if (find(x) != find(y)){
                union(x,y);
                result += cost;
                maxcost = cost; // 어차피 cost 기준 오름차순 정렬되어있어서
            }

        }


        System.out.println(result-maxcost);

    }

    static void union(int x, int y){
        // 여기서 새로운 변수로 정의하면 안되고
        // 원래 썼던 x,y를 그대로 사용해야함!!!
        x = find(x);
        y = find(y);
        if (x != y){ // 부모가 같으면 못합침
            // 부모가 다르면 합칠 수 있음
            parent[y] = x;
        }

    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // 내 부모에 내 부모의 부모를 찾아서 넣어줘야함!
        return parent[x] = find(parent[x]);
    }

    static class Node implements Comparable<Node>{
        int x,y,cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 오름차순 정렬
        }
    }

}
