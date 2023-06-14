package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11052_카드구매하기 {
    public static int N;
    public static int[][] dp;
    public static int[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(j-i < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i][j-i]+data[i],dp[i-1][j]);
                }
            }
        }
//        System.out.println(data[3]);
//        printData();
        System.out.println(dp[N][N]);
    }

    public static void printData(){
        for(int i = 0; i <= N; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
