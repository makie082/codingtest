import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,s;
    static int[] nums;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        subset(0,0);
        if(s==0) System.out.println(result-1);
        else System.out.println(result);
    }

    static int result = 0;
    static boolean[] visited;
    static void subset(int srcIdx, int tgtIdx){

        if (srcIdx == n){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i]) {
                    sum += nums[i];
                }
            }
            if (sum == s) {
                result++;
            }
            return;
        }

        visited[srcIdx] = true;
        subset(srcIdx+1,tgtIdx+1); // 선택한거
        visited[srcIdx] = false;
        subset(srcIdx+1, tgtIdx); // 선택 안한거


    }


}
