package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_20056_마법사상어와파이어볼 {
    public static int N,M,K;
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static Queue<Fireball> q;
    public static PriorityQueue<Fireball> pq;
    public static int[][] check;
    public static int[][] turn;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        check = new int[N][N];
        pq = new PriorityQueue<>();
        q = new LinkedList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            q.offer(new Fireball(r,c,m,s,d));
        }
        for(int i = 0; i < K; i++){
            check = new int[N][N];
            turn = new int[N][N];
            move();
            split();
//            printCheck();
//            System.out.println("//////////");
        }
        int result = 0;
        while(!q.isEmpty()){
            result += q.poll().m;
        }
        System.out.println(result);

    }
    public static void split(){
        while(!pq.isEmpty()){
            Fireball fb = pq.poll(); // 가장 많이 모인 것 부터 나옴
            int cnt = check[fb.r][fb.c];
            int hj = fb.d%2==0?0:1; // 짝수면 0, 홀수면 1;
            int sumM = fb.m;
            int sumS = fb.s;
            boolean hjCheck = true; // 모두 홀이나 짝이면 true
//            System.out.println("cnt: "+cnt+", "+fb);
            if(cnt>=2){
//                System.out.println("|||||||||||||");
                for(int i = 0; i < cnt-1; i++){
                    Fireball now = pq.poll();
//                    System.out.println("cnt: "+check[now.r][now.c]+", "+now);
                    sumM += now.m;
                    sumS += now.s;
                    if(now.d%2 != hj){ //계속 짝수거나 계속 홀수가 아니면 나머지 연산이 hj와 값이 다름
                        hjCheck = false;
                    }
                }
//                System.out.println("||||||||||||||");
                int m = sumM/5;
                if(m == 0) continue;
                int s = sumS/cnt;
                int start = 0;
//                System.out.println("m: "+m +", s: "+s);
                if(!hjCheck){ //모두 홀이나 짝이 아닌 경우
                    start = 1;
//                    System.out.println("전부 다름");
                }
                for(int i = start; i <8; i+=2){
                    q.offer(new Fireball(fb.r,fb.c,m,s,i));
                }
            }else{
                q.offer(fb);
            }
        }
    }
    public static void move(){
        int num = 1;
        while(!q.isEmpty()){
            Fireball fb = q.poll();
//            System.out.println(fb);
//            System.out.println(fb.d +", "+fb.s);
            int x = fb.r + dx[fb.d]*fb.s;
            int y = fb.c + dy[fb.d]*fb.s;
//            System.out.println("x: "+x+", y: "+y);
            if(x>= N) x = x%N;
            if(x<0) x = (N+x%N)%N;
            if(y>=N) y = y%N;
            if(y<0) y = (N+y%N)%N;
//            System.out.println("x: "+x+", y: "+y);
            check[x][y] ++; // 해당 좌표에 있는 파이어볼 카운트
            if(turn[x][y] == 0){
                turn[x][y] = num;
                num++;
            }
            fb.updqteRC(x,y);
            pq.offer(fb);
//            System.out.println(fb);
        }
//        printCheck();
    }
    public static void printCheck(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(check[i]));
        }
    }

    public static class Fireball implements Comparable<Fireball>{
        int r, c, m, d, s;
        public Fireball(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public void updqteRC(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Fireball o){
            return turn[o.r][o.c] - turn[this.r][this.c];
        }

        @Override
        public String toString(){
            return "r: "+ r +" ,c: "+c + ", m: "+m + ", s: "+s +", d: "+d;
        }
    }
}
