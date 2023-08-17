import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static char map[][], order[];
    static int h, w, startX, startY, toX, toY;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {


            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int n = Integer.parseInt(br.readLine());
            order = br.readLine().toCharArray();

            boolean flag = false;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] =='^'||map[i][j] =='v'||map[i][j] =='<'||map[i][j] =='>') {
                        startX = i;
                        startY = j;
                        flag = true;
                        break;
                    }
                }
                if(flag == true) break;
            }



            for (int i = 0; i < n; i++) {
                toX = startX;
                toY = startY;
                if (order[i] == 'U') {
                    map[startX][startY] = '^';
                    if (check(startX-1,startY)) toX = startX-1;
                    else continue;
                }
                else if (order[i] == 'D') {
                    map[startX][startY] = 'v';
                    if (check(startX+1,startY)) toX = startX+1;
                    else continue;
                }
                else if (order[i] == 'L') {
                    map[startX][startY] = '<';
                    if (check(startX,startY-1)) toY = startY-1;
                    else continue;
                }
                else if (order[i] == 'R') {
                    map[startX][startY] = '>';
                    if (check(startX,startY+1)) toY = startY+1;
                    else continue;
                }
                else if (order[i] == 'S') {
                    if(map[startX][startY] == '^') {
                        for (int j = startX-1; j >= 0; j--) {
                            if(map[j][startY] == '*') {
                                map[j][startY] = '.';
                                break;
                            }
                            else if(map[j][startY] == '#')	break;
                        }
                    }


                    else if(map[startX][startY] == 'v') {
                        for (int j = startX+1; j <= h-1; j++) {
                            if(map[j][startY] == '*') {
                                map[j][startY] = '.';
                                break;
                            }
                            else if(map[j][startY] == '#')	break;
                        }
                    }
                    else if(map[startX][startY] == '<') {
                        for (int j = startY-1; j >= 0; j--) {
                            if(map[startX][j] == '*') {
                                map[startX][j] = '.';
                                break;
                            }
                            else if(map[startX][j] == '#')	break;
                        }
                    }
                    else if(map[startX][startY] == '>') {
                        for (int j = startY+1; j <= w-1; j++) {
                            if(map[startX][j] == '*') {
                                map[startX][j] = '.';
                                break;
                            }
                            else if(map[startX][j] == '#')	break;
                        }
                    }
                    continue;
                }

                move(startX, startY, toX, toY);

            }

            System.out.print("#"+t+" ");
            for (int j = 0; j < h; j++) {
                for (int i = 0; i < w; i++) {
                    System.out.print(map[j][i]);
                }
                System.out.println();
            }


        }


    }

    static boolean check(int x, int y) {
        if (x<0 || x>h-1 || y<0 || y>w-1) {
            return false;
        }
        return true;
    }

    static void move(int startx, int starty, int tox, int toy) {
        if (map[tox][toy] == '.') {
            map[tox][toy] = map[startx][starty];
            map[startx][starty] = '.';
            startX = tox;
            startY = toy;
        }
    }

}
