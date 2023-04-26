package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2775_부녀회장이될테야 {
    public static int k, n;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T; t++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            dp = new int[k+1][n+1];
            for(int i = 0; i <= n; i++){
                dp[0][i] = i;
            }
            find();
            System.out.println(dp[k][n]);
//            printDp();
        }
    }
    public static void find(){
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
    }
    public static void printDp(){
        for(int i = 0; i <= k; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
