package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11726_2xn타일링 {
    public static int N;
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }
//        System.out.println(dp[N]%10007);
        System.out.println(dp[N]);
    }
}
