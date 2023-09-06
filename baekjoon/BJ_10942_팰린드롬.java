package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_10942_팰린드롬 {
    public static int N,M;
    public static boolean[][] dp;
    public static int[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new boolean[N+1][N+1];
        data = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if(find(S,E)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean find(int S, int E){
        int left = (S+E)/2;
        int right = (S+E+1)/2;
        while(left>0 && right <=N){
            if(data[left] == data[right]){
                dp[left][right] = true;
            }else{
                return false;
            }
            if(dp[S][E]){
                return true;
            }
           left--;
           right++;

        }
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
//        System.out.println("============");
        return false;
    }
}
