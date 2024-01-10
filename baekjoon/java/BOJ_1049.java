import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049 {
    private static int N;
    private static int M;
    private static int[] allPrices;
    private static int[] onePrices;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 끊어진 줄의 수
        M = Integer.parseInt(st.nextToken());

        allPrices = new int[M];
        onePrices = new int[M];

        int minAll = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            allPrices[i] = Integer.parseInt(st.nextToken());
            onePrices[i] = Integer.parseInt(st.nextToken());
            minAll = Math.min(minAll, allPrices[i]);
            minOne = Math.min(minOne, onePrices[i]);
        }

        int thisPrice = 0;
        if (minAll < minOne*6){
            while (N >= 6){ // 끊어진 줄의 수가 6이상이면 전체 하나 사는게 좋음
                N -= 6;
                thisPrice += minAll;
            }

            // 개별로 사는게 다 사는거보다 비싸다면
            if (N * minOne > minAll){
                thisPrice += minAll;
            }else{ // 개별로 사는게 싸다면
                thisPrice += N*minOne;
            }
        }else{
            thisPrice = N*minOne;
        }




        System.out.println(thisPrice);



    }



}
