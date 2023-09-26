
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    private static int N,M;
    private static ArrayList<Node> road;
    private static String[] school;
    private static int[] parent;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        school = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            school[i] = st.nextToken();
        }

        road = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            road.add(new Node(u,v,d));
        }

        Collections.sort(road);

        int result = 0;

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cnt= 0;
        for (int i = 0; i < M; i++) {
            Node node = road.get(i);
            int x = node.x - 1;
            int y = node.y - 1;
            int dis = node.dis;

            // 같은 성별의 학교면 그냥 킵고잉
            if(school[x].equals(school[y])) continue;

          // 이미 이어진 경우
            if (find(x) == find(y)) continue; 
            union(x,y);
            cnt++;
            result+= dis;
        }

      // 이어주는 선이 최소가 되려면 전체노드의수-1 개여야한다
        if(cnt != N-1) System.out.println(-1);
        else System.out.println(result);
    }

    static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if (x == y) return false;
        else {
            int makeP = Math.min(x,y);
            parent[y] = makeP;
            parent[x] = makeP;
            return true;
        }
    }

    static class Node implements Comparable<Node>{
        int x,y,dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dis=" + dis +
                    '}';
        }
    }


}
