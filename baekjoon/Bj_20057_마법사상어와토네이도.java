package algo_202304;

import java.io.*;
import java.util.*;

public class Bj_20057_마법사상어와토네이도 {
    public static int N;
    public static int[][]data;
    public static boolean[][] check;
    public static int d;
    public static int[] dx = {0,1,0,-1}; // 왼, 아래, 오, 위
    public static int[] dy = {-1,0,1,0};
    public static int m; // mx,my 시작점
    public static int[] mx = {-2,-1,-1,0,0,-1,2,1,1, 0, 0,1}; // 먼지 이동 위치. 시계방향으로 돌아야 함
    public static int[] my = { 0, 0,-1,2,1, 1,0,0,1,-2,-1,-1};
    public static double[] mv = {0.02,0.07,0.1,0.0,0.0,0.01,0.02,0.07,0.01,0.05,0.0,0.1};
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        check = new boolean[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int start = N/2;
        check[start][start] = true;
        result = 0;
        move(start);
        System.out.println(result);
    }
    public static void move(int start){
        d = 0;
        m = 0;
        int x = start;
        int y = start;
        int dust = 0;
        while(!(x==0 && y == 0)){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx <0 || nx >= N || ny < 0 || ny >=N){ //벽을 넘어서면 회전
                d = (d+1)%4;
                m = (m+3)%12;
//                System.out.println("회전!");
                continue;
            }
            dust = data[nx][ny];
            moveDust(dust,nx,ny);
            data[nx][ny] = 0;
            x = nx;
            y = ny;
            check[x][y] = true;
            nx = x + dx[(d+1)%4];
            ny = y +dy[(d+1)%4];
            if(!check[nx][ny]){ //아직 방문 안했으면 회전
                d = (d+1)%4;
                m = (m+3)%12;
            }
//            System.out.println("x: "+x +" , y: "+y);
//            System.out.println("result: "+result);
//            printData();
        }
    }
    public static void moveDust(int dust,int x, int y){
        int idx = m;
        int sum = 0;
        for(int i = 0; i < 12; i++){
            int nx = x+mx[i];
            int ny = y+my[i];
            int value = (int)(dust*mv[idx]);
            if(nx>= 0 && nx < N && ny >= 0 && ny < N){
                data[nx][ny] += value;
            }else{ // 밖으로 나간건 결과값에 더해줌
                result += value;
            }
            sum += value;
            idx = (idx+1)%12;
        }
        dust = dust-sum;
        int nx = x+dx[d];
        int ny = y+dy[d];
        if(nx>=0 && nx < N && ny >= 0 && ny < N){
            data[nx][ny] +=dust;
        }else{
            result += dust;
        }

    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("//////////////////");
    }
}
