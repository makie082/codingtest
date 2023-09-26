// 위상정렬
// 아무래도 사이클 없는 순서 있는 그래프 만들기!!에서 사용

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//9470

public class BOJ_9470 {

    private static int T;
    private static int[] inDegree;
    private static ArrayList<Integer>[] map;
    private static ArrayDeque<Integer> queue;
	private static int[] maxN;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken()); // 테스트케이스 번호
            int M = Integer.parseInt(st.nextToken()); // 노드의 수
            int P = Integer.parseInt(st.nextToken()); // 간선의 수

            inDegree = new int[M+1];
            map = new ArrayList[M+1];

            for (int i = 0; i < M+1; i++) {
                map[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                inDegree[b]++;
                map[a].add(b);
            }
            
            queue = new ArrayDeque<>();
            maxN = new int[M+1];
            for (int i = 1; i < M+1; i++) {
                if (inDegree[i] == 0){
                    queue.offer(i);
                    maxN[i] = 1;
                }
            }
            
            boolean[] check = new boolean[M+1];
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                
                for (int j = 0; j < map[tmp].size(); j++) {
                	int i = map[tmp].get(j);
                	
                    if(inDegree[i] != 0){
                        inDegree[i]--;
                        
                        if(maxN[i] < maxN[tmp]) {
                        	maxN[i] = maxN[tmp];
                    		check[i] = true;
                    	}else if (maxN[i] == maxN[tmp]){ // 같은게 두 개 째 들어오면
                    		// 갱신된 값이 같긴 한데 이전에 같은 값이 들어온 적이 있으면 +1 해주
                    		if(check[i]) maxN[i] = maxN[tmp]+1; 
                    		// 갱신된 값이 같은데 같은 값이 들어와서 그런게 아니라면 킵고잉
                    		check[i] = false;
                    	}
                        if (inDegree[i] == 0){
                            queue.offer(i);
                        }    
                    }
                }
                
            }
            
            System.out.println(K+" "+maxN[M]);
            
        }


    }
    
    static class Node{
    	int x, maxdir;

		public Node(int x, int maxdir) {
			this.x = x;
			this.maxdir = maxdir;
		}
    }


}
