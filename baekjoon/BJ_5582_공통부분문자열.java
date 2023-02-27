import java.io.*;
import java.util.*;

public class BJ_5582_공통부분문자열 {
    public static int N,M;
    public static char[] first;
    public static char[] second;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine().toCharArray();
        second = br.readLine().toCharArray();
        N = first.length;
        M = second.length;
        dp = new int[N+1][M+1];

        int result = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(first[i-1] == second[j-1]){
                    dp[i][j] = dp[i-1][j-1]+ 1;
                }
                result = Math.max(result,dp[i][j]);
            }
        }
//        for(int i = 1; i <= N; i++){
//                System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(result);
    }
}
