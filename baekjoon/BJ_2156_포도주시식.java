package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2156_포도주시식 {
    public static int N;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][4];
        for(int i = 1;i <= N; i++){
            dp[i][0] = Integer.parseInt(br.readLine());
//            System.out.println(dp[i][0]);
        }
        find();
    }
    public static void find(){
        dp[1][1] = 0;
        dp[1][2] = dp[1][0];
        dp[1][3] = dp[1][0];
        for(int i = 2; i <= N; i++){
            dp[i][1] = Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][3]));
            dp[i][2] = dp[i-1][1] + dp[i][0];
            dp[i][3] = dp[i-1][2]+dp[i][0];
//            System.out.println("1: "+dp[i][1] + " , 2: "+dp[i][2] + " ,3: "+dp[i][3]);
        }
        System.out.println(Math.max(dp[N][1],Math.max(dp[N][3],dp[N][2])));
    }
}
