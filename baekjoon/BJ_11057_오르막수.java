package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11057_오르막수 {
    public static int N;
    public static long total;
    public static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[11];
        Arrays.fill(dp,1);
        total = 10;
        for(int i = 1; i < N; i++){
            long sum = 0;
            for(int j = 1; j < 11;j ++){
//                dp[j] = dp[0] - dp[j];
                long a = dp[j];
                dp[j] = total % 10007;
                total -= a;
                sum+= dp[j];
            }
            total = sum;
//            System.out.println(Arrays.toString(dp )+ ", total : "+total);
        }
        System.out.println(total%10007);
    }
}
