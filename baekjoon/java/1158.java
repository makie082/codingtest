import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			arr.add(i+1);
		}
		
		while (arr.size() != 0) {
			Collections.rotate(arr, -m+1);
			ans.add(arr.remove(0));
		}
		
		System.out.print("<");
		for (int i = 0; i < n; i++) {
			if (i == n-1) System.out.print(ans.get(i));
			else System.out.print(ans.get(i) + ", ");
		}
		System.out.println(">");
		
	}
}