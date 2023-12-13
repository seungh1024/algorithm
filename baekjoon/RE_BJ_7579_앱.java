package algo_202312.re;

import java.io.*;
import java.util.*;

public class RE_BJ_7579_앱 {
    public static int N,M;
    public static int[] memory;
    public static int[] cost;
    public static int[][] dp;
    public static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N+1];
        cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int totalCost = 0;
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
            totalCost+=cost[i];
        }

        dp = new int[N+1][totalCost+1];
        for (int i = 1; i <= N; i++) {
            if (cost[i] == 0) {
                dp[i][0] = memory[i];
            }
            dp[i][0]+=dp[i-1][0];
        }
        result = totalCost;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= totalCost; j++) {
                if (cost[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - cost[i]]+memory[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                if (dp[i][j] >= M) {
                    result = Math.min(result,j);
                }
            }
//            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(result);
    }

}
