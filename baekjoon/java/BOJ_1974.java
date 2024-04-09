import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class BOJ_1974 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> list = new ArrayList<>();
        int[] arr = new int[N]; // 만들어야 하는 수열
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        int idx = 0;

        boolean[] booleans = new boolean[N];
        for (int n = 1; n < N+1; n++) {


//            System.out.println("===============");
//            System.out.println(arr[idx]+"와 비교, 대상은 "+n);

            if (n == arr[idx]){ // 내가 찾던 그 값이면 push 후 바로 pop
//                System.out.println("+");
                list.add('+');
                stack.push(n);
                booleans[n-1] = true;
                stack.pop();
//                System.out.println("-");
                list.add('-');
                idx++;
            }else if (n < arr[idx]){
                if (!booleans[n]){
                    stack.push(n);
//                    System.out.println("+");
                    list.add('+');
                    booleans[n-1] = true;
                }
            }else if (n > arr[idx]){
                int check = stack.peek();
//                System.out.println("check: "+check);
                if (check != arr[idx]){
                    System.out.println("NO");
                    return;
                }else{
                    stack.pop();
//                    System.out.println("-");
                    list.add('-');
                    idx++;
                    n--;
                }

            }

        }

        while(!stack.isEmpty()){ // stack이 차있을 동안
            if(stack.pop() == arr[idx]){
                idx++;
//                System.out.println("-");
                list.add('-');
            }else{
                System.out.println("NO");
                return;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }


}
