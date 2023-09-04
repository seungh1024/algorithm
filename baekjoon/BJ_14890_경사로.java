package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_14890_경사로 {
    public static int N,L;
    public static int[][] data;
    public static boolean[][] visited;
    public static int result;
    public static int[] dx = {0,1};
    public static int[] dy = {1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find();
        System.out.println(result);
    }
    public static void find(){
        result = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            boolean check = true;
            for(int j = 1; j < N; j++){
                if(data[i][j] > data[i][j-1]){ // 경사가 높아진 경우
                    if(!wayCheck(i,i, j-L, j-1,data[i][j])){
                        check = false;
                        break;
                    }
                }else if(data[i][j] < data[i][j-1]){// 경사가 낮아진 경우
                    if(!wayCheck(i,i,j, j+L-1, data[i][j-1])){
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                result++;
            }
        }
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(visited[i]));
//        }
        visited = new boolean[N][N];
        for(int j = 0; j < N; j++){
            boolean check = true;
            for(int i = 1; i < N; i++){
                if(data[i][j] > data[i-1][j]){ //경사가 높아진 경우
                    if(!wayCheck(i-L,i-1,j,j,data[i][j])){
                        check =false;
                        break;
                    }
                }else if(data[i][j] < data[i-1][j]){ //경사가 낮아진 경우
                    if(!wayCheck(i,i+L-1,j,j,data[i-1][j])){
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                result++;
            }
        }

//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(visited[i]));
//        }
    }

    public static boolean wayCheck(int bx, int nx, int by ,int ny, int height){
        if(bx<0 || nx >= N || by < 0 || ny >= N){
            return false;
        }
        int startHeight = data[bx][by];
        for(int x = bx; x <= nx; x++){
            for(int y = by; y <= ny; y++){
                if(data[x][y] != startHeight || Math.abs(height-startHeight) > 1 || visited[x][y]){
                    return false;
                }else{
                    visited[x][y] = true;
                }
            }
        }
        return true;
    }


}

