package before230401;

import java.io.*;
import java.util.*;

public class BJ_14503_로봇청소기 {
    public static int[] dx = {-1,0,1,0}; // 북,서,남,동 반시계
    public static int[] dy = {0,-1,0,1};
    public static int[][] data;
    public static int rx,ry,look;
    public static int result;
    public static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        rx = Integer.parseInt(st.nextToken());
        ry = Integer.parseInt(st.nextToken());
        look = Integer.parseInt(st.nextToken());
        if(look == 1 || look ==3){
            look = (look+2)%4;
        }

        data = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <M ;j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find();
    }

    public static void find(){
        int nx,ny;
        while(true){
            boolean turn = false;
            if(data[rx][ry] == 0) {
                data[rx][ry] = -1;
                result++;
//                for(int i = 0; i < N; i++){
//                    System.out.println(Arrays.toString(data[i]));
//                }
//                System.out.println("////////////////////////////////");
            }
//            System.out.println("rx: "+rx + " , ry: "+ry + " ,look: "+look);
            for(int d = look; d < look+4; d++){
                nx = rx+dx[(d+1)%4];
                ny = ry+dy[(d+1)%4];
                if(nx>= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] ==0){
//                    System.out.println("nx: "+nx + " , ny: "+ny + " ,look: "+look);
                    rx = nx;
                    ry = ny;
                    look = (d+1)%4;
                    turn = true;
                    break;
                }
            }
            if(!turn){
//                System.out.println("turn");
                nx = rx + dx[(look+2)%4];
                ny = ry +dy[(look+2)%4];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] != 1){
                    rx = nx;
                    ry = ny;
                    turn = false;
                }else{
                    System.out.println(result);
//                    System.out.println("rx: "+rx + " , ry: "+ry + " ,look: "+look);
                    return;
                }
            }
        }
    }
}

//6 6
//2 1 3
//1 1 1 1 1 1
//1 0 0 0 0 1
//1 0 1 1 1 1
//1 0 1 1 1 1
//1 0 1 1 1 1
//1 1 1 1 1 1