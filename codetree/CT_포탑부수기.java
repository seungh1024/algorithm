package algo_202310;

import java.io.*;
import java.util.*;

public class CT_포탑부수기 {
    public static int N,M,K;
    public static int[][] data;
    public static PriorityQueue<Po> pq;
    public static int[] dx;
    public static int[] dy;
    public static int[] px;
    public static int[] py;
    public static boolean[][] visited;
    public static int[][] poTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                data[i][j]= Integer.parseInt(st.nextToken());
                if(data[i][j] > 0){
                    pq.offer(new Po(i,j,data[i][j],0));
                }
            }
        }

        dx = new int[]{0,1,0,N-1};
        dy = new int[]{1,0,M-1,0};
        px = new int[]{0,1,0,N-1,1,N-1, N-1, 1};
        py = new int[]{1,0,M-1,0,1, 1,  M-1, M-1};
        poTime = new int[N][M];
        gameStart();

    }
    public static void gameStart(){
        int k = 0;
        while(k < K){
            k++;
            Po attack = pq.poll();
            attack.ad += (N+M);
            data[attack.x][attack.y] += (N+M);
            Po target = pq.poll();
            while(!pq.isEmpty()){
                target = pq.poll();
            }

//            System.out.println("attack: "+attack);
//            System.out.println("target: "+target);
//            printData();
            visited = new boolean[N][M];
            if(!laser(attack.x,attack.y,attack.ad,target.x,target.y)){ // laser attack
                potan(attack.x,attack.y,attack.ad, target.x,target.y); //potan attack
            }
            poTime[attack.x][attack.y] = k;

//            printData();
            heal(attack.x,attack.y); // 포탑 정비
//            printData();
            if(!reset(attack.x,attack.y)) break; // pq리셋

        }

        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                result = Math.max(result,data[i][j]);
            }
        }
        System.out.println(result);
    }

    public static boolean laser(int x, int y, int ad, int tx, int ty){
        visited[x][y] = true;
        Queue<Po> q = new LinkedList<>();
        q.offer(new Po(x,y,ad,0));
        while(!q.isEmpty()){
            Po now = q.poll();
            for(int d=  0; d <4; d++){
                int nx = (now.x+dx[d])%N;
                int ny = (now.y+dy[d])%M;
                if(isValid(nx,ny) && !visited[nx][ny]){
                    if(nx == tx && ny == ty){
//                        poTime[x][y] ++;
                        visited = new boolean[N][M];
                        visited[x][y] = true;
                        visited[tx][ty] = true;
                        data[tx][ty] -= ad;
                        char[] ways = now.way.toCharArray();
                        int wx = x;
                        int wy = y;
                        int minus = ad/2;
                        for(char c : ways){
//                            System.out.println(c);
                            wx = (wx+dx[c-'0'])%N;
                            wy = (wy+dy[c-'0'])%M;
                            visited[wx][wy] = true;
                            data[wx][wy] -= minus;
                        }
                        return true;
                    }
                    visited[nx][ny] = true;
                    Po next = new Po(nx,ny,ad,0,now.way + d);
                    q.offer(next);
                }
            }
        }
        return false;
    }

    public static void potan(int x, int y, int ad, int tx, int ty){
        int minus = ad/2;
        data[tx][ty] -= ad;
//        poTime[x][y]++;
        visited = new boolean[N][M];
        visited[x][y] = true;
        visited[tx][ty] = true;
//        System.out.println("x: "+x+", y: "+y);
        for(int d = 0; d < 8; d++){
            int nx = (tx+px[d])%N;
            int ny = (ty+py[d])%M;
//            System.out.println("nx : "+nx +", ny: "+ny);
            if(isValid(nx,ny) && !(x==nx && y == ny)){
                data[nx][ny]-=minus;
                visited[nx][ny] = true;
            }
        }
    }

    public static void heal(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(isValid(i,j)&&!visited[i][j]){
                    data[i][j]++;
                }
            }
        }
    }

    public static boolean reset(int x, int y){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(data[i][j] > 0){
                    cnt++;
                    pq.offer(new Po(i,j,data[i][j],poTime[i][j]));

                }else{
                    data[i][j] = 0;
                }
            }
        }
        if(cnt>1) return true;
        return false;
    }

    public static boolean isValid(int x, int y){
        if(x >= 0 && x < N && y >= 0 && y < M && data[x][y] >0){
            return true;
        }
        return false;
    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("=====================");
    }

    public static class Po implements Comparable<Po>{
        int x,y,ad,time;
        String way;
        public Po(int x, int y, int ad, int time, String way){
            this.x = x;
            this.y = y;
            this.ad = ad;
            this.time = time;
            this.way = way;
        }
        public Po(int x, int y, int ad, int time){
            this.x = x;
            this.y = y;
            this.ad = ad;
            this.time = time;
            this.way = "";
        }


        @Override
        public int compareTo(Po p){
            if(this.ad == p.ad){
                if(this.time == p.time){
                    if(this.x+this.y == p.x+p.y){
                        return p.y-this.y;
                    }else{
                        return p.x+p.y -(this.x+this.y);
                    }
                }else{
                    return p.time - this.time;
                }
            }else{
                return this.ad-p.ad;
            }
        }

        @Override
        public String toString(){
            return "x: "+x+", y: "+y+", ad: "+ad + ", time: "+time;
        }
    }
}

//4 4 3
//6 8 0 1
//0 0 0 0
//0 0 0 0
//0 0 8 0
