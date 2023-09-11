package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_11066_파일합치기 {
    public static int[][] dp;
    public static int[] files;
    public static int[] sum;
    public static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            files = new int[K];
            for(int i = 0; i < K; i++){
                files[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[K][K];
            for(int i = 0; i < K-1; i++){
                dp[i][i+1] = files[i]+files[i+1];

            }
            sum = new int[K];
            sum[0] = files[0];
            for(int i = 1; i < K; i++){
                sum[i] = sum[i-1]+files[i];
            }

            find();
            sb.append(dp[0][K-1]).append("\n");
        }
        System.out.println(sb);

    }

    public static void find(){
        for(int i = 0; i <K-1; i++){
            int x = 0;
            for(int j = i+1; j < K; j++){
                int y = j;
//                System.out.println("x: "+x+", y: "+y);
                for(int k = x; k < j; k++){
//                    System.out.println("x : "+x +", k: "+ k +", k+1: "+(k+1) + ",y: "+y);
                    if(dp[x][y] == 0){
                        dp[x][y] = dp[x][k] + dp[k+1][y] + sumValue(x,y);
                    }else if(dp[x][y] != 0){
                        dp[x][y] = Math.min(dp[x][y], dp[x][k]+dp[k+1][y] +sumValue(x,y));
                    }
                }
                x++;
            }
        }
//        for(int i = 0; i < K; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

    public static int sumValue(int start, int end){
        if(start ==0){
            return sum[end];
        }

        return sum[end] - sum[start-1];
    }
}
