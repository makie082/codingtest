import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N,M,result=Integer.MAX_VALUE;
    static ArrayList<int[]> store, home;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        store = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) home.add(new int[] {i,j});
                else if (tmp == 2) store.add(new int[] {i,j});
            }
        }

        // 조합으로 M개의 치킨 집 뽑기
        tgt = new Node[M];
        comb(0,0);

        System.out.println(result);


    }

    static Node[] tgt;
    static void comb(int tgtIdx, int srcIdx){
        if (tgtIdx == M){
            // 치킨 거리 구하기
            int tmp = 0;
            for (int i = 0; i < home.size(); i++) {
                int sum=Integer.MAX_VALUE;

                for (int j = 0; j < tgt.length; j++) {
                    sum = Math.min(sum, Math.abs(tgt[j].x - home.get(i)[0]) + Math.abs(tgt[j].y - home.get(i)[1]));
                }
                tmp+= sum;
            }
            // 치킨 거리 최소값 구하기
            result = Math.min(result, tmp);
            return;
        }
        if (srcIdx == store.size()) return;

        tgt[tgtIdx] = new Node(store.get(srcIdx)[0],store.get(srcIdx)[1]);
        comb(tgtIdx+1,srcIdx+1);
        comb(tgtIdx,srcIdx+1);
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
