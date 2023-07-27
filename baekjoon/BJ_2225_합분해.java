package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_2225_합분해 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K][N+1];
        Arrays.fill(dp[0],1);
        for(int i = 1; i < K; i++){
            for(int j = 0; j <= N; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] = (dp[i][j]+dp[i-1][k])%1000000000;
                }
            }
        }
        System.out.println(dp[K-1][N]);
//        for(int i = 0; i < K; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

}
