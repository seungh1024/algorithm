package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_17472_다리만들기2 {
    public static int N,M;
    public static int[][] data;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static ArrayList<Bridge> bridges;
    public static int bridgeCount;
    public static boolean[][] visited;
    public static int result;
    public static ArrayList<Point>[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M  =Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] islandCheck = new boolean[N][M];
        int island = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M ;j ++){
                if(data[i][j] == 1 && !islandCheck[i][j]){
                    makeIsland(i,j,island,islandCheck);
                    island++;
                }
            }
//            System.out.println(Arrays.toString(data[i]));
        }

        islandCheck = new boolean[N][M];
        Map<Integer,Boolean> bridgeCheck = new HashMap<>();
        bridges = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(data[i][j] >= 1 && !islandCheck[i][j]){
                    islandCheck[i][j] = true;
                    for(int d = 0; d <4; d++){
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if(nx >= 0 && nx < N && ny >= 0 && ny <M && data[nx][ny] == 0){
                            makeBridge(i,j,d, islandCheck, bridgeCheck);
                        }
                    }
                }
            }
        }

//        for(Bridge b :bridges){
//            System.out.println(b);
//        }

        list = new ArrayList[island];
        for(int i = 0 ; i < island; i++){
            list[i] = new ArrayList<>();
        }

        bridgeCount = bridges.size();
        for(Bridge bridge : bridges){
            list[bridge.beforeIsland].add(new Point(bridge.beforeIsland,bridge.nextIsland,bridge.length));
            list[bridge.nextIsland].add(new Point(bridge.nextIsland,bridge.beforeIsland,bridge.length));
        }
        visited = new boolean[island][island];
        result = -1;
        findResult(1,island);
        System.out.println(result);
    }
    public static void findResult(int index, int size){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[] distance = new int[size];
        Arrays.fill(distance,Integer.MAX_VALUE);
        boolean[] visited = new boolean[size];
        pq.offer(new Point(0,index,0));
        int cnt = 0;
        while(!pq.isEmpty()){
            Point now = pq.poll();
            if(visited[now.to] || distance[now.to] < now.length) continue;
            distance[now.to] = now.length;
            visited[now.to] = true;
            cnt++;
//            System.out.println(Arrays.toString(distance));

            for(Point next : list[now.to]){
//                System.out.println("next: "+next.to +", length: "+next.length);
                if(!visited[next.to] && distance[next.to] > next.length){
                    pq.offer(next);
                }
            }
        }
//        System.out.println(Arrays.toString(distance));
//        System.out.println(cnt);
//        System.out.println(size);
        if(cnt == size-1){
            int sum = 0;
            for(int i = 1; i < size; i++){
                if(distance[i] != Integer.MAX_VALUE){
                    sum += distance[i];
                }
            }
            if(sum > 0){
                result = sum;
            }
        }
    }

    public static void makeBridge(int x, int y, int d, boolean[][] check, Map<Integer,Boolean> bridgeCheck){
        int length = 0;
        int nx = x;
        int ny = y;
        while(true){
            nx += dx[d];
            ny += dy[d];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M ){
                if(data[nx][ny] == 0){
                    length++;
                }else if(data[nx][ny] >0){
                    break;
                }
            }else{ // 범위 넘었는데 연결 못하면 리턴
                return;
            }
        }
        int key = data[x][y]*100 + data[nx][ny]*10 + length;
        if(length >= 2 && !check[nx][ny] && bridgeCheck.get(key) == null){
            bridges.add(new Bridge(data[x][y],data[nx][ny],length));
            bridgeCheck.put(key,true);
        }
    }

    public static void makeIsland(int x, int y , int island,boolean[][] check){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        check[x][y] = true;
        int start = data[x][y];
        data[x][y] = island;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int d = 0; d <4 ;d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if(nx>=0 && nx < N && ny >= 0 && ny < M && data[nx][ny] == start && !check[nx][ny]){
                    data[nx][ny] = island;
                    q.offer(new int[]{nx,ny});
                    check[nx][ny] = true;
                }
            }
        }
    }

    public static class Bridge{
        int beforeIsland, nextIsland, length;
        public Bridge(int beforeIsland, int nextIsland, int length){
            this.beforeIsland = beforeIsland;
            this.nextIsland = nextIsland;
            this.length = length;
        }

        @Override
        public String toString(){
            return "before: "+beforeIsland + ", next: "+nextIsland +", length: "+length;
        }
    }
    public static class Point implements Comparable<Point>{
        int from,to,length;
        public Point(int from, int to, int length){
            this.from = from;
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Point p){
            return this.length - p.length;
        }
    }

}
