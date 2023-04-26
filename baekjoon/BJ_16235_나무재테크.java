package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_16235_나무재테크 {
    public static int N,M,K;
    public static int[][] A;
    public static Queue<Tree> dead;
    public static Queue<Tree> alive;
    public static PriorityQueue<Tree> pq;
    public static int[][] energy;
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        energy = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <=N; j++){
                int a = Integer.parseInt(st.nextToken());
                A[i][j] = a;
                energy[i][j] = 5;
            }
        }

        pq = new PriorityQueue<>();
        int x,y,z;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x= Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken()); //나무 나이
            pq.offer(new Tree(x,y,z));
        }

        alive = new LinkedList<>();
        dead = new LinkedList<>();
        for(int k = 0; k < K; k++){
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(pq.size());
    }

    public static void spring(){
        while(!pq.isEmpty()){
            Tree tree = pq.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;
            if(age<=energy[x][y]){
                energy[x][y] -= age;
                alive.offer(new Tree(x,y,age+1));
            }else{
                dead.offer(tree);
            }
        }
//        System.out.println("spring size: "+pq.size());
    }
    public static void summer(){
//        System.out.println("dead size: "+dead.size());
        while(!dead.isEmpty()){
            Tree tree = dead.poll();
            energy[tree.x][tree.y] += tree.age/2;
        }
    }
    public static void fall(){
//        System.out.println("fall size: "+alive.size());
        int x,y,age,nx,ny;
        while(!alive.isEmpty()){
            Tree tree = alive.poll();
            x = tree.x;
            y = tree.y;
            age = tree.age;
            if(age>= 5 && age%5 == 0){
                for(int d = 0; d < 8; d++){
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                        pq.offer(new Tree(nx,ny,1));
                    }
                }
            }
            pq.offer(tree);
        }
//        System.out.println("pq size: "+pq.size());
    }
    public static void winter(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                energy[i][j] += A[i][j];
            }
        }
    }
    public static class Tree implements Comparable<Tree>{
        int x,y,age;
        public Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o){
            return this.age - o.age;
        }
    }
}
