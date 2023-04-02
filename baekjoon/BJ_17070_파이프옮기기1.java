package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_17070_파이프옮기기1 {
    public static int N;
    public static int[][] data;
    public static int[] dx = {0,1,1};
    public static int[] dy = {1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(data[N-1][N-1] == 1){
            System.out.println(0);
            return;
        }
        find();
    }
    public static void find(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,1));
        int nx,ny;
        int result = 0;
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == N-1 && now.y == N-1){
//                System.out.println("x: "+now.x + " , y: "+now.y + " ,check : "+now.check);
                result ++;
                continue;
            }
//            if(now.check == 2){
//                for(int d = 0; d < 2; d++){
//                    nx = now.x + dx[d];
//                    ny = now.y + dy[d];
//                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny] ==0){
//                        q.offer(new Point(d,nx,ny));
//                    }
//                }
//            }else{ //방향 그대로 넣어줌
//                nx = now.x + dx[now.check];
//                ny = now.y + dy[now.check];
//                if(nx >= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny] ==0){
//                    q.offer(new Point(now.check,nx,ny));
//                }
//            }

            int cnt = 0;
            for(int d = 0; d < 3; d++){
                nx = now.x+dx[d];
                ny = now.y+dy[d];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny] == 0) {
                    cnt++;
                    if(now.check == d && now.check != 2 && d<2){
//                        System.out.println("x: "+nx + " , y: "+ny + " ,check : "+now.check);
                        q.offer(new Point(now.check,nx,ny));
                    }else if(now.check == 2 && d != 2){
//                        System.out.println("x: "+nx + " , y: "+ny + " ,check : "+now.check);
                        q.offer(new Point(d,nx,ny));
                    }
                }
            }
//            System.out.println("////");

            if(cnt == 3){ //대각선 가능하면 넣어줌
                q.offer(new Point(2,now.x+1,now.y+1));
            }
        }
        System.out.println(result);
    }

    public static class Point{
        int check,x,y;
        public Point(int check, int x, int y){
            this.check = check;
            this.x = x;
            this.y = y;
        }
    }
}
