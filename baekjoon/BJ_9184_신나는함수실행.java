package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_9184_신나는함수실행 {
    public static long[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[51][51][51];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.equals("-1 -1 -1")) break;

            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long result = w(a,b,c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    public static long w(int a, int b, int c){
        if(a<=0 || b <= 0|| c <= 0){
            return 1;
        }else if(dp[a][b][c] > 0){
            return dp[a][b][c];
        }else if(a > 20 || b > 20 || c > 20){
            return dp[a][b][c] = w(20,20,20);
        }else if(a < b && b < c){
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        }else{
            return dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        }

    }
}
