import java.io.*;
import java.util.*;

public class BJ_2178_미로탐색 {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int N,M;
    public static int[][] check;

    public static void main(String[] args) throws IOException {
//        System.out.println('1'-0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new int[N][M];


        for(int i = 0; i < N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                check[i][j] = line[j] - 48;
            }
//            System.out.println(Arrays.toString(check[i]));
        }
        bfs();
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "x : "+this.x + " y: "+ this.y;
        }
    }
    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        check[0][0] = 0;
        int result = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            result ++;
            for(int i = 0; i < size; i++){
                Point now = queue.poll();
                int nx,ny;

                if(now.x == N-1 && now.y == M-1){
                    System.out.println(result);
                    return;
                }

//                System.out.println(result);
//                System.out.println(now);
                for(int d = 0; d < 4; d++){
                    nx = now.x+dx[d];
                    ny = now.y+dy[d];
                    if(nx >=0 && nx < N && ny >= 0 && ny < M && check[nx][ny] != 0){
//                        System.out.println(nx + " , "+ny);
                        queue.offer(new Point(nx,ny));
                        check[nx][ny] = 0;
                    }
                }
            }

        }

    }
}
