import java.io.*;
import java.util.*;

public class BJ_17396_백도어 {
    public static int N,M;
    public static ArrayList<Point>[] data;
    public static long[] distance;
    public static boolean[] visited;
    public static boolean[] watch;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new ArrayList[N];
        for(int i = 0; i <N; i++){
            data[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        distance = new long[N];
        watch = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i <N-1; i++){
            int point = Integer.parseInt(st.nextToken());
            if(point == 1) {
                watch[i] = true;
            }
        }
        int from,to,weight;
        for(int i = 0; i <M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            if(watch[from] || watch[to]) continue;
            data[from].add(new Point(to,weight));
            data[to].add(new Point(from,weight));
        }

        dijkstra(0);

    }

    public static void dijkstra(int start){
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start,distance[start]));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Point p :data[now.to]){
                if(!visited[p.to] && distance[p.to] > p.weight +distance[now.to]){
                    distance[p.to] = p.weight +distance[now.to];
                    pq.offer(new Point(p.to,distance[p.to]));
                }
            }
        }

        if(distance[N-1] == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(distance[N-1]);
        }
    }

    public static class Point implements Comparable<Point>{
        int to;
        long weight;
        public Point(int to, long weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Point o){
            if(this.weight - o.weight > 0){
                return 1;
            }else if(this.weight == o.weight){
                return 0;
            }else{
                return -1;
            }
        }
    }
}
