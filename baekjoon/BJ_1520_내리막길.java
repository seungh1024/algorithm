import java.io.*;
import java.util.*;

public class BJ_1520_내리막길 {
    public static int M,N;
    public static int[][] data;
    public static int[][] check;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        data = new int[M][N];
        check = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find();
    }
    public static void find(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0,0,0));
        check[0][0] = 1;

        while(!pq.isEmpty()){
            Point now = pq.poll();
            int nx,ny;
            for(int i = 0; i < 4; i++){
                nx = now.x +dx[i];
                ny = now.y + dy[i];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N && data[nx][ny] < data[now.x][now.y]){
                    if(check[nx][ny] == 0){
                        pq.offer(new Point(nx,ny,data[nx][ny]));
//                        data[nx][ny] = 1;
                    }
                    check[nx][ny] += check[now.x][now.y];
                }
            }
        }
//        for(int i = 0; i < M; i++){
//            System.out.println(Arrays.toString(check[i]));
//        }
        System.out.println(check[M-1][N-1]);
    }

    public static class Point implements Comparable<Point>{
        int x,y,height;
        public Point(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
        @Override
        public int compareTo(Point o){
            return o.height - this.height;
        }
    }
}
