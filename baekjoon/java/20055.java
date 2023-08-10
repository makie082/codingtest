import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] rail = new int[n*2];
        int[] robot = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            rail[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        while(true){
            ans ++ ;
            // 로봇 벨트 회전
            int temp = rail[rail.length - 1]; // 마지막 꺼 앞으로
            for (int i = rail.length - 1; i > 0; i--) { // 레일 회전
                rail[i] = rail[i - 1];
            }
            rail[0] = temp;

            for (int i = n - 1; i > 0; i--) {  // 로봇 회전
                robot[i] = robot[i - 1];
            }
            robot[0] = 0;
            robot[n-1] = 0; // 마지막에는 무조건 내려줘야함

            // 레일 위에서 로봇 이동
            for (int i = n-2; i >0 ; i--) {
                if (robot[i] == 1 && robot[i+1] == 0 && rail[i+1]>0) {
                    robot[i] = 0;
                    robot[i + 1] = 1;
                    rail[i + 1]--;
                }
            }

            // 0 위치에 로봇 올리기
            if(rail[0]>0){
                rail[0]--;
                robot[0] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < 2*n; i++) {
                if (rail[i] == 0) cnt++;
            }

            if (cnt >= k) break;
        }


        System.out.println(ans);


    }


}
