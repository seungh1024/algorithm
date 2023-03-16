import java.io.*;
import java.util.*;

public class BJ_11404_플로이드 {
    public static int N,M;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(c, dp[a][b]);
        }


        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(i == k) continue;
                for(int j = 1; j <= N; j++){
                    if(i == j || dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(dp[i][j] == Integer.MAX_VALUE){
                    sb.append(0).append(" ");
                }else{
                    sb.append(dp[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
