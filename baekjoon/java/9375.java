import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i=0; i<T; i++) {
			Set<String> set = new HashSet<>();
			ArrayList<String> arr = new ArrayList<>();
			
			int l = sc.nextInt();
			for (int j=0; j<l; j++) {
				String thing = sc.next();
				String type = sc.next();
				
				set.add(type);
				arr.add(type);
			}
			
			
			int ans = 1;
			for(String s:set) {
				int cnt=0;
				//System.out.println(s+"와 같은 거 있는지 확인!");
				
				for(String a:arr) {
					
					if (s.equals(a)) {
						//System.out.print(a+"찾앗당! ");
						cnt += 1;
						// cnt++;
						//System.out.println(cnt+"개 발견요~");
					}
				}
				ans *= (1+cnt);
				
				
			}
			
			System.out.println(ans-1);
			
			sc.close();
		}

	}
}