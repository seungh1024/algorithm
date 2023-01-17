import java.io.*;
import java.util.*;

public class BJ_1504_특정한최단경로 {
    public static int N,E;
    public static int firstPoint, secondPoint;
    public static ArrayList<Point>[] data;
    public static boolean check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        data = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = new ArrayList<>();
        }

        int from,to,weight;
        for(int i = 0; i <E; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            data[from].add(new Point(to,weight));
            data[to].add(new Point(from,weight));
        }

        st = new StringTokenizer(br.readLine());
        firstPoint = Integer.parseInt(st.nextToken());
        secondPoint = Integer.parseInt(st.nextToken());

        check = false;
        long firstResult = (dijkstra(1,firstPoint)+dijkstra(firstPoint,secondPoint)+dijkstra(secondPoint,N));
        if(check){ //둘 다 통과 못하면
            System.out.println(-1);
            return;
        }
        check = false;
        long secondResult = (dijkstra(1,secondPoint)+dijkstra(secondPoint,firstPoint)+dijkstra(firstPoint,N));
        if(check){ //둘 다 통과 못하면
            System.out.println(-1);
            return;
        }

        long result = Math.min(firstResult,secondResult);

        System.out.println(result);
    }
    public static int dijkstra(int start,int end){
        if(start == end){
            return 0;
        }
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start,distance[start]));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            if(now.to == end) break;
            for(Point p: data[now.to]){
                if(!visited[p.to] && distance[p.to] > p.weight +distance[now.to]){
                    distance[p.to] = p.weight +distance[now.to];
                    pq.offer(new Point(p.to,distance[p.to]));
                }
            }
        }
        if(distance[end] == Integer.MAX_VALUE){
            check = true;
        }
        return distance[end];
    }

    public static class Point implements Comparable<Point>{
        int to, weight;

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
//4 5
//1 2 3
//1 3 1
//1 4 1
//2 3 3
//3 4 4
//2 3