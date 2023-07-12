package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_1331_나이트투어 {
    public static boolean[][] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        check = new boolean[7][7];
        char[] input = br.readLine().toCharArray();
        int x = input[0]-'A'+1;
        int y = input[1]-'0';
        check[x][y] = true;
        int[] dx = {-1,1,-1, 1,2, 2, -2, -2};
        int[] dy = { 2,2,-2,-2,-1,1,  -1, 1};

        int[] start = {x,y};
        int[] last = {x,y};
        int cnt = 1;
        for(int i = 0; i< 35; i++){
            input = br.readLine().toCharArray();
            x = input[0]-'A'+1;
            y = input[1]-'0';
            if(check[x][y]) {
                System.out.println("Invalid");
                return;
            }

            int xabs = Math.abs(last[0]-x);
            int yabs = Math.abs(last[1]-y);
            if(!((xabs == 2 && yabs == 1) || (xabs == 1 && yabs == 2))){
                System.out.println("Invalid");
                return;
            }

            check[x][y] = true;
            cnt++;
            last[0] = x;
            last[1] = y;
        }

        int xabs = Math.abs(start[0]-last[0]);
        int yabs = Math.abs(start[1]-last[1]);
        if((xabs == 2 && yabs == 1) || (xabs == 1 && yabs == 2)){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
    public static void printCheck(){
        for(int i = 0; i < 7; i++){
            System.out.println(Arrays.toString(check[i]));
        }
    }
}

