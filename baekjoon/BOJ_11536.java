import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int flag = 0;
        String name = br.readLine();
        String newname = br.readLine();
        if (newname.compareTo(name)>0){ // 새로운게 더 크다면
            flag = 1;
        }else{
            flag = -1;
        }
        for (int i = 0; i < N-2; i++) {
            name = newname;
            newname = br.readLine();
            if (flag == 1 && newname.compareTo(name)>0){ // 새로운게 더 크다면
                flag = 1;
                // 증가
            }else if (flag == -1 && newname.compareTo(name)<0) {
                flag = -1;
                // 감소
            }else if((flag == 1 && newname.compareTo(name)<0 || (flag == -1 && newname.compareTo(name)>0))){
                System.out.println("NEITHER");
                return;
            }
        }

        if (flag == 1) {
            System.out.println("INCREASING");
        }
        if (flag == -1){
            System.out.println("DECREASING");
        }

    }


}
