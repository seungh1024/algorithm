package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_17780_새로운게임 {
    public static int[] dx = {0, 0,0,-1,1};
    public static int[] dy = {0, 1,-1, 0,0};
    public static int N, K;
    public static int[][] chessMap;
    public static Stack<Integer> redBlock; // 빨간색 블록인 경우 이동하는 말 순서 반대
    public static ArrayList<Integer>[][] horseMap;
    public static Horse[] horses;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        chessMap = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                chessMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        horseMap = new ArrayList[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                horseMap[i][j] = new ArrayList<>();
            }
        }
        horses = new Horse[K];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            horses[i] = new Horse(x,y,d,1);
            horseMap[x][y].add(i); // 몇 번째 말이 해당 칸에 있는지 넣음
        }
        redBlock = new Stack<>();
        move();
    }
    public static void move(){
        int turn = 0;
        while(turn++<1000){
            for(int i = 0; i < K; i++){
                Horse horse = horses[i];
                if(horse.level > 1)continue; // 맨 밑이 아니면 이동 안함

                int nx = horse.x+dx[horse.d];
                int ny = horse.y+dy[horse.d];
                if(nx > 0 && nx <= N && ny > 0 && ny <= N){
                    int size = horseMap[nx][ny].size();

                    if(chessMap[nx][ny] == 0){ //흰색
                        if(size + horseMap[horse.x][horse.y].size() >=4){ // 4이상 종료
                            System.out.println(turn);
                            return;
                        }
                        wrMove(0,horse.x,horse.y,nx,ny,size);
                    }else if(chessMap[nx][ny] == 1){// 빨간색
                        if(size + horseMap[horse.x][horse.y].size() >=4){ // 4이상 종료
                            System.out.println(turn);
                            return;
                        }
                        wrMove(1,horse.x,horse.y,nx,ny,size);
                    }else if(chessMap[nx][ny] == 2){// 파란색
                        if(bMove(horse.x,horse.y)){
                            System.out.println(turn);
                            return;
                        }
                    }
                }else{
                    if(bMove(horse.x,horse.y)){
                        System.out.println(turn);
                        return;
                    }
                }
                int idx = 1;
//                for(Horse h :horses){
//                    System.out.println("idx: "+idx + ", [horse] : "+h);
//                    idx++;
//                }
//                System.out.println("=================");
            }
//            System.out.println("========== cycle end ===========" +"  , turn : "+turn);
//            System.out.println();
        }
        System.out.println(-1);
    }
    public static boolean bMove(int x, int y){
        int horseNum = horseMap[x][y].get(0);
        int d = horses[horseNum].d;
        if(d == 1 || d == 3){
            d++;
        }else if(d == 2 || d == 4){
            d--;
        }
        horses[horseNum].d = d;
        int nx = x+dx[d];
        int ny = y+dy[d];
        if(nx > 0 && nx <= N && ny > 0 && ny <= N){
            int size = horseMap[nx][ny].size();
            if(chessMap[nx][ny] == 0){
                if(size + horseMap[x][y].size() >=4){ // 4이상 종료
                    return true;
                }
                wrMove(0,x,y,nx,ny,size);
            }else if(chessMap[nx][ny] == 1){
                if(size + horseMap[x][y].size() >=4){ // 4이상 종료
                    return true;
                }
                wrMove(1,x,y,nx,ny,size);
            }
        }
        return false;
    }
    public static void wrMove(int color, int x, int y, int nx, int ny, int size){
        if(color == 0){
            for(Integer horseNum : horseMap[x][y]){
                horseMap[nx][ny].add(horseNum);
                horses[horseNum].x = nx;
                horses[horseNum].y = ny;
                horses[horseNum].level = ++size;
//                System.out.println(size);
            }
        }else if(color == 1){
            for(Integer horseNum :horseMap[x][y]){
                redBlock.push(horseNum);
            }
            while(!redBlock.isEmpty()){
                int horseNum = redBlock.pop();
//                System.out.println("horsenum: "+horseNum);
                horseMap[nx][ny].add(horseNum);
                horses[horseNum].x = nx;
                horses[horseNum].y = ny;
                horses[horseNum].level = ++size;
            }
//            System.out.println(size);
        }
        horseMap[x][y].clear();
    }
    public static class Horse{
        int x,y,d,level;
        public Horse(int x, int y, int d, int level){
            this.x = x;
            this.y = y;
            this.d = d;
            this.level = level;
        }
        @Override
        public String toString(){
            return "x: "+x+", y: "+y+", d: "+d+ ", level: "+level;
        }
    }
}
