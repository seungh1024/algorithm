package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_17406_배열돌리기4 {
    public static int N,M,K;
    public static int[][] data;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static RCS[] rcs;
    public static boolean[] visited;
    public static int[] line;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rcs = new RCS[K];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rcs[i] = new RCS(r,c,s);
        }
        line = new int[K];
        visited = new boolean[K];
        result = 100*M;
        find(0);
        System.out.println(result);
    }

    public static void find(int index){
        if(index == K){
            int[][] copy = copyData();
            for(int i = 0; i < K; i++){
                int r = rcs[line[i]].r;
                int c = rcs[line[i]].c;
                int s = rcs[line[i]].s;
                spin(r-s,c-s,r+s,c+s, s, copy);
            }
            makePoint(copy);
            return;
        }
        for(int i = 0; i < K; i++){
            if(!visited[i]){
                visited[i] = true;
                line[index] = i;
                find(index+1);
                visited[i] = false;
            }
        }
    }

    public static void spin(int startX, int startY, int endX, int endY, int size, int[][] copy){
        for(int s = 0; s <size; s++){
            int d = 0;
            int x = startX;
            int y = startY;
            int lastValue = copy[startX][startY];
            int copyValue = 0;
            while(d <4){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx >= startX && nx <= endX && ny >= startY && ny <= endY){
                    copyValue = copy[nx][ny];
                    copy[nx][ny] = lastValue;
                    lastValue = copyValue;
                    x = nx;
                    y = ny;
                }else{
                    d++;
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
    }
    public static void makePoint(int[][] copy){
        int cnt = 100*M;
        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= M; j++){
                sum += copy[i][j];
            }
            cnt = Math.min(cnt,sum);
        }
        result = Math.min(result,cnt);

//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(copy[i]));
//        }
//        System.out.println("=-------------------");
    }
    public static int[][] copyData(){
        int copy[][] = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                copy[i][j] = data[i][j];
            }
        }
        return copy;
    }

    public static class RCS{
        int r,c,s;
        public RCS(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }

        @Override
        public String toString(){
            return "r: "+r+", c: "+c+", s: "+s;
        }
    }
}
