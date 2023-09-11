import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

// 위상정렬 사용!!
// 순서가 정해져있는 일련의 작업을 차례대로 수행해야 할 때 사용하는 알고리즘
// 사이클이 없는 방향 그래프의 모든 노드를 순서대로 나열하는 것!!!!

// 위상정렬 사용하는 법
// 1. 진입차수가 0인 노드를 큐에 넣기
// 2. 큐가 빌 때까지
// 		1) 큐에서 원소를 꺼내 해당 노드에서 나가는 간선을 그래프에서 제거
// 		2) 새롭게 진입차수가 0이 된 노드를 큐에 삽입

    private static int T;
    private static int N;
    private static int[] building;
    static ArrayList<Integer>[] order;
    private static int[] indegree;
    private static int finalB;
    private static int[] result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            building = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                building[i] = Integer.parseInt(st.nextToken());
            }

            order = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) {
                order[i] = new ArrayList<Integer>();
            }

            indegree = new int[N+1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int tmp1 = Integer.parseInt(st.nextToken());
                int tmp = Integer.parseInt(st.nextToken());
                order[tmp1].add(tmp);
                indegree[tmp]++;
            }

            finalB = Integer.parseInt(br.readLine());

            result = new int[N+1];
            check();
            System.out.println(result[finalB]);
        }
    }


    static void check() {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < N+1; i++) {
            if(indegree[i]음
// public class Main {

//     private static int T;
//     private static int N;
//     private static int[] building;
//     static ArrayList<Integer>[] order;

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         T = Integer.parseInt(br.readLine());

//         for (int t = 0; t < T; t++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             N = Integer.parseInt(st.nextToken()); // 빌딩 수
//             int K = Integer.parseInt(st.nextToken()); // 순서 규칙
// //            System.out.println("building: "+N+"개, 순서 수:"+K);
//             building = new int[N+1]; // 건물 짓는데 걸리는 시간
//             st = new StringTokenizer(br.readLine());
//             for (int i = 1; i < N+1; i++) {
//                 building[i] = Integer.parseInt(st.nextToken());
//             }
// //            System.out.println(Arrays.toString(building));

//             // 건물을 짓는 순서
//             order = new ArrayList[N+1]; // 앞에 지어야하는 거를 넣어줌
//             for (int i = 0; i < N+1; i++) {
//                 order[i] = new ArrayList<Integer>();
//             }
//             for (int i = 0; i < K; i++) {
//                 st = new StringTokenizer(br.readLine());
//                 int tmp1 = Integer.parseInt(st.nextToken());
//                 int tmp = Integer.parseInt(st.nextToken());
//                 order[tmp].add(tmp1);
//             }

//             int finalB = Integer.parseInt(br.readLine());

//             // 입력 끝ㅋㅋ 아오
//             bfs(finalB);
//             System.out.println(ans);
//         }


//     }
//     static int ans;
//     static void bfs(int a){
//         Queue<int[]> queue = new ArrayDeque<>();
//         queue.offer(new int[] {a,0});
//         int[] visited = new int[N+1];
//         ans =0;
//         while (!queue.isEmpty()){
//             int[] tmp = queue.poll();
//             int idx = tmp[0];
//             int time = tmp[1]; // 앞꺼 다 더해서 걸렸던 시간
//             visited[idx] = Math.max(building[idx] + time, visited[idx]);

//             if (order[idx].size() == 0){
//                 ans = Math.max(ans, visited[idx]);
//             }
//             for (int i = 0; i < order[idx].size(); i++) {
//                 queue.offer( new int[] {order[idx].get(i),visited[idx]});
//             }
//         }
//     }
// }
