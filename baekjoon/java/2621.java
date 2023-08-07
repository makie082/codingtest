import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[10];
        int[] colors = new int[4]; // RBYG 순서로 ㅋㅋ

        for (int i = 0; i < 5; i++) {
            String color = sc.next();
            switch(color) {
                case "R":
                    colors[0]++;
                    break;
                case "B":
                    colors[1]++;
                    break;
                case "Y":
                    colors[2]++;
                    break;
                case "G":
                    colors[3]++;
                    break;
            }
            int num = sc.nextInt();
            nums[num]++;
        }

        int cntColor = 0;
        for (int i = 0; i < 4; i++) {
            if (colors[i]!=0){
                cntColor++;
            }
        }

        int cas = 0;

        int maxNum = 0; // 중복인 수 중에 가장 큰 수
        for (int i = 0; i < 10; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }

        int ans;
        int result = 0;

        // 숫자들이 연속인 경우
        boolean flag;

        // 색깔이 같은 경우4 - 가장 높은 숫자+600
        if (cntColor == 1){
            for (int i = 9; i >= 0 ; i--) {
                if( nums[i] != 0 ){
                    ans = i+600;
                    cas = 4;
                    result = Math.max(result, ans);
//                    System.out.println("색상이 모두 같음");
                    break;

                }
            }
        }

        int maxN=0;
        if (maxNum == 1) {
            for (int i = 0; i < 10; i++) {
                if (nums[i] == 1) {
//                    System.out.println(i + "번째는" + nums[i]);
                    flag = true;
                    if (i <= 5){
                        for (int j = 1; j < 5; j++) {
//                        System.out.println((i + j) + "번째는" + nums[i + j]);
                            if (nums[i + j] != 1) {
                                flag = false; // 연속이 아님!
//                            System.out.println("연속이 아님!");
                                break;
                            }
                        }
                    }
                    if (flag == false) {
                        break;
                    }else { // 연속인 경우
                        if (cntColor == 1) { // 색이 모두 같은 경우1 - 가장 높은 숫자+900
                            ans = i+ 904;
                            result = Math.max(result, ans);
                            cas = 1;
//                            System.out.println("연속이고 색깔 모두 같음!");
                            break;
                        } else { // 색이 다른 경우5 - 가장 높은 숫자+500
                            for (int j = 9; j >= 0; j--) {
                                if (nums[j] != 0) {
                                    ans = j + 500;
                                    cas = 5;
                                    result = Math.max(result, ans);
//                                    System.out.println("색이 다 다르고 연속");
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        }




        // 숫자 4개 동일2 - +800
        else if(maxNum == 4) {
//            System.out.println("숫자 4개가 동일하다!");
            for (int j = 9; j >= 0; j--) {
                if(nums[j] == 4) {
                    ans = j+800;
                    cas = 2;
                    result = Math.max(result, ans);
                    break;
                }
            }
        }


        // 숫자 3개
        else if(maxNum == 3) {

            for (int i = 0; i < 10; i++) {
                if(nums[i] == 3){
                    flag = true;
                    for (int j = 0; j < 10; j++) {
                        //2개 동일3 - 3장숫자*10+2장숫자+700
                        if(nums[j] == 2){
                            ans = (i*10)+700+j;
                            flag = false;
                            cas = 3;
//                            System.out.println("숫자 3 숫자 2 같은거!");
                            result = Math.max(result, ans);
                            break;
                        }
                    }
                    // 6 - 같은 숫자 + 400
                    if(flag == true){
                        ans = i+400;
                        cas = 6;
                        result = Math.max(result, ans);
//                        System.out.println("같은 숫자 총 3개 뿐");
                        break;
                    }

                }
            }

        }


        // 숫자 2개
        else if(maxNum == 2) {
//            System.out.println("같은 숫자 2개!");
            // 다른 숫자 2개7 -큰수*10 + 작은수 + 300
            for (int i = 0; i < 10; i++) {
                if(nums[i] == 2){
                    flag = true;
                    for (int j = i+1; j < 10; j++) {
                        if(nums[j] == 2){
                            ans = (j*10)+300+i;
                            flag = false;
                            cas = 7;
//                            System.out.println("같은 2개 더 있삼ㅋ");
                            result = Math.max(result, ans);
                            break;
                        }
                    }
                    // 8 - 같은수 + 200
                    if(flag == true){
                        ans = i+200;
                        cas = 8;
                        result = Math.max(result, ans);
//                        System.out.println("같은 수 2개만 보유 ㅋㅋ");
                        break;
                    }
                    break;

                }
            }

        }

        // 아무일도 없다9 - 가장큰수+100
        if (cas == 0) {
            for (int i = 9; i >= 0; i--) {
                if (nums[i] != 0) {
                    ans = i + 100;
                    cas = 9;
                    result = Math.max(result, ans);
//                    System.out.println("해당이 암것도 안됨");
                    break;
                }
            }
        }


        System.out.println(result);



    }

}
