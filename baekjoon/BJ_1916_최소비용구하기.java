import java.io.*;
import java.util.*;

public class BJ_1916_최소비용구하기 {
    public static int N,M;
    public static boolean[] visited;
    public static int busStart, busEnd;
    public static ArrayList<Bus>[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        data = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++){
            data[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int start,end,cost;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            data[start].add(new Bus(end,cost));
        }

        st = new StringTokenizer(br.readLine());
        busStart = Integer.parseInt(st.nextToken());
        busEnd = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    public static void dijkstra(){
        int[] totalCost = new int[N+1];
        Arrays.fill(totalCost, Integer.MAX_VALUE);
        totalCost[busStart] = 0;
        int result = 0;
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.offer(new Bus(busStart,totalCost[busStart]));

        while(!queue.isEmpty()){
            Bus now = queue.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Bus bus : data[now.to]){
                if(!visited[bus.to] && totalCost[bus.to] > bus.weight + totalCost[now.to]){
                    totalCost[bus.to] = bus.weight +totalCost[now.to];
                    queue.offer(new Bus(bus.to,totalCost[bus.to]));
                }
            }
        }

        System.out.println(totalCost[busEnd]);
    }

    public static class Bus implements Comparable<Bus>{
        int to,weight;

        public Bus(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Bus o){
            return this.weight-o.weight;
        }

        @Override
        public String toString(){
            return "to: "+this.to +" weight: "+ this.weight;
        }
    }
}
