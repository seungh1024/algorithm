package algo_202304;

import java.util.*;
import java.io.*;

public class BJ_16918_봄버맨 {
    public static int R,C,N;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[][] time;
    public static char[][] bomb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        time = new int[R][C];
        bomb = new char[R][C];
        for(int i = 0; i < R; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                bomb[i][j] = input[j];
                time[i][j] = 3;
            }
        }

        timer();
    }
    public static void timer(){
        int n = N;
        minusTime();
        n--;
        while(n > 0){
            minusTime();
            addBomb();
            n--;
            if(n <= 0) break;
            minusTime();
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(bomb[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void addBomb(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(bomb[i][j] == '.'){
                    bomb[i][j] = 'O';
                    time[i][j] = 3;
                }
            }
        }
    }

    public static void minusTime(){
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(time[i][j] > 0){
                    time[i][j]--;
                    if(time[i][j] == 0){
//                        System.out.println("!");
                        list.add(new int[]{i,j});
                    }
                }
            }
        }
        for(int[] l : list){
            int x = l[0];
            int y = l[1];
            bomb[x][y] = '.';
            time[x][y] = 0;
            for(int d = 0; d < 4; d++){
                int nx = x+dx[d];
                int ny = y +dy[d];
                if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                    bomb[nx][ny] = '.';
                    time[nx][ny] = 0;
                }
            }
        }
    }
}
