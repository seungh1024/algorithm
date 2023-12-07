package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_2011_암호코드 {
    public static void main(String[] args) throws IOException {
        int mod = 1000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int length = input.length;
        int[] data = new int[length+1];
        for (int i = 1; i <= length; i++) {
            data[i] = input[i-1]-'0';
        }
        int[] dp = new int[length+1];
        dp[0] = 1;
        dp[1] = 1;
        if (data[1] == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= length; i++) {
            int num= data[i-1]*10 + data[i];
            if (num == 0 || (num%10 == 0 && num > 20)) {
                System.out.println(0);
                return;
            }
            if (data[i - 1] > 0) {
                if (num % 10 == 0 && num < 21) {
                    dp[i] = dp[i-2];
                }
                else if (num <= 26) {
                    dp[i] = dp[i-1]*2 - (dp[i-1]-dp[i-2]);
                    dp[i] %= mod;
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                dp[i] = dp[i-1];
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[length]);
    }
}
