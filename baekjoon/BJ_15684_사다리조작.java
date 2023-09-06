package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_15684_사다리조작 {
    public static int N,M,H;
    public static int[][] data;
    public static boolean[][][] ladder;
    public static boolean isValid;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        data = new int[H+2][N+2];
        ladder = new boolean[H+2][N+2][N+2];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            data[from][to] = 1;
            data[from][to+1] = 1;
            ladder[from][to][to+1] = true;
            ladder[from][to+1][to] = true;
        }


        isValid = false;
        int cnt = 0;
        for(int i = 0; i <= 3; i++){
            if(!find(1,i,0)){
//                System.out.println(-1);
                cnt++;
            }else{
                break;
            }
            if(isValid) break;
        }
        if(cnt ==4){
            System.out.println(-1);
        }
    }
    public static boolean find(int x,int result, int size){
        if(size >result || isValid) return false;
//        for(int i = 1; i <= H; i++){
//            System.out.println(Arrays.toString(data[i]));
//        }
//        System.out.println("---------------------");

        if(size == result){
            if(isCorrect()){
                isValid = true;
                System.out.println(size);
                return true;
            }
            return false;
        }


        for(int i = x; i <= H; i++){
            for(int j = 1; j < N; j++){
                if(data[i][j] == 0 && data[i][j+1] == 0){
                    data[i][j] = 1;
                    data[i][j+1] = 1;
                    ladder[i][j+1][j] = true;
                    ladder[i][j][j+1] = true;
                    if(find(x,result,size+1)){
                        return true;
                    }
                    data[i][j] = 0;
                    data[i][j+1] = 0;
                    ladder[i][j+1][j] = false;
                    ladder[i][j][j+1] = false;
                }

            }
        }
        return false;
    }
    public static boolean isCorrect(){
        for(int j = 1; j <= N; j++){
            int y = j;
            for(int x = 1; x <=H; x++){
                if(data[x][y] == 1){
                    if(ladder[x][y][y-1]){
                        y--;
                    }else if(ladder[x][y][y+1]){
                        y++;
                    }
                }
//                System.out.println("x: "+x+", y: "+y);
            }
//            System.out.println("j :"+j +", y: "+y + "================");
            if(j != y){
                return false;
            }
        }

        return true;
    }
}

//[0, 1, 1, 1, 1, 0, 0]
//[0, 0, 0, 1, 1, 0, 0]
//[0, 0, 1, 1, 1, 1, 0]
//[0, 0, 1, 1, 0, 0, 0]
//[0, 1, 1, 0, 1, 1, 0]
//[0, 0, 0, 0, 0, 0, 0]