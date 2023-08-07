package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Swea_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			LinkedList<Integer> li = new LinkedList<Integer>();
			
			int ansN = Integer.parseInt(br.readLine());
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < ansN; j++) {
				li.add(Integer.parseInt(st.nextToken()));
			}
			
			int encN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < encN; j++) {
				String I = st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for (int k = 0; k < num; k++) {
					li.add(idx+k, Integer.parseInt(st.nextToken()));
				}
				
			}
			
			
			System.out.print("#"+i+" ");
			int cnt=0;
			for (Integer integer : li) {
				System.out.print(integer+" ");
				cnt++;
				if (cnt == 10) {
					break;
				}
			}
			System.out.println();
			
			
		}
	}

}
