package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_21069_상어중학교 {
    public static int N, M, R;
    public static int blockSize, rainbow;
    public static Point center;
    public static Queue<Point> q;
    public static int[][] data;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = M+1;
        data = new int[N][N];
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< N; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 0) input = R; // rainbow = M+1;
                data[i][j] = input;
            }
        }
//        printData();
        playGame();
    }
    public static void printData(){
        for(int i = 0; i< N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("================");
    }
    public static void playGame(){
        result = 0;
        while(true){
            if(!find()){
                break;
            }
            deleteBlock();
            down();
            turn();
            down();
//            printData();
        }
//        find();
//        deleteBlock();
//        down();
////        printData();
//        turn();
//        down();
//        printData();
        System.out.println(result);
    }

    public static boolean find(){
        q = new LinkedList<>();
        blockSize = 0;
        rainbow = 0;
        center = new Point(-1,-1);

        boolean[][] totalCheck = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(data[i][j] >0 && data[i][j] <= M && !totalCheck[i][j]){
                    totalCheck[i][j] = true;
                    makeBlock(i,j, totalCheck);
                }
            }
        }
        if(blockSize < 2){
            return false;
        }else{
            return true;
        }
    }
    public static void makeBlock(int x, int y,boolean[][] totalCheck){
        int size = 1;
        int rSize = 0;
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(x,y));

        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = now.x+dx[d];
                int ny = now.y +dy[d];
                if(isValid(nx,ny) && !visited[nx][ny] && (data[nx][ny] == data[x][y] || data[nx][ny] == R)){
                    Point input = new Point(nx,ny);
                    queue.offer(input);
                    list.add(input);
                    visited[nx][ny] = true;
                    totalCheck[nx][ny] = true;
                    size ++;
                    if(data[nx][ny] == R){
                        rSize++;
                    }
                }
            }
        }
        if(size == 1) return; // 그룹형성 안되면 리턴

        boolean check = false;
        if(blockSize < size){
            check = true;
        }else if(blockSize == size){
            if(rainbow < rSize){
                check = true;
            }else if(rainbow == rSize){
                if(center.x < x){
                    check = true;
                }else if(center.x == x){
                    if(center.y < y){
                        check = true;
                    }
                }
            }
        }
        if(check){ // 새로 들어온게 더 큰 블록 그룹
            q.clear();
            for(Point p : list){
                q.offer(p);
            }
            blockSize = size;
            rainbow = rSize;
            center.x = x;
            center.y = y;
        }
    }
    public static boolean isValid(int x, int y){
        if(x >= 0 && x < N && y >= 0 && y < N){
            return true;
        }
        return false;
    }

    public static void deleteBlock(){
        while(!q.isEmpty()){
            Point now = q.poll();
            data[now.x][now.y] = 0;
        }
        result += blockSize*blockSize;
    }
    public static void down(){
        for(int j = 0; j < N; j++){
            for(int i = N-1; i >= 0; i--){
                if(data[i][j] > 0 && data[i][j] <=R){
                    int idx = i;
                    while(true){
                        idx++;
//                        System.out.println("x" +i+", y: "+j + ", idx : "+idx);
                        if(idx == N || data[idx][j] ==-1 || (data[idx][j] >0 && data[idx][j] <=R)){
                            if(data[idx-1][j] == 0) {
                                data[idx - 1][j] = data[i][j];
                                data[i][j] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void turn(){
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                copy[N-1-j][i] = data[i][j];
            }
        }
        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                data[i][j] = copy[i][j];
            }
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
