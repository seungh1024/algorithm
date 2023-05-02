package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_14719_빗물 {
    public static int H,W;
    public static int[][] data;
    public static int result;
    public static boolean[][] rain;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        data = new int[H][W];
        rain = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < W; j++){
            int num = H-Integer.parseInt(st.nextToken());
            for(int i = H-1; i >= num; i--){
                data[i][j] = 1;
            }
        }
//        printData();
        result = 0;
        find();
        System.out.println(result);
//        printRain();
    }

    public static void printRain(){
        for(int i = 0; i < H; i++){
            System.out.println(Arrays.toString(rain[i]));
        }
    }

    public static void find(){
        boolean[][] visited = new boolean[H][W];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(data[i][j] == 1 && !visited[i][j]){
                    checkRain(i,j,rain);
                    visited[i][j]= true;
                }
            }
        }
    }
    public static void checkRain(int x, int y, boolean[][] rain){
        int a = x;
        int b = y;
        while(true){
            b++;
            if(b >= W) break;
            if(data[a][b] == 1){
//                System.out.println("x: "+x+ ", y: "+y+ " , a:"+a+" , b:"+b);
                for(int j = y+1; j < b; j++){
                    rain[x][j] = true;
                    result++;
                }
//                System.out.println("result: "+result);
                break;
            }
        }
    }

    public static void printData(){
        for(int i = 0; i < H; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }
}
