package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_18808_스티커붙이기 {
    public static int N,M,K;
    public static int[][] data;
    public static int[][] sticker;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int size = Math.max(X,Y);
            sticker = new int[size][size];
            for(int x = 0; x < X; x++){
                st = new StringTokenizer(br.readLine());
                for(int y = 0; y  < Y; y++){
                    sticker[x][y] = Integer.parseInt(st.nextToken());
                }
            }
            for(int j = 0; j < 4; j++){
                if(find(size)){ // 스티커 붙이면 탈출
//                    printData();
                    break;
                }
                rotate(size); // 90도 회전 후 왼쪽위로 붙이기
            }
        }
        printResult();
    }
    public static  void printResult(){
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(data[i][j] == 1){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    public static void rotate(int size){
        int[][] copySticker = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                copySticker[j][size-i-1] = sticker[i][j];
            }
        }
        sticker = copySticker;
        int cnt = 0;
        for(int i = 0; i < size; i++){
            boolean check = false;
            for(int j = 0; j < size; j++){
                if(sticker[i][j] == 1){
                    check = true;
                    break;
                }
            }
            if(check) break;
            cnt++;
        }
        moveSticker(cnt,0,size);

        cnt = 0;
        for(int j = 0; j < size; j++){
            boolean check = false;
            for(int i = 0; i < size; i++){
                if(sticker[i][j] == 1){
                    check = true;
                    break;
                }
            }
            if(check) break;
            cnt++;
        }
        moveSticker(0,cnt,size);


//        System.out.println("adfkjlsdjf;lkasdjf");
//        for(int i = 0; i < size; i++){
//            System.out.println(Arrays.toString(sticker[i]));
//        }
    }
    public static void moveSticker(int x, int y, int size){
        int[][] copy = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(sticker[i][j] == 1){
                    copy[i-x][j-y] =1;
                }
            }
        }
        sticker = copy;
    }


    public static boolean find(int size){
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(sticker[i][j] == 1){
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        int xLength = N-maxX;
        int yLength = M-maxY;
        for(int i = 0; i < xLength; i++){
            for(int j = 0; j < yLength; j++){
                if(choose(i,j, maxX, maxY)){
                    copy(i,j,maxX,maxY);
                    return true;
                }
            }
        }
        return false;
    }
    public static void copy(int x, int y,int maxX, int maxY){
        for(int i = 0; i <= maxX; i++){
            for(int j = 0; j <= maxY; j++){
                if(sticker[i][j] == 1){
                    data[i+x][j+y] = 1;
                }
            }
        }
    }

    public static boolean choose(int x, int y, int maxX, int maxY){
        for(int i = 0; i <= maxX; i++){
            for(int j = 0 ; j <= maxY; j++){
                if(sticker[i][j] == 1 && data[i+x][j+y] == 1){ // 스티커 자리에 이미 붙여져 있따면 이자리엔 못붙임
                    return false;
                }
            }
        }
        return true;
    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("-=========================================");
    }
}
