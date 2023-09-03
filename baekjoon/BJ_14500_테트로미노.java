package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_14500_테트로미노 {
    public static int N,M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int result;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        find();
        System.out.println(result);
    }
    public static void find(){
        visited = new boolean[N+2][M+2];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                visited[i][j] = true;

//                System.out.println("-----------------------");
//                System.out.println("x: "+i+", y: "+j);
                dfs(i,j,1,map[i][j]);
                visited[i][j] = false;
                otherFind(i,j);
//                System.out.println("-----------------------");
            }
        }
    }
    public static void otherFind(int x, int y){
        if(x + 2 <= N){
            int sum = map[x][y] + map[x+1][y]+map[x+2][y];
            result = Math.max(result, sum+ Math.max(map[x+1][y+1],map[x+1][y-1]));
        }
        if(y + 2 <= M){
            int sum = map[x][y] + map[x][y+1] + map[x][y+2];
            result = Math.max(result, sum + Math.max(map[x+1][y+1],map[x-1][y+1]));
        }
    }

    public static void dfs(int x, int y, int cnt , int sum){
        if(cnt == 4){
            result = Math.max(result,sum);
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx > 0 && nx <=N && ny > 0 && ny <= M && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny,cnt+1,sum+map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    public static void printVisited(boolean[][] visit){
        for(int i = 0; i <=N; i++){
            System.out.println(Arrays.toString(visit[i]));
        }
    }
    public static boolean[][] copyVisited(){
        boolean[][] copy = new boolean[N][M];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                copy[i][j] = visited[i][j];
            }
        }
        return copy;
    }

    public static class Point{
        int x,y,length,sum;
        public Point(int x, int y, int length, int sum){
            this.x= x;
            this.y = y;
            this.length = length;
            this.sum = sum;
        }

        @Override
        public String toString(){
            return "x: "+x+", y: "+y +", length: "+length+", sum: "+sum;
        }
    }
}
