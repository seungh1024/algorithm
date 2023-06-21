package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_19237_어른상어 {
    public static int N,M,K;
//    public static int[][] data; // 맵 상태 정보
    public static int[][] smell; // 냄새 정보
    public static int[][] shark; // 냄새 주인 번호 정보
    public static Queue<Shark> q; // 상어 정보
    public static int[][][] sharkMove; // 상어 우선순위 정보 x번째 상어의 y방향에서 z우선순위
    public static int[] dx = {0,-1,1,0,0};
    public static int[] dy = {0,0,0,-1,1}; // 위 아래 왼 오
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        smell = new int[N+1][N+1];
        shark = new int[N+1][N+1];
        sharkMove = new int[M+1][5][5];
//        q = new PriorityQueue<>();
        q = new LinkedList<>();

        int[][] inputShark = new int[M+1][2];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input > 0){
                    inputShark[input][0] = i;
                    inputShark[input][1] = j;
                    smell[i][j] = K;
                    shark[i][j] = input;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++){ // 각 상어의 첫 방향
            int x= inputShark[i][0];
            int y = inputShark[i][1];
            int d = Integer.parseInt(st.nextToken());
            q.offer(new Shark(i,x,y,d));
        }


        for(int i = 1; i <= M; i++){
            for(int j = 1; j <=4; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= 4; k++){
                    sharkMove[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        move();

    }

    public static void move(){
        int turn = 0;
        while(turn <=1000){
            int size = q.size();
            if(size == 1){
                System.out.println(turn);
                return;
            }
            for(int s = 0; s < size; s++){
                Shark now = q.poll();
                int num = now.num;
                int x = now.x;
                int y = now.y;
                int d = now.d;
//                smell[x][y] = K;
//                shark[x][y] = num; // 상어 냄새, 번호 기록
                boolean check = true; // true이면 냄새 없는 칸 이동 못한 것

                for(int i = 1; i<=4; i++){
                    int dd = sharkMove[num][d][i]; // 우선순위 방향
                    int nx = x+dx[dd];
                    int ny = y+dy[dd];
                    if(nx>0 && nx <= N && ny> 0 && ny<= N && smell[nx][ny] == 0){ // 우선순위 방향 있는 경우
                        now.x = nx;
                        now.y = ny;
                        now.d = dd;
                        check = false;
                        break;
                    }
                }

                if(check){ // 자신의 냄ㅅ ㅐ찾아서 가야함
                    for(int i = 1; i<=4; i++){
                        int dd = sharkMove[num][d][i]; // 우선순위 방향
                        int nx = x+dx[dd];
                        int ny = y+dy[dd];
                        if(nx>0 && nx <= N && ny> 0 && ny<= N && shark[nx][ny] == num){ // 우선순위 방향대로 내가 남긴 냄새 찾아서 이동
                            now.x = nx;
                            now.y = ny;
                            now.d = dd;
                            break;
                        }
                    }
                }
                q.offer(now); //다시 넣어줌
            }
            minusSmell(); // 냄새 1씩 지워주기
            deleteShark(); //중복되는 상어 제거
            turn++;
//            System.out.println("turn: "+turn);
//            printSmellShark();
        }
        System.out.println(-1);
    }
    public static void deleteShark(){
        boolean[][] check = new boolean[N+1][N+1];
        int size = q.size();
//        System.out.println("q size: "+size);
        for(int s= 0; s <size; s++){ //1부터 순서대로 들어가 있으니 중복되면 제거하면 됨
            Shark now = q.poll();
//            System.out.println(now);
            int x= now.x;
            int y = now.y;
            if(check[x][y]) continue;
            check[x][y] = true;
            shark[x][y] = now.num;
            smell[x][y] = K;
            q.offer(now);
        }
//        System.out.println("delete shark end");
    }

    public static void minusSmell(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(smell[i][j] >0){
                    smell[i][j] --;
                    if(smell[i][j] == 0){
                        shark[i][j] = 0;
                    }
                }
            }
        }
    }



    public static void printSmellShark(){
        System.out.println("==========print shark info ============");
        for(int i = 1; i<= N; i++){
            System.out.println(Arrays.toString(shark[i]));
        }
        System.out.println(" ======== print smell info ===========");
        for(int i = 1; i <= N; i++){
            System.out.println(Arrays.toString(smell[i]));
        }
        System.out.println(" ========= print shark & smell end=========");
    }

    public static void printSharkMove(){
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <=4; j++){
                System.out.println(Arrays.toString(sharkMove[i][j]));
            }
            System.out.println("//////////////////");
        }
        System.out.println("======== pirnt shark move end============");
    }


    public static class Shark {
        int num,x,y, d;
        public Shark(int num, int x, int y, int d){
            this.num = num;
            this.x = x;
            this.y = y;
            this.d = d;
        }

//        @Override
//        public int compareTo(Shark o){
//            return this.num - o.num;
//        }

        public String toString(){
            return "[shark class] num: "+ num + ", x: "+x+ ", y: "+y +", d: "+d;
        }
    }
}
