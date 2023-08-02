import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

	    int n = sc.nextInt();
	
	    int[][] conference = new int[n][2];
	
	    for (int i = 0; i < n; i++) {
	        conference[i][0] = sc.nextInt();
	        conference[i][1] = sc.nextInt();
	    }
	    
	
	    // 입력받은 회의 시간들 1번째 기준 정렬
	    // 왜 마치는 거를 기준으로 해야해?!??!?!?!?!?!?!??
	    // 마치는 시간이 빠를 수록 뒤에 할 수 있는 회의가 더 많기 때문에 
	    Arrays.sort(conference, new Comparator<int[]>() {
	    	public int compare(int[] o1, int[] o2) {
	    		
	    		// 종료시간이 같을 경우는 시작 시간이 빠른 순으로 정렬
	    		// 1번 째 값이 같으면 0번째 값을 기준으로 정렬
	    		if (o1[1] == o2[1]) {
	    			return o1[0]-o2[0];
	    		}
	    		
	    		// 종료시간이 다르면 그냥 종료시간이 빠른 순으로 오름차순 정렬
	    		return o1[1]-o2[1];
	    	}
	    });
	    
	
//	    for (int i = 0; i < n; i++) {
//			System.out.println(conference[i][0]+" "+conference[i][1]);
//		}
	    
	    
	   
	    int cnt=1;
	    
	    int idx = 0;
	    
	    // 끝나는 값과 시작하는 값을 비교하여 구해주기
	    for (int i = 1; i < n; i++) {
			if (conference[idx][1] <= conference[i][0]) {
//				System.out.println(i+"번 째 포함!");
				cnt++;
				idx = i;
			}
		}
	   
	   
	    System.out.println(cnt);
	
	}
} 
