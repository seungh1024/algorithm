package algo_202311.kakaointern2019;

import java.util.*;

public class P_크레인인형뽑기게임 {
    public static void main(String[] args) {
        P_크레인인형뽑기게임 test = new P_크레인인형뽑기게임();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int result = 4;
        int answer = test.solution(board,moves);
        if(result == answer){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int r = board.length;
        int c = board[0].length;

        int[] height = new int[c]; // 각 인형 라인의 높이 저장
        int size = 0;
        for(int j = 0; j < c; j++){
            for(int i = 0; i <r; i++){
                if(board[i][j] > 0){
                    height[j] = i;
                    size += (r-i);
                    break;
                }
            }
        }

        int head = 0;
        int[] stack = new int[size];

        for(int move : moves){
            move--; // index = 0부터 시작하니 -1
            if(height[move] >= r) continue;

            int input = board[height[move]][move];

            if(head == 0){
                stack[head] = input;
                head++;
            }else{
                if(stack[head-1] == input){
                    stack[head-1] = 0;
                    answer+=2;
                    head--;
                }else{
                    stack[head] = input;
                    head++;
                }
            }
            height[move]++;
        }

        return answer;
    }
}
