package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2638_치즈 {
    public static int N,M,result;
    public static int[][] data;



    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int input = Integer.parseInt(st.nextToken());
                data[i][j] = input;
            }
        }

        find(); // 치즈 녹이기
        System.out.println(result);
    }
    public static void find(){
        result = 0;
        while(melting()>0){
            result++;
        }
    }
    public static int melting(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        boolean[][] visited = new boolean[N][M];
        int[][] visitCnt = new int[N][M];
        ArrayList<Point> deleteList = new ArrayList<>();
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = now.x+dx[d];
                int ny = now.y+dy[d];
                if(nx>=0 && nx <N && ny >=0 && ny < M && !visited[nx][ny]){
                    if(data[nx][ny] == 0){ // 공기인 경우
                        q.offer(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }else{ //치즈인 경우
                        visitCnt[nx][ny]++;
                        if(visitCnt[nx][ny] >= 2){
                            deleteList.add(new Point(nx,ny));
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for(Point p : deleteList){
            data[p.x][p.y] = 0;
            cnt ++;
        }
        return cnt;
    }
    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }




    public static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
