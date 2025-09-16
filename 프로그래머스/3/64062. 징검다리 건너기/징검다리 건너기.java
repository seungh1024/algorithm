import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        answer = binarySearch(stones,k);
        
        return answer;
    }
    
    public int binarySearch(int[] stones, int k){
        int start = 0;
        int end = 2000_000_000;
        
        int result = 0;
        while(start < end){
            int mid = (start+end)/2;
            
            int maxJump = isJump(stones,mid);
        
            if(maxJump >=k){
                end = mid;
            }else{
                start = mid+1;
            }
            
            // System.out.println("start = "+start + ", end = "+end + ", maxFriend = "+maxFriend + ", maxJump = "+maxJump);
        }
        return start;
    }
    
    public static int isJump(int[] stones, int v){
        int N = stones.length;
        int max = 0; // 최대 인원 수
        int cnt = 0;
        int maxCnt = 0; // 최대 점프 수
        for(int i = 0; i < N; i++){
            if(stones[i] - v <= 0){
                cnt++;
                max = Math.max(max,stones[i]);
            }else{
                maxCnt = Math.max(maxCnt,cnt);
                cnt = 0;
            }
        }
        
        maxCnt = Math.max(maxCnt,cnt);
        
        return maxCnt;
        
    }
}