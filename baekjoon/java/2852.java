import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        int[] teams = new int[tc]; // 입력되어 들어오는 값
        String[] times;
        int[] sec = new int[tc]; // 입력되는 초
        int[] min = new int[tc]; // 입력되는 분
        int[] score = new int[tc]; // 입력되는 점수

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            teams[i] = Integer.parseInt(st.nextToken());
            times = st.nextToken().split(":");
            min[i] = Integer.parseInt(times[0]);
            sec[i] = Integer.parseInt(times[1]);
        }


        int winTeam = 0;
        int otherTeam;
        int[] winningMin = new int[2];
        int[] winningSec = new int[2];
        int[] teamScore = new int[2];
        int fullMin = 48;
        int fullSec = 0;
        for (int i = 0; i < tc; i++) {
            teamScore[teams[i]-1]++;
            otherTeam = Math.abs(teams[i]-2);
            if(teamScore[teams[i]-1] > teamScore[otherTeam] && winTeam!=teams[i]) {
                // 점수가 뒤집혀야 점수 업로드
                winningMin[teams[i]-1] += fullMin-min[i];
                winningSec[teams[i]-1] += fullSec-sec[i];
                if (winningSec[teams[i]-1]<0){
                    winningMin[teams[i]-1]--;
                    winningSec[teams[i]-1]+=60;
                }
                winTeam = teams[i];
            }
            else if(teamScore[teams[i]-1] == teamScore[otherTeam]) {
                // 동점
                int newMin = fullMin-min[i];
                int newSec = fullSec-sec[i];
                if (newSec < 0){
                    newMin--;
                    newSec += 60;
                }

                winningMin[otherTeam] -= newMin;
                winningSec[otherTeam] -= newSec;
                if (winningSec[otherTeam]<0){
                    winningMin[otherTeam]--;
                    winningSec[otherTeam]+=60;
                }
                winTeam = 0;
            }

        }


        for (int i = 0; i < 2; i++) {
            System.out.println(String.format("%02d", winningMin[i]) + ":" + String.format("%02d", winningSec[i]));
        }


    }


}
