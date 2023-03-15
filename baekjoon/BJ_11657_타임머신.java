import java.io.*;
import java.util.*;

public class BJ_11657_타임머신 {
    public static int N,M;
    public static long[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dp[i],Long.MAX_VALUE);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(c,dp[a][b]);
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(i == k) continue;
                for(int j = 1; j <= N; j++){
//                    if(j == i) continue;
                    if(dp[i][k] == Long.MAX_VALUE || dp[k][j] == Long.MAX_VALUE) continue;
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j] , dp[i][j]);
                }
            }
        }

//        for(int i = 1; i <= N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        StringBuilder sb = new StringBuilder();

        for(int i = 2; i <= N; i++){
            if(dp[1][i] != Long.MAX_VALUE){
                sb.append(dp[1][i]).append("\n");
            }else{
                sb.append(-1).append("\n");
            }
        }

//        System.out.println(500 + " "+ 500);
//        for(int i = 1; i < 500; i++){
//            System.out.println(i + " " + (i+1) + " " + -10000);
//        }
//        System.out.println(500 + " " + 1 + " "+ -10000);

        for(int i = 1; i <= N; i++){
            if(dp[i][i] < 0 && dp[1][i] != Long.MAX_VALUE){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb);
    }
}
