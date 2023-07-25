import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int ans = 0;

        for (int i=0; i<testCase; i++){
            int[] alp = new int[30];
            boolean b = false;

            String str = sc.next();
//            System.out.println();

//            System.out.println(str+"을 확인해볼게염ㅋ");
            int strLen = str.length();

            for(int j=0; j<strLen; j++){
                b=true;
                if (alp[str.charAt(j)-'a']++ > 0){
                    if (str.charAt(j-1) != str.charAt(j)){
                        b = false;
                        break;
                    }
                }
            }

            if (b == true){
//                System.out.println(str+"은 맞다!");
                ans++;
            }
        }
        System.out.println(ans);
        sc.close();
    }
    
}