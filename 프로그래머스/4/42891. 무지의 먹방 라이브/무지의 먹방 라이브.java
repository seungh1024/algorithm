import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 1;
        int N = food_times.length;
        
        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingLong((Data o)->o.v).thenComparingInt(o->o.idx));
        int idx = 0;
        for(int i : food_times){
            pq.offer(new Data(idx++,i));
        }
        
        long minus = 0;
        long total = N;
        while(!pq.isEmpty()){
            Data now = pq.poll();
            
            long v = now.v-minus;
            if(v*total <= k){
                k -= v*total;
                total--;
                minus += v;
            }else{
                minus += k/total;
                k = k%total;
            }
        }
        
        for(int i = 0; i < N; i++){
            food_times[i] -= minus;
            if(food_times[i]>0 && k >= 0){
                
                answer = i+1;
                k--;
            }
        }
        if(k >= 0){
            return -1;
        }
        
        return answer;
    }
    
    public static class Data{
        int idx;
        long v;
        
        public Data(int idx, long v){
            this.idx = idx;
            this.v = v;
        }
        
        public String toString(){
            return "idx = "+idx + ", v= "+v;
        }
    }
}