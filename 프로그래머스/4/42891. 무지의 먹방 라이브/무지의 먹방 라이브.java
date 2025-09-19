import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = -1;
        
        int N = food_times.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            pq.offer(food_times[i]);
            map.compute(food_times[i],(key,value)->value==null?1:value+1);
        }
        int total = N;
        int minus = 0;
        while(!pq.isEmpty()){
            if(total == 0){
                return -1;
            }
            int now = pq.poll();
            if(now - minus<= 0 || !map.containsKey(now)) continue;
            long value = now-minus;
            long v =  value*(long)total;
            // System.out.println("now = "+value + ", k = "+k + ", v= "+v);
            if(k < v) {
                minus += (k/total);
                k -= (k/total)*total;
                
                break;
            }
            minus = now;
            
            k-=v;
            
            int cnt= map.get(now);
            total -= cnt;
            map.remove(now);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            food_times[i] -= minus;
            if(food_times[i] > 0){
                q.offer(new int[]{i,food_times[i]});
            }
        }
        // System.out.println(Arrays.toString(food_times));
        // System.out.println("k = "+k);
        
        while(k>0&&!q.isEmpty()){
            int[] now = q.poll();
            now[1]--;
            k--;
            if(now[1] > 0){
                q.offer(now);
            }
            
        }
        
        if(!q.isEmpty()){
            answer = q.poll()[0];
        }
        if(answer != -1){
            answer++;
        }
        
        
        return answer;
    }
}