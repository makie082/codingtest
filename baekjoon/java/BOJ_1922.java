import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parent;
    static ArrayList<Node> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

        list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a,b,c));

        }

        Collections.sort(list);

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < list.size() ; i++) {
            Node node = list.get(i);

            int x = node.x;
            int y = node.y;

            if (find(x) != find(y)){ // 사이클을 만들지 않을 경우에만
                result += node.cost; // cost 값 업데이트 해주고
                union(x,y); // 둘의 부모를 합쳐준다
            }

        }

        System.out.println(result);



    }

    static class Node implements Comparable<Node>{
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x + "y=" + y +
                    ", cost=" + cost +
                    '}';
        }

    }

    static int find(int x){
        if (x == parent[x]){
            return x;
        }
        return find(parent[x]);
    }

    static boolean union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a==b) return false;
        parent[b] = a;
        return true;
    }

}
