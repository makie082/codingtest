import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_2493 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Tower> tower = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {

            int cur = Integer.parseInt(st.nextToken());

            if(tower.isEmpty()){ // 스택에 들어있는 게 없으면
                sb.append(0).append(" ");
                tower.push(new Tower(cur,n));
                continue;
            }


            while(tower.peek().height < cur){ // 내 현재보다 작으면
                tower.pop(); // 빼주고
                if(tower.isEmpty()){ // 스택에 들어있는 게 없으면
                    sb.append(0).append(" ");
                    break;
                }
            }

            if (!tower.isEmpty() && tower.peek().height > cur){
                // 내 현재보다 크면
                sb.append(tower.peek().idx+1).append(" ");
            }

            tower.push(new Tower(cur,n));

        }


        System.out.println(sb);


    }

    static class Tower{
        int height, idx;

        Tower(int height, int idx){
            this.height = height;
            this.idx = idx;
        }
    }


}
