import java.io.*;
import java.util.*;

public class BJ_11660_구간합구하기5 {
    public static int N,M;
    public static int[][] data;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        // data input
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                data[i][j] = data[i-1][j] + data[i][j-1] + Integer.parseInt(st.nextToken()) -data[i-1][j-1];
            }
        }


        int x,y,nx,ny;
        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            nx =Integer.parseInt(st.nextToken());
            ny =Integer.parseInt(st.nextToken());
            System.out.println(data[nx][ny] - data[nx][y-1] - data[x-1][ny] + data[x-1][y-1]);
        }
    }
}
