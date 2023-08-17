package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_1347_미로만들기 {
    public static int N, d;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};
    public static int[][] map;
    public static int x,y;
    public static int minX, maxX, minY, maxY;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        d = 0;
        map = new int[100][100];
        x = 49;
        y = 49;
        minX = 49;
        maxX = 49;
        minY = 49;
        maxY = 49;
        map[x][y] = 1;
        char[] input = br.readLine().toCharArray();
        for(int i = 0; i < N; i++){
            move(input[i]);
        }
        StringBuilder sb  = new StringBuilder();
        for(int i = minX; i <= maxX; i++){
            for(int j = minY; j <= maxY; j++){
                if(map[i][j] != 1){
                    sb.append('#');
                }else{
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void move(char input){
        if(input == 'R'){
            d = (d+1)%4;
        }else if(input == 'L'){
            d = (d+3)%4;
        }else if(input == 'F'){
            x+=dx[d];
            y+=dy[d];
            minX = Math.min(minX,x);
            maxX = Math.max(maxX,x);
            minY = Math.min(minY,y);
            maxY = Math.max(maxY,y);
            map[x][y] = 1;
        }
    }
}
