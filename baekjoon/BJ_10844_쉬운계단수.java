package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_10844_쉬운계단수 {
    public static int N;
    public static long[][] dp;
    public static long num = 1000000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];
        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= N; i++){
            for(int j = 1; j < 9; j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
                dp[i][j] = dp[i][j] %num;
            }
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
        }

        long sum = 0;
        for(int i = 0; i <= 9; i++){
            sum += dp[N][i];
        }
        System.out.println(sum%num);

    }
}
