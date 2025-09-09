import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int turn = 1;
        StringBuilder sb = new StringBuilder();
        while(t>0){
            ArrayDeque<Integer> q = changeNum(num,n);
            // System.out.println(q);
            
            while(!q.isEmpty() && t > 0){
                int now = q.poll();
                if(turn == p){
                    t--;
                    if(now >= 10){
                        sb.append((char)('A'+(now-10)));
                    }else{
                        sb.append(now);    
                    }
                
                }
                turn++;
                if(turn > m){
                    turn = 1;
                }
            }
            num++;
        }
        return sb.toString();
    }
    
    public ArrayDeque<Integer> changeNum(int num, int n){
        ArrayDeque<Integer> q= new ArrayDeque<>();
        if(num == 0){
            q.offer(0);
            return q;
        }
        while(num > 0){
            q.offerFirst(num%n);
            num /=n;
        }
        
        return q;
    }
}