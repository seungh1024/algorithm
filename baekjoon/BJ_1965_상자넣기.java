package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_1965_상자넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
//        int[][] dp = new int[N+1][N+1];
        int[] data = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }



        int result = 0;
        for(int i = 1; i <= N; i++){
            for(int j = i+1; j <= N; j++){
                if(data[i] < data[j]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
//            System.out.println(Arrays.toString(dp));
            result = Math.max(result,dp[i]);
        }

        result++;
        System.out.println(result);
//        System.out.println(Arrays.toString(dp));
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }
}
