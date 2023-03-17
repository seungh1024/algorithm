import java.io.*;
import java.util.*;

public class BJ_1197_최소스패닝트리 {
    public static int V,E;
    public static ArrayList<Point>[] data;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        data = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i = 1; i <= V; i++){
            data[i] = new ArrayList<>();
        }
        int a = 0,b = 0, c = 0;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            data[a].add(new Point(b,c));
            data[b].add(new Point(a,c));
        }

        mst(a);
    }
    public static void mst(int from){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(from,0));
        int result = 0;

        while(!pq.isEmpty()){
            Point now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            V--;
            result += now.weight;
            if(V == 0) break;
            for(Point next : data[now.to]){
                if(!visited[next.to]){
                    pq.offer(next);
                }
            }
        }

        System.out.println(result);
    }

    public static class Point implements Comparable<Point> {
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
