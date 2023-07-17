package algo_202307;

import java.io.*;
import java.util.*;
public class BJ_2133_타일채우기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        if(N%2 == 1) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] += dp[i-2]*3;
            for(int j = i-4; j >=0; j-=2){
                dp[i] += dp[j]*2;
            }
        }
        System.out.println(dp[N]);
    }
}
