package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_15988_123더하기3 {
    public static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new long[1000002];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
//        for(int i = 4; i <= 1000001; i++){
//            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
//        }
        StringBuilder sb = new StringBuilder();
        for(int t= 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
//            sb.append(dp[n]).append("\n");
            sb.append(find(n)).append("\n");
        }
        System.out.println(sb);
    }

    public static long find(int n){
        if(dp[n] > 0) return dp[n];

        return dp[n] = (find(n-1)+find(n-2)+find(n-3))%1000000009;
    }
}
