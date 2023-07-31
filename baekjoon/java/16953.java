import java.io.*;
import java.util.Scanner;

 class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 1;
        while (b>a){
            if (b%10==1){
                b = (b-1)/10;
                cnt ++;
            }
            else if(b%2 == 0){
                b = b/2;
                cnt++;
            }
            else{
                cnt = -1;
                break;
            }

            if (a>b){
                cnt = -1;
                break;
            }
        }

        System.out.println(cnt);

    }
}