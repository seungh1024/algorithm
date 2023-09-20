package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_1937_욕심쟁이판다 {
    public static int N;
    public static int[][] data;
    public static int[][] dp;
    public static boolean[][] visited;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        dp = new int[N][N];


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
            }
        }
        result = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    result = Math.max(result,find(i,j));
                }
            }
        }
        System.out.println(result);
    }

    public static int find(int x, int y){
        if(visited[x][y]) return dp[x][y];
        visited[x][y] = true;
        int maxValue = 0;
        for(int d = 0; d < 4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx>= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny]> data[x][y]){
                maxValue = Math.max(maxValue,find(nx,ny));
            }
        }

        dp[x][y] += maxValue;
        return dp[x][y];
    }

}
