package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_14501_퇴사 {
    public static int N;
    public static int[] T;
    public static int[] P;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            T[i] = t;
            P[i] = p;
        }

        for(int i = 1; i <= N; i++){
            dp[i] = Math.max(dp[i],dp[i-1]);
            int idx = i+T[i]-1;
            if(idx>N) continue;
            int sum = dp[i-1] + P[i];
            dp[idx] = Math.max(dp[idx],sum);
        }
        System.out.println(dp[N]);
//        System.out.println(Arrays.toString(dp));
    }
}
