import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] score = new int[n][2];

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            score[i][0] = sc.nextInt();
            score[i][1] = sc.nextInt();
            maxDay = Math.max(maxDay, score[i][0]);
        }

        Arrays.sort(score,(o1,o2) -> o2[1]-o1[1]);


        int[] table = new int[maxDay];

        for (int i = 0; i < n; i++) {
            int day = score[i][0]-1;
            // 아에 비어있으면 그대로 넣어줌
            if (table[day]== 0){
                table[day] = score[i][1];
            }
            // 안에 차있으면 앞에 빈 칸 중에 가장 앞에꺼 ㄱ
            else{
                for (int j = day-1; j >= 0 ; j--) {
                    if (table[j] == 0){
                        table[j] = score[i][1];
                        break;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < maxDay; i++) {
            sum += table[i];
        }

        System.out.println(sum);

    }
}