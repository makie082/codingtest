package algo;

public class BOJ_11726 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 1: 1
		// 2: 2
		// 3: (1)*2 + (2) => 3
		// 4: (2)*2 + (3)
		
		if (n == 1) {
			System.out.println(1);
			return;
		}
		else if(n==2) {
			System.out.println(2);
			return;
		}
		
		long[] arr = new long[n+1];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < n+1; i++) {
			
			// 끝이 가로방향인 것(i-2번째꺼 이용) + 끝이 세로 방향인것(i-1번째꺼 이용)
			arr[i] = arr[i-2]%10007 + arr[i-1]%10007;
		}
		
		System.out.println(arr[n]%10007);
		
	}

}
