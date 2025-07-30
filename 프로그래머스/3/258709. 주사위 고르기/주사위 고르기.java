import java.util.*;

class Solution {
    public static int N;
    public static boolean[] check;
    public static int max = 0;
    public static int[] answer;
    
    public int[] solution(int[][] dice) {
        
        N = dice.length;
        answer = new int[N/2];
        check = new boolean[N];
        find(0,0,N/2, dice);
        
        return answer;
    }
    
    public static List<Integer> makeSum(List<Integer> list, int[][] dice){
        int x = N/2;
        int[][] dp = new int[x+1][501];
        dp[0][0] = 1;
        for(int i = 1; i <= x; i++){
            int idx = list.get(i-1);
            for(int j = 0; j < 6; j++){
                int d = dice[idx][j];
                for(int k = 1; k <= 500; k++){
                    if(k-d < 0) continue;
                    dp[i][k] += dp[i-1][k-d];
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 500; i++){
            if(dp[x][i] > 0){
                for(int j = 0; j < dp[x][i]; j++){
                    result.add(i);
                }
            }
        }
        
        return result;
    }
    
    public static void find(int idx, int cnt, int range, int[][] dice){
        if(cnt == range){
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < N; i++){
                if(check[i]){
                    list1.add(i);
                }else{
                    list2.add(i);
                }
            }
            
            // System.out.println(list1);
            // System.out.println(list2);
            
            List<Integer> A = makeSum(list1, dice);
            List<Integer> B = makeSum(list2, dice);
            // System.out.println(A);
            // System.out.println(B);
            
            int result = 0;
            
            for(int num : A){
            
                int start = 0;
                int end = B.size();
                
                while(start < end){
                    int mid = (start+end)/2;
                    
                    int v = B.get(mid);
                    if(v >= num){
                        end = mid;
                    }else{
                        start = mid+1;
                    }
                }
                // System.out.println("num = "+num + ", start = "+start);
                result += start;
            }
            // System.out.println("result = "+result + ", list = "+list1);
            if(result > max){
                max = result;
                for(int i = 0; i < N/2; i++){
                    answer[i] = list1.get(i)+1;
                }
            }
            
            return;
        }
        if(idx >= N) return;
        
        check[idx] = true;
        find(idx+1, cnt + 1, range,dice);
        check[idx] = false;
        find(idx+1, cnt ,range,dice);
    }
}