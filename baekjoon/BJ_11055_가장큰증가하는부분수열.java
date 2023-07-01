package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11055_가장큰증가하는부분수열 {
    public static int N;
    public static int[]A;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = A[i];
        }
//        dp[0] = A[0];
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[i], A[i] + dp[j]);
                }
            }
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }

}
