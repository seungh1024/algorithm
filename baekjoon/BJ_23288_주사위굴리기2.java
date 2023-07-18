package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_23288_주사위굴리기2 {
    public static int N,M,K;
    public static int[][] data;
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {-1,0,1,0};
    public static int d;
    public static int[] dice = {4,1,3,6,2,5};
    public static int[] copy = {4,1,3,6,2,5};
    public static int x,y;
    public static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        x = 0;
        y = 0;
        d = 2;
        for(int i = 0; i < K; i++){
            move();
        }
        System.out.println(result);
    }
    public static void move(){
        int nx = x+dx[d];
        int ny = y+dy[d];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M){
            d = (d+2)%4;
            nx = x+dx[d];
            ny = y+dy[d];
        }
        x = nx;
        y = ny;
        if(d %2 == 0){
            leftRight();
        }else{
            upDown();
        }
        score();
        changeD();
        diceCopy();
    }
    public static void changeD(){
        int num = data[x][y];
        if(dice[3] > num){
            d = (d+1)%4;
        }else if(dice[3] < num){
            d = (d+3)%4;
        }
    }
    public static void score(){
        Queue<int[]> q = new LinkedList<>();
        int num = data[x][y];
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {x,y});
        visited[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && data[nx][ny] == num){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        result += num*cnt;
    }

    public static void leftRight(){
        int dd = 0;
        if(d == 2){
            dd = 1;
        }else if(d == 0){
            dd = 3;
        }
        for(int i = 0; i < 4; i++){
            dice[(i+dd)%4] = copy[i];
        }

    }
    public static void upDown(){
        if(d == 1){
            dice[1] = copy[5];
            dice[3] = copy[4];
            dice[4] = copy[1];
            dice[5] = copy[3];
        }else if(d == 3){
            dice[1] = copy[4];
            dice[3] = copy[5];
            dice[4] = copy[3];
            dice[5] = copy[1];
        }
    }

    public static void diceCopy(){
        for(int i = 0; i < 6; i++){
            copy[i] = dice[i];
        }
    }
}
