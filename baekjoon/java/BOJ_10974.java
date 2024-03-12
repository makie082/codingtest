import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] src;
    static int[] tgt;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        src = new int[N];
        tgt = new int[N];

        for (int i = 1; i <= N ; i++) {
            src[i-1] = i;
        }

        visited = new boolean[N];
        perm(0);
    }

    static void perm(int tgtIdx){
        if (tgtIdx == N){
            for (int i = 0; i < N; i++) {
                System.out.print(tgt[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            tgt[tgtIdx] = src[i];
            visited[i] = true;
            perm(tgtIdx+1);
            visited[i] = false;

        }


    }


}
