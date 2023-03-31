import java.io.*;
import java.util.*;

public class BJ_1261_알고스팟 {
    public static int M,N;
    public static int[][] data;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static int[][] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for(int i = 0; i < N ;i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0;j <M ; j++){
                data[i][j] = input[j] - '0';
            }
        }
        check = new int[N][M];
        find();
    }

    public static void find(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0,0,0));
        int x,y,nx,ny;
        while(!pq.isEmpty()){
            Point now = pq.poll();
            if(now.x == N-1 && now.y == M-1){
                System.out.println(now.weight);
                break;
            }
            x = now.x;
            y = now.y;
            data[x][y] = -1;
            for(int d = 0; d < 4; d++){
                nx = x+dx[d];
                ny = y +dy[d];
                if(nx >=0 && nx < N && ny >= 0 && ny < M && data[nx][ny] != -1){
                    if(check[nx][ny] == 0){
                        pq.offer(new Point(nx,ny,now.weight+data[nx][ny]));
                        check[nx][ny] = now.weight+data[nx][ny];
                    }else if(check[nx][ny] > now.weight +data[nx][ny]){
                        pq.offer(new Point(nx,ny,now.weight+data[nx][ny]));
                        check[nx][ny] = now.weight+data[nx][ny];
                    }
                }
            }
        }
    }
    public static class Point implements Comparable<Point>{
        int x,y,weight;
        public Point(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight =weight;
        }

        public int compareTo(Point o){
            return this.weight -o.weight;
        }
    }
}
