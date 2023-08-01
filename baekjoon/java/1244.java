import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int switchNum = sc.nextInt();
		int[] switchState = new int[switchNum+1];
		
		for (int i = 1; i < switchNum+1; i++) {
			switchState[i] = sc.nextInt();
		}
		
		int studN = sc.nextInt();

		
		for (int i = 0; i < studN; i++) {
			int sex = sc.nextInt();
			int btn = sc.nextInt();
			
			if (sex == 1) { // 배수 끄기
				for (int j = btn; j <= switchNum; j+=btn) {
					switchState[j] = Math.abs(switchState[j]-1);
//					System.out.println(j+"번째 버튼 바꿈");
				}
			}
			
			
			else { // 대칭 찾기
//				int dif = Math.min(btn, switchNum-btn-1); // 대칭되는 범위
//				int until = Math.min(btn+1, switchNum-btn);
//				for (int j = 1; j < until; j++) {
//					if (switchState[btn-j] == switchState[btn+j]) {
//						continue;
//					}else {
//						dif = j-1;
//						break;
//					}
//				}
////				System.out.println("대칭범위: "+dif);
//				
//				for (int j = btn-dif; j < btn+dif+1; j++) {
//					switchState[j] = Math.abs(switchState[j]-1);
//				}
				
				switchState[btn] = Math.abs(switchState[btn]-1);
				int left = btn-1;
				int right = btn+1;
				while (true) {
					if (left<1 || right>switchNum) break;

					if(switchState[left] != switchState[right]) {
						break;
					}
					switchState[left] = Math.abs(switchState[left]-1);
					switchState[right] = Math.abs(switchState[right]-1);
					
					left--;
					right++;
					
				}
			}
			
			
		}
		
		
		
		for (int i = 1; i < switchNum+1; i++) {
			
			System.out.print(switchState[i]+" ");
			if(i%20 == 0) {
				System.out.println();
			}
			
		}
		

	}

}