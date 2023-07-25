import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int ans = 0;
        HashSet<String> hset = new HashSet<>();

        for (int i=0; i<testCase; i++){
            String newInput = sc.next();
            if(newInput.equals("ENTER")){
                ans += hset.size();
                hset.clear();
                continue;
            }
            hset.add(newInput);

        }
        ans += hset.size();
        System.out.println(ans);
    }
}