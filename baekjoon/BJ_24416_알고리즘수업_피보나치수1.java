package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_24416_알고리즘수업_피보나치수1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(getTime(N) + " "+(N-2));
    }

    public static int getTime(int N){
        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[N];
    }
}
