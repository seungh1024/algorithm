package algo_202310;

import java.io.*;
import java.util.*;

public class CT_메이즈러너 {
    public static int N,M,K;
    public static int[][] data;
    public static int[][] dataCount;
    public static List<Player> players; // 참가자 위치
    public static int ex,ey;
    public static int[]dx = {-1,1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N+1][N+1];
        dataCount = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        players = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Player input = new Player(x,y);
            players.add(input);
            data[x][y] = -1;
            dataCount[x][y]++;
        }
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        data[ex][ey] = -2;
        result = 0;

        mazeRunner();
    }

    public static void mazeRunner(){
        int k = 0;
        while(k++<K){
            move();
            if(!initPlayer()){
                break;
            }
            spin();
            initPlayer();
        }
        System.out.println(result);
        System.out.println(ex+" "+ey);
    }

    public static boolean initPlayer(){
        int cnt = 0;
        players.clear();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(data[i][j] == -1){
                    for(int k = 0; k < dataCount[i][j]; k++){
                        Player p = new Player(i,j);
                        players.add(p);
                        cnt++;
                    }
                }
            }
        }
        if(cnt>0){ // 사람 존재
            return true;
        }
        return false;
    }

    public static void move(){
        for(Player p :players){
            int minLength = Math.abs(p.x-ex) + Math.abs(p.y-ey);
            for(int d = 0; d <4; d++){
                int nx = p.x+dx[d];
                int ny = p.y+dy[d];
                if(nx == ex && ny == ey){
                    dataCount[p.x][p.y]--;
                    if(dataCount[p.x][p.y] == 0){
                        data[p.x][p.y] = 0;
                    }
                    result++;
                    break;
                }
                int length = Math.abs(nx-ex) + Math.abs(ny - ey);
                if(isMove(nx,ny) && length < minLength){
                    dataCount[p.x][p.y] --;
                    if(dataCount[p.x][p.y] == 0){
                        data[p.x][p.y] = 0;
                    }
                    dataCount[nx][ny]++;
                    data[nx][ny] = -1;
                    p.x = nx;
                    p.y = ny;
                    result++;
                    break;
                }
            }
        }
    }

    public static void spin(){
        Square s = findSquare();
        int size= s.r+1;
        int[][] copy = new int[size][size];
        int[][] copyCount = new int[size][size];
        int x = s.lx;
        int y = s.ly;
        for(int i = 0; i < size; i++){
            y = s.ly;
            for(int j = 0; j < size; j++){
                copy[i][j] = data[x][y];
                copyCount[i][j] = dataCount[x][y];
                y++;
            }
            x++;
        }

        int[][] spinCopy = new int[size][size];
        int[][] spinCountCopy = new int[size][size];

        y = size-1;
        for(int i = 0; i < size; i++){
            x = 0;
            for(int j = 0; j < size; j++){
                spinCopy[x][y] = copy[i][j];
                spinCountCopy[x][y] = copyCount[i][j];
                if(spinCopy[x][y] > 0){
                    spinCopy[x][y]--;
                }
                x++;
            }
            y--;
        }

        x = s.lx;
        for(int i = 0; i < size; i++){
            y = s.ly;
            for(int j = 0; j < size; j++){
                data[x][y] = spinCopy[i][j];
                dataCount[x][y] = spinCountCopy[i][j];
                if(data[x][y] == -2){
                    ex = x;
                    ey = y;
                }
                y++;
            }
            x++;
        }

    }

    public static Square findSquare(){
        Square s = new Square(1,1,N,N,N);
        for(Player p : players){
            int xsize = Math.abs(p.x-ex);
            int ysize = Math.abs(p.y-ey);
            int lx = Math.min(p.x,ex);
            int rx = Math.max(p.x,ex);
            int ly = Math.min(p.y,ey);
            int ry = Math.max(p.y,ey);

            int size = xsize;
            if(xsize > ysize){ // x길이가 정사각형 길이 -> y값만 조율하면 됨
                int moveCnt = size - ysize;
                if(ly - moveCnt <= 1){
                    moveCnt -= ly-1;
                    ly = 1;
                }else{
                    ly -= moveCnt;
                    moveCnt = 0;
                }
                ry += moveCnt;



            }else if(xsize <ysize){ // y길이가 정사각형 길이 -> x값만 조율하면 됨
                size = ysize;
                int moveCnt = size - xsize;
                if(lx - moveCnt <= 1){
                    moveCnt -= lx-1;
                    lx = 1;
                }else{
                    lx -= moveCnt;
                    moveCnt = 0;
                }
                rx += moveCnt;


            }
            s = squareCompare(s,new Square(lx,ly,rx,ry,size));
        }
        return s;
    }

    public static Square squareCompare(Square s1, Square s2){
        if(s1.r == s2.r){
            if(s1.lx == s2.lx){
                return s1.ly > s2.ly ?s2 : s1;
            }else{
                return s1.lx > s2.lx ? s2 : s1;
            }
        }else{
            return s1.r>s2.r ? s2:s1;
        }
    }

    public static boolean isMove(int x, int y){
        if(x > 0 && x <= N && y > 0 && y <= N && data[x][y] <= 0){
            return true;
        }
        return false;
    }

    public static class Player{
        int x,y;

        public Player(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "x: " + x + ",y: " + y;
        }
    }

    public static void printData(){
        System.out.println("========= print Data ===========");
        for(int i = 0; i <= N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("========== print data end==========");
    }
    public static class Square{
        int lx,ly,rx,ry,r;

        public Square(int lx, int ly,int rx, int ry, int r){
            this.lx=lx;
            this.ly=ly;
            this.rx=rx;
            this.ry=ry;
            this.r=r;
        }

        @Override
        public String toString(){
            return "lx: "+lx +", ly: "+ly +", rx: "+rx +", ry: "+ry + ", r: "+r;
        }
    }
}
