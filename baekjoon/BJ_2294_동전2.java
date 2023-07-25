package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_2294_동전2 {
    public static int N,K;
    public static int[] dp;
    public static int[] coin;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1];
        coin = new int[N];

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            coin[i] = input;
            if(input <= K){
                dp[input] = 1;
            }
        }

//        dp[K] = K+1;
        find();
        if(dp[K] == 0){
            System.out.println(-1);
        }else{
            System.out.println(dp[K]);
        }

//        printDp();
    }
    public static void find(){
        for(int i = 1; i <= K; i++){
            if(dp[i] > 0){
                for(int j =0; j < N; j++){
                    if(i+coin[j] <= K){
                        if(dp[i+coin[j]] == 0){
                            dp[i+coin[j]] = dp[i]+1;
                        }else{
                            dp[i+coin[j]] = Math.min(dp[i+coin[j]] , dp[i]+1);
                        }
                    }
                }
            }
        }
    }
    public static void printDp(){
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(Arrays.toString(dp));
    }
}
