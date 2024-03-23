import java.io.*;
import java.util.*;

public class BOJ_14719 {

    static int H,W;
    static int[][] blocks;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[] nums = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int w = 0; w < W; w++) {
            nums[w] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < W-1; i++) {
            // i번째를 기준으로 양 옆으로 가장 큰 값 2개 비교
            int right = 0;
            int left = 0;
            for (int j = 0; j < i; j++) {
                right = Math.max(right, nums[j]);
            }
            for (int j = i+1; j < W; j++) {
                left = Math.max(left, nums[j]);
            }

            // 양 옆으로 가장 큰 값 중에 더 작은 값을 구한다
            int std = Math.min(right, left);

            if(std > nums[i]) result += (std - nums[i]);
        }
        System.out.println(result);
    }

}
