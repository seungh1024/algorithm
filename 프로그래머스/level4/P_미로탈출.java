package algo_202311.kakaointern2021;

import java.util.*;

public class P_미로탈출 {
    public static void main(String[] args) {
        P_미로탈출 test = new P_미로탈출();
        int n = 3;
        int start = 1;
        int end = 3;
        int[][] roads = {{1,2,2,},{3,2,3}};
        int[] traps = {2};
        int result = 5;
        int answer = test.solution(n,start,end,roads,traps);
        if(result == answer){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }

    public static int maxState;
    public static boolean[][] visited;
    public static Map<Integer, Integer> stateIndex;
    public static List<Point>[] connected;
    public static Set<Integer> isTrap;
    public static int[][][] data;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {

        initStaticData(n, roads, traps);
        int result = findEnd(start,end);
        return result;
    }

    public static int findEnd(int start, int end){
        Queue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start,0,0));
        int result = 0;
        while(!pq.isEmpty()){
            Point now = pq.poll();

            if(visited[now.to][now.state]) continue;
            visited[now.to][now.state] = true;

            if(now.to == end){
                result = now.time;
                break;
            }


            int nowDirection = 0;
            if(isTrap.contains(now.to)){
                int trapIndex = stateIndex.get(now.to);
                now.state = now.state ^ trapIndex;
                if((now.state & trapIndex) >0){ // 처음 상태와 다른상태
                    nowDirection = 1;
                }
            }

            // System.out.println("now.to: "+now.to +", now.state: "+now.state);

            for(Point next : connected[now.to]){
                int nextDirection = 0;
                if(isTrap.contains(next.to)){
                    int trapIndex = stateIndex.get(next.to);
                    if((now.state & trapIndex) > 0){
                        nextDirection = 1;
                    }
                }
                int direction = 0;
                if((nowDirection ^ nextDirection) > 0){
                    direction = 1;
                }
                if(!visited[next.to][now.state] && data[direction][now.to][next.to] > 0){
                    pq.offer(new Point(next.to, now.time + data[direction][now.to][next.to] , now.state));
                }
            }

        }

        return result;
    }


    public static void initStaticData(int n, int[][] roads, int[] traps){
        maxState = (1<<traps.length) -1; // 최대 1111111111
        visited = new boolean[n+1][maxState+1];

        stateIndex = new HashMap<>();
        isTrap = new HashSet<>();
        int trapNum = 0;
        for(int trap : traps){
            stateIndex.put(trap,1<<trapNum);
            trapNum++;
            isTrap.add(trap);
        }

        connected = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            connected[i] = new ArrayList<>();
        }

        data = new int[2][n+1][n+1];
        for(int[] road : roads){
            int P = road[0];
            int Q = road[1];
            int S = road[2];
            if(data[0][P][Q] != 0){
                data[0][P][Q] = Math.min(data[0][P][Q],S);
            }else{
                data[0][P][Q] = S;
                connected[P].add(new Point(Q,S,0));
                // System.out.println("?");
            }
            if(data[1][Q][P] != 0){
                data[1][Q][P] = Math.min(data[1][Q][P],S);
            }else{
                data[1][Q][P] = S;
                connected[Q].add(new Point(P,S,0));
                // System.out.println("??");
            }

        }

    }

    public static class Point implements Comparable<Point>{
        int to, time, state;

        public Point(int to, int time, int state){
            this.to = to;
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Point p){
            return this.time - p.time;
        }

        @Override
        public String toString(){
            return "to: "+to +", time: "+time;
        }
    }
}

