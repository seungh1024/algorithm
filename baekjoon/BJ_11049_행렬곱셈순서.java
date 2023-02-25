import java.io.*;
import java.util.*;

public class BJ_11049_행렬곱셈순서 {
    public static int N;
    public static int[][] data;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][2];
        dp = new int[N][N];
        StringTokenizer st;
        int a,b;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            data[i][0] = a;
            data[i][1] = b;
        }

//        for(int i = 0; i < N; i++){
//            Arrays.fill(dp[i],Integer.MAX_VALUE);
//            dp[i][i] = 0;
//        }

        int x,y;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N-i; j++){
                x = j;
                y = x+i;

                for(int k = x; k < y; k++){
                    if(dp[x][y] != 0){
                        dp[x][y] = Math.min(dp[x][y],dp[x][k] + dp[k+1][y] + data[x][0]*data[k][1]*data[y][1]);
                    }else if(dp[x][y] == 0){
                        dp[x][y] = dp[x][k] + dp[k+1][y] + data[x][0]*data[k][1]*data[y][1];
                    }
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}
