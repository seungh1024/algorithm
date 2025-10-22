import java.util.*;

class Solution {
    public List<Data>[] list;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] f : fares){
            int from = f[0];
            int to = f[1];
            int cost = f[2];
            list[from].add(new Data(to,cost));
            list[to].add(new Data(from,cost));
        }
        
        int[] A = new int[n+1];
        int[] B = new int[n+1];
        int[] C = new int[n+1];
        
        find(a,n,A);
        find(b,n,B);
        find(s,n,C);
        
        answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int sum = A[i]+B[i]+C[i];
            if(sum < 0) continue;
            answer = Math.min(sum,answer);
        }
        
        return answer;
    }
    
    public void find(int start, int n, int[] distance){
        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
        pq.offer(new Data(start,0));
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        boolean[] visited = new boolean[n+1];
        
        while(!pq.isEmpty()){
            Data now = pq.poll();
            
            if(visited[now.to]) continue;
            visited[now.to] = true;
            
            for(Data next : list[now.to]){
                if(!visited[next.to] && distance[next.to]>distance[now.to]+next.cost){
                    distance[next.to] = distance[now.to]+next.cost;
                    
                    pq.offer(new Data(next.to,distance[next.to]));
                }
            }
        }
    }
    
    public static class Data{
        int to;
        int cost;
        
        public Data(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        public String toString(){
            return "to = "+to + ", cost = "+cost;
        }
    }
}