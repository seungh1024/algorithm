package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_5373_큐빙 {
    public static char[][] qube;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t <T; t++){
            qube = new char[][]{
                    {'0','0','0','o','o','o','0','0','0'},
                    {'0','0','0','o','o','o','0','0','0'},
                    {'0','0','0','o','o','o','0','0','0'},
                    {'g','g','g','w','w','w','b','b','b'},
                    {'g','g','g','w','w','w','b','b','b'},
                    {'g','g','g','w','w','w','b','b','b'},
                    {'0','0','0','r','r','r','0','0','0'},
                    {'0','0','0','r','r','r','0','0','0'},
                    {'0','0','0','r','r','r','0','0','0'},
                    {'0','0','0','y','y','y','0','0','0'},
                    {'0','0','0','y','y','y','0','0','0'},
                    {'0','0','0','y','y','y','0','0','0'}
            };
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++){
                String input = st.nextToken();
                char side = input.charAt(0);
                char spin = input.charAt(1);
                move(side,spin);
//                printQube();
            }
            for(int i = 3; i < 6; i++){
                for(int j = 3; j < 6; j++){
                    sb.append(qube[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void move(char side, char spin){
        int x = 0;
        int y = 0;
        if(side == 'B'){
            y = 3;
        }else if(side == 'U'){ // lineSpin에서 함께 회전함
            x = 0;
            y = 0;
        }else if(side == 'L'){
            x = 3;
        }else if(side == 'R'){
            x = 3;
            y = 6;
        }else if(side == 'F'){
            x = 6;
            y = 3;
        }else if(side == 'D'){
            x = 9;
            y = 3;
        }
        if(side != 'U'){
            sideSpin(x,y,spin);
        }
        lineSpin(side,spin);
    }

    public static void lineSpin(char side, char spin){
        if(side == 'B'){
            char l = qube[11][3];
            char c = qube[11][4];
            char r = qube[11][5];
            if(spin == '+'){
                qube[11][5] = qube[3][0];
                qube[11][4] = qube[3][1];
                qube[11][3] = qube[3][2];

                for(int j = 3; j < 9; j++){
                    qube[3][j-3] = qube[3][j];
                }

                qube[3][6] = r;
                qube[3][7] = c;
                qube[3][8] = l;

            }else if(spin == '-'){
                qube[11][5] = qube[3][6];
                qube[11][4] = qube[3][7];
                qube[11][3] = qube[3][8];

                for(int j = 5; j >=0; j--){
                    qube[3][j+3] = qube[3][j];
                }

                qube[3][0] = r;
                qube[3][1] = c;
                qube[3][2] = l;
            }
        }else if(side == 'U'){
            char[][] copy = new char[5][5];

            if(spin == '+'){
                int cy = 4;
                for(int i = 2; i < 7; i++){
                    int cx = 0;
                    for(int j = 2; j <7; j++){
                        copy[cx][cy] = qube[i][j];
                        cx++;
                    }
                    cy--;
                }
            }else if(spin == '-'){
                int cy = 0;
                for(int i = 2; i < 7; i++){
                    int cx = 4;
                    for(int j = 2; j <7; j++){
                        copy[cx][cy] = qube[i][j];
                        cx--;
                    }
                    cy++;
                }
            }
            int x = 0;
            int y = 0;
            for(int i = 2; i < 7; i++){
                y=0;
                for(int j = 2; j < 7; j++){
                    qube[i][j] = copy[x][y];
                    y++;
                }
                x++;
            }

        }else if(side == 'L'){
            if(spin == '+'){
                char d1 = qube[11][3];
                char d2 = qube[10][3];
                char d3 = qube[9][3];

                for(int i = 8; i >= 0; i--){
                    qube[i+3][3] = qube[i][3];
                }

                qube[2][3] = d1;
                qube[1][3] = d2;
                qube[0][3] = d3;

            }else if(spin == '-'){
                char d1 = qube[0][3];
                char d2 = qube[1][3];
                char d3 = qube[2][3];

                for(int i = 3; i < 12; i++){
                    qube[i-3][3] = qube[i][3];
                }

                qube[9][3] = d1;
                qube[10][3] = d2;
                qube[11][3] = d3;
            }


        }else if(side == 'R'){
            if(spin == '+'){
                char d1 = qube[0][5];
                char d2 = qube[1][5];
                char d3 = qube[2][5];

                for(int i = 3; i < 12; i++){
                    qube[i-3][5] = qube[i][5];
                }

                qube[9][5] = d1;
                qube[10][5] = d2;
                qube[11][5] = d3;
            }else if(spin == '-'){
                char d1 = qube[11][5];
                char d2 = qube[10][5];
                char d3 = qube[9][5];

                for(int i = 8; i >= 0; i--){
                    qube[i+3][5] = qube[i][5];
                }

                qube[2][5] = d1;
                qube[1][5] = d2;
                qube[0][5] = d3;
            }
        }else if(side == 'F'){
            char l = qube[9][3];
            char c = qube[9][4];
            char r = qube[9][5];
            if(spin == '+'){
                qube[9][5] = qube[5][6];
                qube[9][4] = qube[5][7];
                qube[9][3] = qube[5][8];

                for(int j = 5; j >=0; j--){
                    qube[5][j+3] = qube[5][j];
                }

                qube[5][0] = r;
                qube[5][1] = c;
                qube[5][2] = l;
            }else if(spin == '-'){
                qube[9][5] = qube[5][0];
                qube[9][4] = qube[5][1];
                qube[9][3] = qube[5][2];

                for(int j = 3; j < 9; j++){
                    qube[5][j-3] = qube[5][j];
                }

                qube[5][6] = r;
                qube[5][7] = c;
                qube[5][8] = l;
            }
        }else if(side == 'D'){
            char[][] copy = new char[9][9];
            ArrayList<int[]> list = new ArrayList<>();
            list.add(new int[]{0,3});
            list.add(new int[]{0,4});
            list.add(new int[]{0,5});
            list.add(new int[]{3,8});
            list.add(new int[]{4,8});
            list.add(new int[]{5,8});
            list.add(new int[]{8,3});
            list.add(new int[]{8,4});
            list.add(new int[]{8,5});
            list.add(new int[]{3,0});
            list.add(new int[]{4,0});
            list.add(new int[]{5,0});

            if(spin == '+'){
                for(int[] data : list){
                    int x = data[0];
                    int y = data[1];
                    copy[8-y][x] = qube[x][y];
                }
            }else if(spin == '-'){
                for(int[] data : list){
                    int x = data[0];
                    int y = data[1];
                    copy[y][8-x] = qube[x][y];
                }
            }
            for(int [] data : list){
                int x = data[0];
                int y = data[1];
                qube[x][y] = copy[x][y];
            }
        }
    }

    public static void sideSpin(int x, int y, char spin){
        char[][] copy = new char[3][3];
        int cx = 0;
        int cy = 0;

        if(spin == '+'){
            cy = 2;
            for(int i = x; i <x+3; i++){
                cx = 0;
                for(int j = y; j < y+3; j++){
                    copy[cx][cy] = qube[i][j];
                    cx++;
                }
                cy--;
            }
        }else if(spin == '-'){
            cy = 0;
            for(int i = x; i <x+3; i++){
                cx = 2;
                for(int j = y; j < y+3; j++){
                    copy[cx][cy] = qube[i][j];
                    cx--;
                }
                cy++;
            }
        }
        cx = 0;
        for(int i = x; i < x+3; i++){
            cy = 0;
            for(int j = y; j < y+3; j++){
                qube[i][j] = copy[cx][cy];
                cy++;
            }
            cx++;
        }
    }

    public static void printQube(){
        System.out.println("================");
        for(int i = 0; i < 12; i++){
            System.out.println(Arrays.toString(qube[i]));
        }
        System.out.println("================");
    }
}
