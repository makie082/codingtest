package swea;

import java.util.Scanner;

public class Swea_1289 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		
		for (int t=0; t<testcase; t++) {
			String str = sc.next();
			int cnt = 0;
			int flag = 0;
			for (int i=0; i<str.length(); i++) {
				
				if (str.charAt(i) == '1' && flag ==0) {
					flag = 1;
					cnt++;
					//System.out.println(i+"번째에서 +1");
				}
				
				if (flag == 1 && str.charAt(i) == '0') {
					flag = 0;
					cnt ++;
					//System.out.println(i+"번째에서 +1");
				}
				
			}
			System.out.println("#"+(t+1)+" "+cnt);
			
			
		}
		
		
		
	}

}
