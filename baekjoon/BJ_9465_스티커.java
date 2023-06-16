package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_9465_스티커 {
    public static int N;
    public static int[][] dp;
    public static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            dp = new int[2][N+1];
            for(int i = 0; i < 2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++){
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0;
            find();
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void find(){
        for(int j = 1; j <= N; j++){
            dp[0][j] = Math.max(dp[0][j-1],dp[1][j-1]+dp[0][j]);
            dp[1][j] = Math.max(dp[1][j-1],dp[0][j-1]+dp[1][j]);
        }
        result= Math.max(dp[0][N],dp[1][N]);
    }
}
