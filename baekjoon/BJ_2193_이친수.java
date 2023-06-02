package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2193_이친수 {
    public static long[] dp;
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
