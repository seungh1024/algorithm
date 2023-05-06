package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1939_중량제한 {
    public static int N,M;
    public static ArrayList<Point>[] data;
    public static boolean[] visited;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            data[from].add(new Point(to,weight));
            data[to].add(new Point(from,weight));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        result = 0;
        find(from,to);
        System.out.println(result);
    }
    public static void find(int from, int to){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(from,Integer.MAX_VALUE));
        while(!pq.isEmpty()){
            Point now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Point p : data[now.to]){
                if(!visited[p.to]){
//                    System.out.println("p: "+p.to + " ,now.to: "+now.to);
//                    System.out.println("p.weight: "+p.weight+ ", now.weight: "+now.weight);
                    if(p.to == to){
//                        System.out.println("find!");
//                        System.out.println("p.weight: "+p.weight+ ", now.weight: "+now.weight);
                        result = Math.max(result,Math.min(now.weight,p.weight));
//                        return;
                    }
//                    System.out.println(Math.min(p.weight,now.weight));
//                    System.out.println("zz");
                    pq.offer(new Point(p.to,Math.min(p.weight,now.weight)));
                }
            }
//            System.out.println("///////");
        }
    }
    public static class Point implements Comparable<Point>{
        int to,weight;
        public Point(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Point o){
            return o.weight-this.weight;
        }
    }
}

//9 9
//1 4 11
//1 5 2
//4 5 4
//4 3 10
//4 2 7
//5 2 10
//5 6 13
//3 2 9
//2 6 8
//1 6