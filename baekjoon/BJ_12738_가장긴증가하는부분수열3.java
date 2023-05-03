package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_12738_가장긴증가하는부분수열3 {
    public static int N;
    public static int[] data;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        dp = new int[N];
        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        data[0] = Integer.parseInt(st.nextToken());
        dp[0] = data[0];
        for(int i = 1; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
            if(data[i] > dp[idx]){
                dp[++idx] = data[i];
            }else{
                find(0,idx,data[i]);
            }
        }
        System.out.println(idx+1);
//        System.out.println(Arrays.toString(dp));

    }

    public static void find(int x, int y, int value){
        int start = x;
        int end = y;
        while(start <end){
            int mid = (start + end)/2;

            if(dp[mid] >= value){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        dp[start] = value;
    }

}
