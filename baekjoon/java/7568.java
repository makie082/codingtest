import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[][] check = new int[T][2];
		
		for (int i=0; i<T; i++) {
			
			int weight = sc.nextInt();
			int height = sc.nextInt();
			
			check[i][0] = weight;
			check[i][1] = height;
			
		}
		
		for (int i=0; i<T; i++) {
			int cnt = 0;
			
			for (int j=0; j<T; j++) {
				if (check[i][0] < check[j][0] && check[i][1] < check[j][1]) {
					cnt++;
				}
			}
			
			System.out.printf("%d ",cnt+1);
			
		}
	

	}
}