import java.io.*;
import java.util.*;

public class BJ_2573_빙산 {
    public static int N,M;
    public static int[][] data;
    public static ArrayList<Point> save;
    public static Queue<Point> q;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];

        q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int input = Integer.parseInt(st.nextToken());
                data[i][j] = input;
                if(input != 0){
                    q.offer(new Point(i,j,0));
                }
            }
        }
        find();
    }
    public static void find(){
        int nx,ny;
        int result = 0;
        while(!q.isEmpty()){
            save = new ArrayList<>();
            int size = q.size();
            for(int s = 0; s < size; s++){
                Point now = q.poll();
                int ice = data[now.x][now.y];
                for(int d = 0; d < 4; d++){
                    nx = now.x+dx[d];
                    ny = now.y + dy[d];
                    if(data[nx][ny] ==0) ice--;
                }
                if(ice > 0) save.add(new Point(now.x,now.y,ice));
                else save.add(new Point(now.x,now.y,0));
            }
            for(Point next:save){
                if(next.v == 0) data[next.x][next.y] = 0;
                else{
                    data[next.x][next.y] = next.v;
                    q.offer(next);
                }
            }
            result ++;
            if(isSeparated()) {
                System.out.println(result);
//                printMap();
                return;
            }
        }
        System.out.println(0);

    }
    public static void printMap(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }
    public static boolean isSeparated(){
        int size = 0;
        int[][] copy = new int[N][M];
        copyMap(copy);
        Queue<Point> queue = new LinkedList<>();
        Point first = null;
        for(Point next : save){
            if(next.v != 0){
                first = next;
                size++;
            }
        }
        if(first == null) return false;
        queue.offer(first);
        copy[first.x][first.y] = 0;
        int nx,ny;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            size --;
            for(int d = 0; d < 4; d++){
                nx = now.x +dx[d];
                ny = now.y +dy[d];
                if(copy[nx][ny] != 0){
                    queue.offer(new Point(nx,ny,0));
                    copy[nx][ny] = 0;
                }
            }
        }

        if(size != 0) {
            return true;
        }
        else return false;
    }

    public static void copyMap(int[][] copy){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copy[i][j] = data[i][j];
            }
        }
    }

    public static class Point{
        int x,y,v;
        public Point(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}
