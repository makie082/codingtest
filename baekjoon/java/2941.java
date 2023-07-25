import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main {

    public static void main(String[] args) throws Exception
    {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr;
        inputStr = br.readLine();

        int lenStr = inputStr.length();
        int ans = lenStr;

        for (int i = 1; i < lenStr; i++){
            if (inputStr.charAt(i) == '='){
                ans--;
                if (i>1 && inputStr.charAt(i-1) == 'z' && inputStr.charAt(i-2) == 'd'){
                    ans--;
                }
            }
            if (inputStr.charAt(i) == '-'){
                    ans--;
            }
            if (inputStr.charAt(i) == 'j'){
                if (inputStr.charAt(i-1) == 'l' || inputStr.charAt(i-1) == 'n'){
                    ans--;
                }
            }
        }
        System.out.println(ans);

    }
}