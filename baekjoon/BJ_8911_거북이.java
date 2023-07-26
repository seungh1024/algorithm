package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_8911_거북이 {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            char[] input = br.readLine().toCharArray();
            sb.append(move(input)).append("\n");
        }
        System.out.println(sb);
    }
    public static int move(char[] input){
        int minX,maxX,minY,maxY;
        minX = maxX = minY = maxY =  0;
        int x = 0, y = 0;
        int d = 0;
        for(char c : input){
            if(c == 'L'){
                d = (d+3)%4;
            }else if(c == 'R'){
                d = (d+1)%4;
            }else if(c == 'F'){
                x += dx[d];
                y += dy[d];
                minX = Math.min(minX,x);
                maxX = Math.max(maxX,x);
                minY = Math.min(minY,y);
                maxY = Math.max(maxY,y);
            }else if(c == 'B'){
                x -= dx[d];
                y -= dy[d];
                minX = Math.min(minX,x);
                maxX = Math.max(maxX,x);
                minY = Math.min(minY,y);
                maxY = Math.max(maxY,y);
            }
        }
//        System.out.println("minX: "+ minX + ", maxX : "+maxX +", minY : "+minY + ", maxY: "+maxY);
        return(maxX-minX) * (maxY - minY);
    }

}
