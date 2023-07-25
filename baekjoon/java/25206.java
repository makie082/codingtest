import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);

		String[] grade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
		double[] score = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
		
		double cnt = 0.0;
		double scoreSum = 0;
		
		for (int i = 0; i<20; i++) {
			
			String course = sc.next();
			double getCnt = sc.nextDouble();
			String getGrade = sc.next();
			
			if (!getGrade.equals("P")) {
				cnt += getCnt; // 학점 계산하기
				//System.out.printf("뭐가 문제니^^%n" + course+"의 학점은 "+getGrade +"이고, 이거의 순서는 "+Arrays.asList(grade).indexOf(getGrade));
				scoreSum += getCnt*score[Arrays.asList(grade).indexOf(getGrade)];
			}
		
		}
		
		System.out.printf("%.6f",scoreSum/cnt);
        sc.close();
	}

}