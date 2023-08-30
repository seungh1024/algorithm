package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_23291_어항정리 {
    public static int N,K;
    public static int[] data;
    public static int[][] spinData;
    public static int[] dx = {0,-1};
    public static int[] dy = {1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        find();
    }

    public static void find(){
        int cnt = 0;
        while(true){
            if(loopBreak()){
                break;
            }
            cnt++;
            firstStep();
            secondStep();
        }
        System.out.println(cnt);
    }
    public static boolean loopBreak(){
        int maxNum = 0;
        int minNum = data[0];
        for(int i = 0; i < N; i++){
            maxNum = Math.max(maxNum,data[i]);
            minNum = Math.min(minNum,data[i]);
        }
        if(maxNum-minNum <= K){
            return true;
        }else{
            return false;
        }
    }

    public static void firstStep(){
        spinData = new int[N][N];
        int[] plusIndex = new int[N]; // 더해야하는 인덱스 저장
        int plusValue = data[0];
        int index = 1;
        spinData[N-1][0] = data[0];

        for(int j = 1; j < N; j++){
            spinData[N-1][j] = data[j];
            if(plusValue > data[j]){
                index = 1;
                plusValue = data[j];
                plusIndex[0] = j;
            }else if(plusValue == data[j]){
                plusIndex[index++] = j;
            }
        }

        for(int j = 0; j <index; j++){
            spinData[N-1][plusIndex[j]] ++;
        }

        spin();
    }
    public static void spin(){
        int height = 1;
        int length = 1;
        int cycle = 0;
        int x = N-1;
        int y = 0;
        while(cycle++ >= 0){
            if(y-1+height + length >= N) {
                spinOut(N-1,y);
                break;
            }
            int nx = N-2;
            for(int j = y+length-1; j >= y; j--){
                int ny = y+length;
                for(int i = x; i > x-height; i--){
                    spinData[nx][ny]  = spinData[i][j];
                    spinData[i][j] = 0;
                    ny++;
                }
                nx--;
            }
            y+=length;
            if(cycle % 2 == 0){
                length++;
            }else if(cycle%2==1){
                height++;
            }
        }
    }
    public static void spinOut(int x, int y){
        ArrayList<Point> moveList = new ArrayList<>();
        int index = 0;
        for(int j = y; j < N; j++){
            for(int i = x; i >= 0; i--){
                if(spinData[i][j] == 0) break;
                moveList.add(new Point(i,j,index));
                index++;
            }
        }
        ArrayList<Point> addList = new ArrayList<>();
        for(Point now : moveList){
            for(int d = 0; d <2; d++){
                int nx = now.x+dx[d];
                int ny = now.y+dy[d];
                if(nx>=0 && nx <N && ny >= 0 && ny < N && spinData[nx][ny]!=0){
                    int addValue = Math.abs(spinData[now.x][now.y]-spinData[nx][ny])/5;
                    if(addValue > 0){
                        if(spinData[now.x][now.y] > spinData[nx][ny]){
                            addList.add(new Point(now.x,now.y,nx,ny,addValue));// 큰쪽이 x,y / 작은쪽이 nx,ny
                        }
                        else{
                            addList.add(new Point(nx,ny,now.x,now.y,addValue));
                        }
                    }
                }
            }
        }
        for(Point now : addList){
            spinData[now.x][now.y] -= now.value;
            spinData[now.nx][now.ny] += now.value;
        }
        for(Point now : moveList){
            data[now.index] = spinData[now.x][now.y];
        }
    }

    public static void secondStep(){
        spinData = new int[N][N];
        for(int j = 0; j < N; j++){
            spinData[N-1][j] = data[j];
        }
        int end = N/2;
        int nx = N-2;
        int ny = N-1;
        for(int j = 0; j <end; j++){
            spinData[nx][ny] = spinData[N-1][j];
            spinData[N-1][j] = 0;
            ny--;
        }
        int start = end;
        end = end + end/2;
        for(int i = N-2; i < N; i++){
            nx--;
            ny = N-1;
            for(int j = start; j < end; j++){
                spinData[nx][ny] = spinData[i][j];
                spinData[i][j] = 0;
                ny--;
            }
        }
        spinOut(N-1,ny+1);
    }


    public static class Point{
        int x,y,nx,ny,index,value;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        public Point(int x, int y, int index){
            this.x=x;
            this.y=y;
            this.index=index;
        }
        public Point(int x, int y, int nx, int ny, int value){
            this.x=x;
            this.y=y;
            this.nx=nx;
            this.ny=ny;
            this.value=value;
        }
    }
}