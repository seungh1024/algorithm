import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] count = new int[2000];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String s : timetable){
            String[] data = s.split(":");
            int time = Integer.parseInt(data[0])*60;
            int minute = Integer.parseInt(data[1]);
            int idx = time+minute;
            if(count[idx] == 0){
                pq.offer(idx);
            }
            count[idx]++;
        }
        
    
        
        int result = 540;
        
        for(int i = 1; i < n; i++){
            int M = m;
            while(!pq.isEmpty() && M > 0){
                int now = pq.poll();
                if(now > result){
                    pq.offer(now);
                    break;
                }
                // System.out.println("i = "+i + ", now = "+now);
                int cnt = count[now];
                if(cnt < M){
                    M-=cnt;
                }else{
                    count[now] -= M;
                    pq.offer(now);
                    break;
                }
            }
            result += t;
        }
        
        int M = m;
        while(!pq.isEmpty()){
            int now = pq.poll();
            // System.out.println("last bus = "+ now + ", result = "+result);
            int cnt = count[now];
            if(M-cnt <= 0){
                result = Math.min(result,now-1);
                break;
            }
            M-=cnt;
        }
        
        
        int time = result/60;
        int minutes = result%60;
        
        if(time < 10){
            answer+="0";
        }
        answer += time;
        answer +=":";
        if(minutes < 10){
            answer += "0";
        }
        answer+=minutes;
        
        return answer;
    }
}