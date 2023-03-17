import java.io.*;
import java.util.*;

public class BJ_2206_벽부수고이동하기 {
    public static int N,M;
    public static int [][][] map;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [3][N][M]; // 0 -> map, 1 -> 부수기 있는 map, 2 -> 부수기 사용한 map

        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(input[j] == '1'){
                    map[0][i][j] = -1;
                    map[1][i][j] = -1;
                    map[2][i][j] = -1;
                }
            }
        }
        find();
    }
    public static void find(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,1,false));
        map[0][0][0] = -1;
        map[1][0][0] = 1;
        int nx,ny;
        int result = -1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if(now.x == N-1 && now.y == M-1){
                result = now.length;
                break;
            }
            if(!now.check){ // 부수기 가능한 경우
                for(int i = 0; i < 4; i++){ //부수기 하는 경우
                    nx = now.x +dx[i]*2;
                    ny = now.y + dy[i]*2;
                    if(nx>=0 && nx < N && ny >=0 && ny <M && map[0][nx][ny] == 0&& (map[2][nx][ny] == 0 || map[2][nx][ny] > now.length+2)){
                        map[2][nx][ny] = now.length + 2;
                        queue.offer(new Point(nx,ny,now.length+2, true));
                    }
                }
                for(int i = 0; i < 4; i++){ //부수기 안하는 경우
                    nx = now.x +dx[i];
                    ny = now.y +dy[i];
                    if(nx>=0 && nx < N && ny >=0 && ny <M && map[0][nx][ny] == 0&& ( map[1][nx][ny] == 0 || map[1][nx][ny] > now.length+1)){
                        map[1][nx][ny] = now.length+1;
                        queue.offer(new Point(nx,ny,now.length+1,false));
                    }
                }
            }else{
                for(int i = 0; i < 4; i++){
                    nx = now.x + dx[i];
                    ny = now.y + dy[i];
                    if(nx>=0 && nx < N && ny >=0 && ny <M && map[0][nx][ny] == 0&& ( map[2][nx][ny] == 0 || map[2][nx][ny] > now.length+1)){
                        map[2][nx][ny] = now.length + 1;
                        queue.offer(new Point(nx,ny,now.length+1, true));
                    }
                }
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(map[1][i][j]);
//            }
//            System.out.println();
//        }
//
//        System.out.println("//////////////////////////");
//
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(map[2][i][j]);
//            }
//            System.out.println();
//        }

//        int result = 0;
//        if(map[1][N-1][M-1] == 0 && map[2][N-1][M-1] == 0) result = -1;
//        else if(map[1][N-1][M-1] == 0 || map[2][N-1][M-1] == 0) result = Math.max(map[1][N-1][M-1], map[2][N-1][M-1]);
//        else result = Math.min(map[1][N-1][M-1], map[2][N-1][M-1]);
        System.out.println(result);

    }

    public static class Point{
        int x,y,length;
        boolean check;

        public Point(int x, int y, int length, boolean check){
            this.x = x;
            this.y = y;
            this.length = length;
            this.check = check;
        }
    }
}
