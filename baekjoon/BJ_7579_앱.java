package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_7579_앱 {
    public static int result;
    public static int[] memories;
    public static int[] costs;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        memories = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        costs = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int costSum = 0;
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            costSum += costs[i];
        }

        result = Integer.MAX_VALUE;
        dp = new int[N+1][costSum+1];
        for (int i = 1; i <= N; i++) {
            if (costs[i] == 0) {
                dp[i][0] = memories[i];
            }
            dp[i][0] += dp[i-1][0];
        }
        int result = costSum;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= costSum; j++) {
                if (costs[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - costs[i]] + memories[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
                if (dp[i][j] >= M) {
//                    System.out.println("i: "+i + ", j: "+ j);
//                    result = j;
                    result = Math.min(result,j);
//                    break;
                }
            }
        }
//        for (int i = 0; i <= N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(result);

    }

}
