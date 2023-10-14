package algo_202310;

import java.io.*;
import java.util.*;


public class CT_토끼와경주 {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static PriorityQueue<Rabbit> pq;
    public static List<Rabbit> rabbits;
    public static int N,M,P;
    public static Map<Integer,Rabbit> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        rabbits = new ArrayList<>();
        map = new HashMap<>();
        for(int i = 0; i < P; i++){
            int pid = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Rabbit r = new Rabbit(0,1,1,0, pid,d);
            pq.offer(r);
            rabbits.add(r);
            map.put(pid,r);
        }

        Q-=2;
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int num  = Integer.parseInt(st.nextToken());
            int K  = Integer.parseInt(st.nextToken());
            int S  = Integer.parseInt(st.nextToken());
            if(num == 200){ // 경주 진행
                run(K,S);
            }else if(num == 300){ // 이동거리 변경
                changeDistance(K,S);
            }
        }

        printResult();
    }

    public static void run(int K, int S){
        int k = 0;
        while(k < K){
            k++;

            Rabbit now = pq.poll();
            PriorityQueue<Point> points = new PriorityQueue<>();
//            System.out.println("=========== way===========");
            int sizeN = 2*N-2;
            int sizeM = 2*M-2;
            for(int d = 0; d < 4; d++){ //4가지 방향 구하기
                long nx =now.x ;
                long ny = now.y;
                long size = now.d;
                if(d == 0){// 우
                    size = size % (2*M-2);
                    if(size >= M - ny){
                        size -= M-ny;
                        ny = M;
                    }else{
                        ny += size;
                        size = 0;
                    }
                    if(size >= M - 1){
                        size -= M-1;
                        ny = 1;
                    }else{
                        ny -= size;
                        size = 0;
                    }
                    ny += size;
                }else if(d == 1){// 좌
                    size = size % (2*M-2);
                    if(size >= ny -1){
                        size -= ny-1;
                        ny = 1;
                    }else{
                        ny -= size;
                        size = 0;
                    }
                    if(size >= M - 1){
                        size -= M-1;
                        ny = M;
                    }else{
                        ny += size;
                        size = 0;
                    }
                    ny -= size;
                }else if(d == 2){// 하
                    size = size % (2*N-2);
                    if(size >= N - nx){
                        size -= N-nx;
                        nx = N;
                    }else{
                        nx += size;
                        size = 0;
                    }
                    if(size >= N-1){
                        size -= N-1;
                        nx = 1;
                    }else{
                        nx -=size;
                        size = 0;
                    }
                    nx += size;
                }else if(d == 3){// 상
                    size = size % (2*N-2);
                    if(size >= nx-1){
                        size -= nx-1;
                        nx = 1;
                    }else{
                        nx -=size;
                        size = 0;
                    }
                    if(size >= N-1){
                        size -=N-1;
                        nx = N;
                    }else{
                        nx += size;
                        size = 0;
                    }
                    nx -= size;
                }


                points.offer(new Point((int)nx,(int)ny));
//                System.out.println("size: "+size + "size N: "+sizeN +", sizeM: "+sizeM);
//                System.out.println("nx:"+ nx +", ny: "+ny);
            }
//            System.out.println("-=========== way end ============");

            Point next = points.poll();
            now.x = next.x;
            now.y = next.y;
            now.jump++;
            now.check = true;
//            System.out.println("now: "+now);


            for(Rabbit rabbit : rabbits){
                if(rabbit.pid != now.pid){
                    rabbit.score += (next.x+next.y);
                }
//                System.out.println("rabbit: "+ rabbit);
            }
            pq.offer(now);
        }

        // 라운드 종료 ->  새로운 우선순위로 뽑아야 함
        PriorityQueue<RabbitS> rs = new PriorityQueue<>();
        int size = rabbits.size();
        int idx = 0;
        for(int i = 0; i < size; i++){
            Rabbit r = rabbits.get(i);
            if(r.check){
                rs.offer(new RabbitS(r.x,r.y,r.pid,idx));
            }
            r.check = false;
            idx++;
        }
        RabbitS plusRabbit = rs.poll();
        rabbits.get(plusRabbit.idx).score += S;
    }

    public static void changeDistance(int pid, int L){
        Rabbit rabbit = map.get(pid);
        rabbit.d *= L;
    }

    public static void printResult(){
        long result = 0;
        for(Rabbit r : rabbits){
            result = Math.max(result, r.score);
        }
        System.out.println(result);
    }

    public static boolean isValid(int x, int y){
        if(x>0 && x <= N && y > 0 && y <= M){
            return true;
        }
        return false;
    }

    public static class Rabbit implements Comparable<Rabbit>{
        int jump, x, y, pid;
        long score, d;
        boolean check; // K번동안 뽑혔는지 체크

        public Rabbit(int jump, int x, int y, long score, int pid, long d){
            this.jump = jump;
            this.x = x;
            this.y = y;
            this.score = score;
            this.pid = pid;
            this. d = d;
            this.check = false;
        }

        @Override
        public int compareTo(Rabbit r){
            if(this.jump == r.jump){
                if((this.x+this.y) == (r.x+r.y)){
                    if(this.x == r.x){
                        if(this.y == r.y){
                            return this.pid - r.pid;
                        }else{
                            return this.y-r.y;
                        }
                    }else{
                        return this.x-r.x;
                    }
                }else{
                    return (this.x+this.y) - (r.x+r.y);
                }
            }else{
                return this.jump-r.jump;
            }
        }

        @Override
        public String toString(){
            return "jump: "+jump + ", x: "+x + ", y: "+y +", score: "+score + ", pid : "+pid + ", d: "+d;
        }
    }

    // S 더해줄 토끼
    public static class RabbitS implements Comparable<RabbitS>{
        int x,y,pid,idx;
        public RabbitS(int x,int y,int pid, int idx){
            this.x = x;
            this.y = y;
            this.pid = pid;
            this.idx = idx;
        }

        @Override
        public int compareTo(RabbitS rs){
            if((this.x+this.y) == (rs.x+rs.y)){
                if(this.x == rs.x){
                    if(this.y == rs.y){
                        return rs.pid - this.pid;
                    }else{
                        return rs.y - this.y;
                    }
                }else{
                    return rs.x - this.x;
                }
            }else{
                return (rs.x+rs.y) - (this.x+this.y);
            }
        }
    }


    public static class Point implements Comparable<Point>{
        int x,y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Point p){
            if((this.x+this.y) == (p.x+p.y)){
                if(this.x == p.x){
                    return p.y-this.y;
                }else{
                    return p.x-this.x;
                }
            }else{
                return (p.x+p.y) - (this.x+this.y);
            }
        }
    }
}
