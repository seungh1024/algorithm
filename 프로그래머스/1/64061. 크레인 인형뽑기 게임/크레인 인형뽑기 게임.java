import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int N = board.length;
        int M = board[0].length;
        for(int m : moves){
            m--;
            // System.out.println("m = "+m);
            // System.out.println(stack);
            
            int target = 0;
            for(int i = 0; i < N; i++){
                if(board[i][m] != 0){
                    target = board[i][m];
                    board[i][m] = 0;
                    break;
                }
            }
            // System.out.println("target = "+target);
            if(target == 0) continue;
            if(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                answer+=2;
            }else{
                stack.push(target);
            }
        }
        
        return answer;
    }
}