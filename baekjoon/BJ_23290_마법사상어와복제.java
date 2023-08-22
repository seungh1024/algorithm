package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_23290_마법사상어와복제 {
    public static int M, S;
    public static FishInfo shark;
    public static int[] dx = {0,-1,-1,-1,0,1,1,1};
    public static int[] dy = {-1,-1,0, 1,1,1,0,-1};
    public static int[] dsx = {-1,0,1,0};
    public static int[] dsy = {0,-1,0,1};
    public static ArrayList<FishInfo> fishInfos; // 첫 생선 정보
    public static int[][] smells; // 냄새 정보
    public static int[][] fishCount; // 해당 칸에 생선 몇 마리 있는지
    public static ArrayList<FishInfo> fishList;
    public static PriorityQueue<SharkMoveInfo> pq;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        init();
        for(int i = 0; i <M; i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            fishInfos.add(new FishInfo(x,y,d));
            fishCount[x][y] ++;
            fishList.add(new FishInfo(x,y,d));
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        shark = new FishInfo(x,y);
        for(int i = 0; i < S; i++){
            move();
//            System.out.println("#################################" + i);
        }
        int result = 0;
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                if(fishCount[i][j] > 0){
                    result += fishCount[i][j];
                }
            }
        }
        System.out.println(result);
    }
    public static void move(){
//        printData();
        fishMove(); // 2
//        printData();
//        System.out.println("****************** fish move end *****************");
        sharkMove(); // 3
//        printData();
//        System.out.println("****************** shark move end *****************");
        smellGone(); // 4
//        printData();
//        System.out.println("****************** smell gone end *****************");
        copyFish(); // 5
//        printData();
//        System.out.println("****************** copy fish end *****************");
    }
    public static void fishMove(){
        for(FishInfo fish : fishList){
            int x = fish.x;
            int y = fish.y;
            int d = fish.d;
            int cnt = 8;
            while(cnt-- > 0){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx > 0 && nx <= 4 && ny > 0 && ny <= 4 && !(nx == shark.x && ny == shark.y) && smells[nx][ny] == 0){
                    fish.x = nx;
                    fish.y = ny;
                    fish.d = d;
                    fishCount[x][y] --;
                    fishCount[nx][ny] ++;
                    break;
                }else{
                    d = (d+7)%8;
                }
            }
        }
    }
    public static void sharkMove(){
        pq = new PriorityQueue<>();
        visited = new boolean[5][5];
        visited[shark.x][shark.y] = true;
        dfs(shark.x, shark.y, 0, "");
        SharkMoveInfo moveInfo = pq.poll();
        int x = shark.x;
        int y = shark.y;

        for(int i = 0; i < 3; i++){
            int index = moveInfo.d.charAt(i)-'0';
            x += dsx[index];
            y += dsy[index];
            if(fishCount[x][y] > 0){
                fishCount[x][y] = 0;
                smells[x][y] = 3;
            }
        }
        shark.x= x;
        shark.y = y;
        fishDeppCopy();
    }
    public static void fishDeppCopy(){
        ArrayList<FishInfo> copy = new ArrayList<>();
        for(FishInfo fish : fishList){
            if(fishCount[fish.x][fish.y]!=0){
                copy.add(fish);
            }
        }
        fishList = copy;
    }
    public static void dfs(int x, int y,int loop, String s){
        if(loop == 3){
//            System.out.println("s: "+s +",cnt: "+cnt);
            int sum = 0;
            boolean[][] visited= new boolean[5][5];
            visited[x][y] = true;
            sum += fishCount[x][y];
            for(int i = 2; i > 0; i--){
                int index = s.charAt(i)-'0';
                x -= dsx[index];
                y -= dsy[index];
                if(!visited[x][y] && fishCount[x][y] > 0){
                    sum+=fishCount[x][y];
                }
            }
            pq.offer(new SharkMoveInfo(Integer.parseInt(s),s,sum));
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x + dsx[d];
            int ny = y + dsy[d];
            if(nx > 0 && nx <= 4 && ny > 0 && ny <= 4){
                visited[nx][ny] = true;
                dfs(nx,ny,loop+1,  s+d);
                visited[nx][ny] = false;
            }
        }
    }
    public static void smellGone(){
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                if(smells[i][j] > 0){
                    smells[i][j] --;
                }
            }
        }
    }
    public static void copyFish(){
        for(FishInfo fish : fishInfos){
            fishList.add(new FishInfo(fish.x,fish.y,fish.d));
            fishCount[fish.x][fish.y]++;
        }
        fishInfos.clear();
        for(FishInfo fish : fishList){
            fishInfos.add(new FishInfo(fish.x,fish.y,fish.d));
        }
    }

    public static class SharkMoveInfo implements Comparable<SharkMoveInfo>{
        int compareNum;
        String d;
        int fishCount;
        public SharkMoveInfo(int compareNum,String d, int fishCount){
            this.compareNum = compareNum;
            this.d = d;
            this.fishCount = fishCount;
        }
        @Override
        public int compareTo(SharkMoveInfo s){
            if(this.fishCount == s.fishCount){
                return this.compareNum - s.compareNum;
            }else{
                return s.fishCount - this.fishCount;
            }
        }
    }

    public static void printData(){
        System.out.println("shark: "+shark);
        System.out.println("============= fish list start==============");
        for(FishInfo fish :fishList){
            System.out.println(fish);
        }
        System.out.println("============= fish list end==============");
        System.out.println("============= fish count start==============");
        for(int i = 1; i <= 4; i++){
            System.out.println(Arrays.toString(fishCount[i]));
        }
        System.out.println("============= fish count end==============");
        System.out.println("============= smells start==============");
        for(int i = 1; i <= 4; i++){
            System.out.println(Arrays.toString(smells[i]));
        }
        System.out.println("============= smells end==============");
    }

    public static class FishInfo{
        int x,y,d;

        public FishInfo(int x, int y){
            this.x = x;
            this.y = y;
        }
        public FishInfo(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
        @Override
        public String toString(){
            return "x: "+x+", y: "+y +", d: "+d;
        }
    }
    public static void init(){
        fishInfos = new ArrayList<>();
        smells = new int[5][5];
        fishCount = new int[5][5];
        fishList = new ArrayList<>();
    }
}
