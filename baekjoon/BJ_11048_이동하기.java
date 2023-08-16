package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_11048_이동하기 {
    public static int N,M;
    public static int[][] room;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find();
    }
    public static void find(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                room[i][j] = Math.max(room[i][j]+room[i-1][j],Math.max(room[i][j] + room[i][j-1],room[i][j]+room[i-1][j-1]));
            }
        }
        System.out.println(room[N][M]);
    }
}
