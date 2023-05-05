package algo_202304;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class BJ_19236_청소년상어 {
    public static int[][] fish; // 물고기 위치
    public static int[][] way; // 방향 저장
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,-1,-1,-1,0,1,1,1};

//    public static int eat;
//    public static int fishCnt;

    public static int result;
    public static void main(String[] args) throws IOException{
        fish = new int[4][4];
        way = new int[4][4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int fishCnt = 0;

        for(int i = 0; i <4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 8; j++){
                if(j%2==0){
                    fish[i][j/2] = Integer.parseInt(st.nextToken());
                    fishCnt+=fish[i][j/2];
                }else{
                    way[i][j/2] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }
//        printFishWay();
        int eat = fish[0][0];
        fishCnt -= fish[0][0];
        fish[0][0]  = 0;
        result = 0;
//        printFishWay(fish,way);
        move(0,0, fish,way,fishCnt, eat);
        System.out.println(result);
    }
    public static void move(int x, int y, int[][] fishMap, int[][]wayMap, int fishCnt,int eat){
        if(fishCnt == 0){
            result = Math.max(result,eat);
            return;
        }
        int[][] fishCopy = copyFish(fishMap); //물고기 맵 복사
        int[][] fishWay = copyWay(wayMap); // 물고기 방향 복사
        int sharkWay = fishWay[x][y];
        moveFish(x,y,fishCopy,fishWay); //복사된 맵,방향 바탕으로 물고기 이동
//        System.out.println("sharkWay:"+sharkWay+", x: "+x+ " , y: "+y);
//        printFishWay(fishCopy,fishWay);
        int nx = x;
        int ny = y;
        while(true){
            nx += dx[sharkWay];
            ny += dy[sharkWay];
            if(nx>=0 && nx <4 && ny>=0 && ny<4){
                if(fishCopy[nx][ny] > 0) {
                    // 물고기 있으면 거기로 이동
//                    System.out.println("냠냠");
//                    System.out.println("x: "+x+", y:" +y +", nx: "+nx+ ", ny: "+ny + " ,fish: "+fishCopy[nx][ny]);
                    int eatFish = fishCopy[nx][ny];
                    fishCopy[nx][ny] = 0;
                    move(nx,ny,fishCopy,fishWay,fishCnt-eatFish,eat+eatFish);
                    fishCopy[nx][ny] = eatFish;
                }

            }else{ // 맵 밖이면 탈출
                break;
            }
        }

//        System.out.println("못먹었넹" + ", x: "+x +" ,y: "+y);
//        System.out.println(eat);
        result = Math.max(result,eat);
    }
    public static int[][] copyWay(int[][] wayMap){
        int[][] fishWay = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                fishWay[i][j] = wayMap[i][j];
            }
        }
        return fishWay;
    }
    public static int[][] copyFish(int[][] fishMap){
        int[][] fishCopy = new int[4][4];
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j++){
                fishCopy[i][j] = fishMap[i][j];
            }
        }
        return fishCopy;
    }
    // 물고기 움직이는 메소드
    public static void moveFish(int x, int y, int[][] fishCopy, int[][] wayCopy){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 물고기 있으면 찾아서 넣어줌. 개수 없는 것 부터 나오게
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(fishCopy[i][j] > 0){
                    pq.offer(fishCopy[i][j]);
                }
            }
        }


        while(!pq.isEmpty()){
            int nowCnt = pq.poll();
            int nowX = 0;
            int nowY = 0;
            // 현재 해당 값의 물고기 위치를 찾음
            for(int i = 0; i < 4; i++){
                for(int j = 0;j < 4; j++){
                    if(fishCopy[i][j] == nowCnt){
                        nowX = i;
                        nowY = j;
                        break;
                    }
                }
            }
            // 해당 물고기의 방향
            int nowWay = wayCopy[nowX][nowY];
//            System.out.println("nowWay: "+nowWay);
            // 돌면서 이동
            for(int i = 0; i < 8; i++){
                int nx = nowX+dx[nowWay%8];
                int ny = nowY+dy[nowWay%8];
//                System.out.println("nx: "+ nx +", ny:" +ny);
                if(nx>=0 && nx < 4 && ny >= 0 && ny <4 && !(nx==x && ny ==y)){
                    // 현재 물고기 위치, 이동할 물고기 위치 변경
                    int tempFish = fishCopy[nx][ny];
                    int tempWay = wayCopy[nx][ny];
//                    System.out.println("nowCnt: "+nowCnt + ",nowWay: "+nowWay+", nowX: "+nowX+ ", nowY: "+nowY + ",nx:"+nx+", ny:"+ny);
                    fishCopy[nx][ny] = fishCopy[nowX][nowY];
                    wayCopy[nx][ny] = nowWay%8;
                    fishCopy[nowX][nowY] = tempFish;
                    wayCopy[nowX][nowY] = tempWay;
                    break;
                }
                nowWay++;
            }

        }
    }

    public static class Point implements Comparable<Point>{
        int x,y,cnt;
        public Point(int x, int y , int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Point o){
            return this.cnt - o.cnt;
        }
    }

    public static void printFishWay(int[][] fishCopy, int[][] wayCopy){
        System.out.println("//////fish///////");
        for(int i = 0; i < 4; i++){
            System.out.println(Arrays.toString(fishCopy[i]));
        }
        System.out.println("/////////way////////");
        for(int i = 0; i < 4; i++){
            System.out.println(Arrays.toString(wayCopy[i]));
        }
    }
}
