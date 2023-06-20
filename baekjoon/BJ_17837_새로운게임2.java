package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_17837_새로운게임2 {
    public static int N,K;
    public static int[][] data; // 0 : 흰, 1 : 빨, 2 : 파
    public static int[][][] map; // 3차원 배열로 데이터 층 쌓기
    public static int[][] index; //3차원 배열의 각 x,y의 길이를 저장
    public static Point[] points;
    public static int[] dx = {0,0,0,-1,1};
    public static int[] dy = {0,1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N ; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        points = new Point[K+1]; //1번부터
        map = new int[N+1][N+1][K+1];
        index = new int[N+1][N+1];
        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            points[i] = new Point(x,y,d);
            index[x][y] ++;
            map[x][y][index[x][y]] = i;
        }
//        printIndex();
//        printMap();
        move();
    }

    public static void move(){
        int turn = 0;
        while(turn <= 1000){
            turn++;
            for(int i = 1; i <= K; i++){
                int x = points[i].x;
                int y = points[i].y;
                int d = points[i].d;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx > 0 && nx <= N && ny > 0 && ny <= N){ //범위안 -> 흰, 빨, 파
//                    System.out.println("num: "+ i + ", nx: "+nx + ", ny: "+ny + ", d: "+d);
                    if(data[nx][ny] == 0){ //흰
                        if(white(i,nx,ny)){
                            System.out.println(turn);
                            return;
                        }
                    }else if(data[nx][ny] == 1){ //빨
                        if(red(i,nx,ny)){
                            System.out.println(turn);
                            return;
                        }
                    }else{ // 파
                        if(blue(i)){
                            System.out.println(turn);
                            return;
                        }
                    }
                }else{ //범위 밖 -> 파란색 취급
                    if(blue(i)){
                        System.out.println(turn);
                        return;
                    }
                }
//                printMap();
            }
        }
        System.out.println(-1);

    }
    public static int findIdx(int idx, int length, int x, int y){
//        System.out.println("x: "+x+ ", y: "+y + ", idx: "+idx + ", length: "+length);
        int result = 0;
        for(int i = 1; i <= length; i++){
            if(map[x][y][i] == idx){
                result =  i;
                break;
            }
        }
        return result;
    }
    public static boolean white(int idx,int nx, int ny){ // 몇 번째 말이 이동하는지 idx
        int x = points[idx].x;
        int y = points[idx].y;
        int length = index[x][y]; // 이동할 객체의 위치에 몇 개가 있는지
        int start = findIdx(idx,length,x,y);
//        System.out.println("start: "+start);

        for(int i = start; i <= length; i++){
            int num = map[x][y][i];
            points[num].x = nx;
            points[num].y = ny; //해당 체스말 좌표 변경
            map[x][y][i] = 0;
            index[x][y] --;
            index[nx][ny]++;
            if(index[nx][ny] >=4){
                return true;
            }
            map[nx][ny][index[nx][ny]] = num;
        }
//        printMap();
//        printIndex();
//        System.out.println("========end white===========");

        return false;
    }
    public static boolean red(int idx,int nx, int ny){
        int x = points[idx].x;
        int y = points[idx].y;
        int length = index[x][y]; // 이동할 객체의 위치에 몇 개가 있는지
        int start = findIdx(idx,length,x,y);
//        System.out.println("start: "+start);
        for(int i = length; i >= start; i--){
            int num = map[x][y][i];
            points[num].x = nx;
            points[num].y = ny;
            map[x][y][i] = 0;
            index[x][y]--;
            index[nx][ny] ++;
            if(index[nx][ny] >= 4){
                return true;
            }
            map[nx][ny][index[nx][ny]] = num;
        }
//        printMap();
//        printIndex();
//        System.out.println("========end red===========");
        return false;
    }
    public static boolean blue(int idx){
        int x = points[idx].x;
        int y = points[idx].y;
        int d = points[idx].d;

        if(d%2 == 1){ // 방향 바꾸기 나가거나 블루 영역에 들어왔으니 방향 바꿈
            d++;
        }else{
            d--;
        }
        points[idx].d = d;

        int nx = x +dx[d];
        int ny = y +dy[d]; // 반대 방향으로 세팅
//        System.out.println(points[idx]);
        if(nx>0 && nx <= N && ny > 0 && ny <= N){
//            System.out.println("blue check");
            if(data[nx][ny] == 0){
//                System.out.println("blue check white");
                return white(idx,nx,ny);
            }else if(data[nx][ny] == 1){
//                System.out.println("blue check red");
                return red(idx,nx,ny);
            }
        }

//        printMap();
//        printIndex();
//        System.out.println("=========== end blue ===========");

        return false;
    }

    public static void printMap(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.println(Arrays.toString(map[i][j]));
            }
            System.out.println("/////////////");
        }
        System.out.println("||||| end of print map |||||||||");
    }
    public static void printIndex(){
        System.out.println("=====================");
        for(int i = 1; i <= N; i++){
            System.out.println(Arrays.toString(index[i]));
        }
        System.out.println("=====================");
    }

    public static class Point{
        int x,y, d;
        public Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public String toString(){
            return "x: "+x + ", y: "+ y + ", d: "+d;
        }
    }
}
