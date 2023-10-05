package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_17626_FourSquares {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for(int i = 1; i*i <= n; i++){
            dp[i*i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                if(dp[i] == 0){
                    dp[i] = i/(j*j) + dp[i%(j*j)];
                }else{
                    dp[i] = Math.min(dp[i],i/(j*j)+dp[i%(j*j)]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
