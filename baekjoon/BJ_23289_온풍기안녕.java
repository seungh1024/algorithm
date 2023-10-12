package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_23289_온풍기안녕 {
    public static int[][] dx ={
            {0},
            {-1,0,1},
            {-1,0,1},
            {-1,-1,-1},
            {1,1,1}
    };
    public static int[][] dy = {
            {0},
            {1,1,1},
            {-1,-1,-1},
            {-1,0,1},
            {-1,0,1}
    };
    public static int[][] wx = { // 벽 있는지 확인하기 위한 방향 정보
            {0},
            {-1,0,1},
            {-1,0,1},
            {0,0,0},
            {0,0,0}
    };
    public static int[][] wy = {
            {0},
            {0,0,0},
            {0,0,0},
            {-1,0,1},
            {-1,0,1}
    };
    public static int[] mx = {0,0,0,-1,1};
    public static int[] my = {0,1,-1,0,0};
    public static boolean[][][][] wall;
    public static List<Heater> heaters; //히터 정보
    public static List<Point> points; // 조사할 곳 정보
    public static int[][] data; // 맵 정보
    public static int chocolate, total;
    public static int R,C,K,W;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[R+1][C+1];
        wall = new boolean[R+1][C+1][R+1][C+1];
        heaters = new ArrayList<>();
        points = new ArrayList<>();
        chocolate = 0;
        total = 0;
        for(int i = 1; i <= R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input > 0 && input < 5){
                    heaters.add(new Heater(i,j,input));
                }else if(input == 5){
                    points.add(new Point(i,j));
                    total++;
                }
            }
        }
        W = Integer.parseInt(br.readLine());

        for(int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if(t == 0){
                wall[x][y][x-1][y] = true;
                wall[x-1][y][x][y] = true;
            }else if(t == 1){
                wall[x][y][x][y+1] = true;
                wall[x][y+1][x][y] = true;
            }

        }
        move();
    }
    public static void move(){
        while(true){
            for(Heater heater : heaters){
                heatRoom(heater);
            }
            spreadHeat();
            minusHeat();
            chocolate++;
            if(chocolate>100){
                break;
            }
            if(resultCheck()){
                break;
            }
        }
        System.out.println(chocolate);
    }

    private static boolean resultCheck() {
        int cnt = 0;
        for(Point p :points){
            if(data[p.x][p.y] >= K){
                cnt++;
            }
        }
        if(cnt == total){
            return true;
        }
        return false;
    }

    private static void minusHeat() {
        int[] next = {1,4,2,3};
        int d = 0;
        int x = 1;
        int y = 1;
        for(int i = 0; i < 4; i++){
            while(true){
                int nx = x+mx[next[d]];
                int ny = y+my[next[d]];
                if(isValid(nx,ny)){
                    if(data[nx][ny] >= 1){
                        data[nx][ny]--;
                    }
                }else{
                    d ++;
                    break;
                }
                x = nx;
                y = ny;
            }
        }
    }

    public static void spreadHeat(){
        int[][] copy = new int[R+1][C+1];
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                copy[i][j] += data[i][j];
                if(j+1 <= C && !wall[i][j][i][j+1]){
                    int right = (data[i][j] - data[i][j+1])/4;
                    copy[i][j] -= right;
                    copy[i][j+1] += right;
                }
                if(i+1 <= R && !wall[i][j][i+1][j]){
                    int bottom = (data[i][j] - data[i+1][j])/4;
                    copy[i][j] -= bottom;
                    copy[i+1][j] += bottom;
                }

            }
        }
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                data[i][j] = copy[i][j];
            }
        }
    }

    public static void heatRoom(Heater heater){
        int x = heater.x;
        int y = heater.y;
        int d = heater.d;
        boolean[][] copy = new boolean[R+1][C+1];
        Queue<int[]> q = new LinkedList<>();

        int xmx = x+mx[d];
        int ymy = y+my[d];
        if(isValid(xmx,ymy)){
            copy[xmx][ymy] = true;
            data[xmx][ymy] += 5;
            q.offer(new int[]{xmx,ymy});
        }

        for(int i = 4; i > 0; i--){
            int size = q.size();
            for(int s= 0; s < size; s++){
                int[] now = q.poll();
                for(int j = 0; j < 3; j++){
                    int vx = now[0] + wx[d][j];
                    int vy = now[1] + wy[d][j];
                    int nx = now[0] + dx[d][j];
                    int ny = now[1] + dy[d][j];
                    if(isValid(nx,ny) && wallValid(now[0],now[1],vx,vy,nx,ny,j) && !copy[nx][ny]){
                        copy[nx][ny] = true;
                        data[nx][ny] += i;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }

    public static boolean wallValid(int x, int y,int vx, int vy, int nx, int ny, int t){
        if(t == 1){
            if(!wall[x][y][nx][ny]) return true;
        }else{
            if(!wall[x][y][vx][vy] && !wall[vx][vy][nx][ny]) return true;
        }
        return false;
    }

    public static boolean isValid(int x, int y){
        if(x > 0 && x <= R && y > 0 && y <= C){
            return true;
        }
        return false;
    }

    public static void printData(){
        for(int i = 1; i <= R; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("=================");
    }

    public static class Heater{
        int x,y,d;
        public Heater(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
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
