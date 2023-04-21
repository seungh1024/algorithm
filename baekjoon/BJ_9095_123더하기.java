package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_9095_123더하기 {
    public static int T,N;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        find();
        for(int t= 0 ; t < T; t++){
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }

    }
    public static void find(){
//        for(int i = 1; i <= 3; i++){
//            for(int j = i; j <= N; j++){
//                dp[j] += dp[j-i];
//            }
//        }
        for(int i = 4; i < 11; i++){
            for(int j = 1; j <= 3; j++){
                dp[i] += dp[i-j];
            }
        }
    }
}
