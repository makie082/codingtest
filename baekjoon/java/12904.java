import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        while (true){

            if (t.length() == s.length()){
                if (t.equals(s)){
                    System.out.println(1);
                    break;
                }else{
                    System.out.println(0);
                    break;
                }
            }

            int tLen = t.length();
            // 마지막이 B -> 문자열 뒤집어야 함
            if(t.charAt(tLen-1) == 'B'){
//                System.out.println("B로 끝남!");
                StringBuffer sb = new StringBuffer(t);
                String reverse = sb.reverse().toString();
                t = reverse.substring(1);
//                System.out.println(t);
            }

            // 마지막이 A면 그냥 .. 그런거
            else if(t.charAt(tLen-1) == 'A'){
//                System.out.println("A로 끝남!");
                StringBuffer sb = new StringBuffer(t);
                t = t.substring(0,tLen-1);
//                System.out.println(t);
            }

        }


    }

}