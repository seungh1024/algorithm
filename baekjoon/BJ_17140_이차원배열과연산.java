package algo_202304;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class BJ_17140_이차원배열과연산 {
    public static int R,C, r,c,k;
    public static int[][] data;
    public static PriorityQueue<Point> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        data = new int[101][101];
        for(int i = 1; i <= 3; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        R=3;
        C=3;
        pq = new PriorityQueue<>();
        int result = 0;
        while(result<=100){
            if(data[r][c] == k){
                System.out.println(result);
                return;
            }
            if(R>=C){ // 행 >= 열
                makeR();
            }else{
                makeC();
            }
            result++;
//            printData();
//            System.out.println("///////////////");
        }
        System.out.println(-1);

    }
    public static void printData(){
        for(int i = 0; i <= R; i++){
            for(int j = 0; j <= C; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void makeR(){ // 행 정렬
        int mc = 0;
        for(int i = 1; i <= R; i++){
            int[] array = new int[101];
            for(int j = 1; j <= C; j++){
                array[data[i][j]]++;
            }

            for(int j = 1; j <= 100; j++){
                if(array[j] != 0){
                    pq.offer(new Point(j,array[j]));
                }
            }
            int idx = 1;
            while(!pq.isEmpty()){
                Point now = pq.poll();
                data[i][idx] = now.num;
                data[i][idx+1] = now.cnt;
                idx += 2;
            }
            for(int j = idx; j <= 100; j++){
                data[i][j] = 0;
            }
            mc = Math.max(mc,idx-1);
        }
        C = mc;
    }
    public static void makeC(){ // 열 정렬
        int mr = 0;
        for(int j = 1; j <= C; j++){
            int[] array = new int[101];
            for(int i = 1; i <= R; i++){
                if(data[i][j] != 0){
                    array[data[i][j]]++;
                }
            }
            for(int i = 1; i <= 100; i++){
                if(array[i] != 0){
                    pq.offer(new Point(i,array[i]));
                }
            }
            int idx = 1;
            while(!pq.isEmpty()){
                Point now = pq.poll();
                data[idx][j] = now.num;
                data[idx+1][j] = now.cnt;
                idx+=2;
            }
            for(int i = idx; i <= 100; i++){
                data[i][j] = 0;
            }
            mr = Math.max(mr,idx-1);
        }
        R = mr;
    }

    public static class Point implements Comparable<Point>{
        int num,cnt;
        public Point(int num , int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Point o){
            return this.cnt - o.cnt != 0? this.cnt-o.cnt : this.num - o.num;
        }
    }
}
