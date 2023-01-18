import java.io.*;
import java.util.*;

public class BJ_5972_택배배송 {
    public static int N,M;
    public static ArrayList<Point>[] data;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            data[i] = new ArrayList<>();
        }
        int from,to,weight;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            data[from].add(new Point(to,weight));
            data[to].add(new Point(from,weight));
        }

        dijkstra(1);
    }

    public static void dijkstra(int start){
        int[] cost = new int[N+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[start] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start,cost[start]));
        while(!pq.isEmpty()){
            Point now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Point p : data[now.to]){
                if(!visited[p.to] && cost[p.to] > p.weight + cost[now.to]){
                    cost[p.to] = p.weight +cost[now.to];
                    pq.offer(new Point(p.to, cost[p.to]));
                }
            }
        }
        System.out.println(cost[N]);
    }

    public static class Point implements Comparable<Point>{
        int to,weight;
        public Point(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Point o){
            return this.weight - o.weight;
        }
    }
}
