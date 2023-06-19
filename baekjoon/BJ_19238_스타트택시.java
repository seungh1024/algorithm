package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_19238_스타트택시 {
    public static int N, M, F;
    public static int[][] data;
    public static Queue<Point> q;
    public static int totalMove; // 손님 이동시킨 수
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][] check;
    public static int[][][] arrive;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        arrive = new int[N][N][M+2];
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <N ;j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int tx = Integer.parseInt(st.nextToken())-1;
        int ty = Integer.parseInt(st.nextToken())-1;
        q = new LinkedList<>();
        q.offer(new Point(tx,ty));

        M += 2;
        for(int i = 2; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;
            int ex = Integer.parseInt(st.nextToken())-1;
            int ey = Integer.parseInt(st.nextToken())-1;
            data[sx][sy] = i;
            arrive[ex][ey][i] = -i;
        }
        M-=2;
//        printData();

        totalMove = 0;
        find(tx, ty);
        int result = F;
        if(totalMove != M){
            result = -1;
        }
        System.out.println(result);
    }
    public static void printData(){
        for(int i = 0; i< N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("/////////////");
        for(int i = 0; i< N; i++){
            System.out.println(Arrays.toString(arrive[i]));
        }
    }
    public static void find(int x, int y){
        check = new boolean[N][N];
        check[x][y] = true;
//        if(data[x][y]>=2){
//            go(new Point(x,y));
//            if(totalMove == M){
//                return;
//            }
//        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int cnt = 0;
        while(F>0 && !q.isEmpty()){
            boolean fuelCheck = false;
            boolean findCheck = false;
            int size = q.size();
            for(int s = 0; s < size; s++){
                Point now = q.poll();
                if(data[now.x][now.y]>=2){
                    findCheck = true;
                    pq.offer(now);
//                    System.out.println("F:"+F+ " , Point: "+now);
//                    return;
                    fuelCheck = true;
                    break;
                }
                for(int d = 0; d < 4; d++){
                    int nx = now.x+dx[d];
                    int ny = now.y+dy[d];
//                    System.out.println("nx : "+nx + " , ny: "+ny);
                    if(nx>=0&& nx < N && ny >= 0 && ny < N && !check[nx][ny]&& data[nx][ny]!=1){
                        check[nx][ny] = true;
                        Point input = new Point(nx,ny);
                        if(data[nx][ny] >= 2){
                            findCheck = true;
                            pq.offer(input);
                        }
                        q.offer(input);
//                        System.out.println(input);
                    }
                }
            }
            if(!fuelCheck){
                F--;
            }
//            System.out.println("F: "+F);
//            System.out.println("///////// per size ////////////");
            if(findCheck){ // 사람 찾았으면 목적지로 출발
                Point now = pq.poll();
                q.clear(); // 찾았으니 리셋
                pq.clear(); // 마찬가지로 리셋
//                System.out.println("///////// start go ////////////");
                go(now);
                cnt++;
                if(totalMove == M){
                    break;
                }
//                if(cnt == 1) return;
//                if(now.x == 4 && now. y == 4) return;
            }
        }
    }
    public static void go(Point start){
        int manNum = data[start.x][start.y];
        data[start.x][start.y] = 0; //사람 태웠으니 0으로
        boolean[][] goCheck = new boolean[N][N];
        goCheck[start.x][start.y] = true;
        q.offer(start);
        int cnt = 0;
        while(F>0 && !q.isEmpty()){
            int size = q.size();
            cnt++;
            F--;
            for(int s = 0; s < size; s++){
                Point now = q.poll();
                for(int d = 0; d < 4; d++){
                    int nx = now.x+dx[d];
                    int ny = now.y+dy[d];
                    if(nx>= 0 && nx < N && ny >= 0 && ny < N &&!goCheck[nx][ny] && data[nx][ny]!=1){
                        Point input = new Point(nx,ny);
//                        System.out.println(input);
                        if(arrive[nx][ny][manNum] == -manNum){ //목적지 도착
                            F+=cnt*2; //연료 두배 추가
//                            data[nx][ny] = 0; // 일반 길로 변경
                            q.clear(); // 다시 처음부터 출발하니 비워줌
                            q.offer(input);
                            check = new boolean[N][N];
                            check[nx][ny] = true;
                            totalMove++;
//                            System.out.println("도착 F: "+F + ", cnt : "+cnt + ", manNum: "+manNum + ", cnt: "+cnt);
                            return;
                        }
                        goCheck[nx][ny] = true;
                        q.offer(input);
                    }
                }
            }

//            System.out.println("/////////// per go size ///////////");

        }
    }


    public static class Point implements Comparable<Point>{
        int x,y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o){
            if(this.x == o.x){
                return this.y-o.y;
            }else{
                return this.x-o.x;
            }
        }

        @Override
        public String toString(){
            return "x: "+ x + ", y: "+ y + ", data: "+data[x][y] +", F: "+F;
        }


    }
}
