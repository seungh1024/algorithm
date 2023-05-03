package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11727_2xn타일링2 {
    public static int N;
    public static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = (dp[i-2]*2+dp[i-1])%10007;
        }
        System.out.println(dp[N]);
//            System.out.println(Arrays.toString(dp));

    }
}
