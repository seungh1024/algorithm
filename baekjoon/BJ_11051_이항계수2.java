package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11051_이항계수2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N+1][K+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= Math.min(i,K); j++){
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
                }
            }
        }
//        for(int i = 0; i<= N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[N][K]);

    }
}
