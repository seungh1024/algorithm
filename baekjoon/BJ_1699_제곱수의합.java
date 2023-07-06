package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_1699_제곱수의합 {
    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 1;
        System.out.println(call(N));
    }

    public static int call(int num){
        if(num == 0) return 0;
        if(dp[num] > 0) return dp[num];

        int length = (int)Math.sqrt((double)num);
        int min = Integer.MAX_VALUE;
//        System.out.println("num:" + num + ", length: "+length);
        for(int i = length; i>0; i--){
//            System.out.println(" num ! "+num);

            min = Math.min(min,call(num-i*i)+1);
        }
        dp[num] = min;
//        System.out.println(dp[num] + " ;;;; " + num);
//        System.out.println("-----");
        return min;
    }
}
