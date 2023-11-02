import java.util.*;
import java.io.*;

public class BOJ_5710 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sumMoney = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            if (sumMoney == 0 && diff == 0 ) return;

            int totalAmount;
            if (sumMoney<= 200){
                totalAmount = sumMoney/2;
            }else if (sumMoney <= 29900){
                totalAmount = (sumMoney-200)/3 + 100;
            }else if (sumMoney <= 4979900){
                totalAmount = (sumMoney-29900)/5 + 10000;
            }else{
                totalAmount = (sumMoney-4979900)/7 + 1000000;
            }

            int left = 0;
            int right = totalAmount/2; // 상근이는 반드시 반보다 적은 양을 사용하니까

            while (left <= right){
                int mid = (left + right)/2;

                int me = checkMoney(mid);
                int neigh = checkMoney(totalAmount-mid);

                if (Math.abs(me - neigh) == diff){
                    System.out.println(me);
                    break;
                }else if (Math.abs(me - neigh) > diff){
                    left = mid+1;
                }if (Math.abs(me - neigh) < diff){
                    right = mid-1;
                }
            }

        }

    }


    static int checkMoney(int amount){
        int money;
        if (amount <= 100){
            money = amount*2;
        }else if (amount <= 10000){
            money = 200 + (amount-100)*3;
        }else if (amount <= 1000000){
            money = 200 + 29700 + (amount-10000)*5;
        }else{
            money = 200 + 29700 + 4950000 + (amount - 1000000)*7;
        }
        return money;
    }




}
