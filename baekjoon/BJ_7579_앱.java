import java.io.*;
import java.util.*;

public class BJ_7579_앱 {
    public static int N,M;
    public static int[][] dp;
    public static int[] cost;
    public static int[] data;
    public static int maxCost = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N+1];
        data = new int[N+1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer stc = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(stc.nextToken());
            maxCost += cost[i];
        }
        dp = new int[N+1][maxCost+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= maxCost; j++){
                if(j>=cost[i]){
                    dp[i][j] = Math.max(dp[i-1][j-cost[i]]+data[i],dp[i-1][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for(int i = 1; i <= maxCost; i++){
            if(dp[N][i] >= M){
                System.out.println(i);
                break;
            }
        }


    }

}
