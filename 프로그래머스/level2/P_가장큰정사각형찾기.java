package algo_202401;

import java.util.*;

public class P_가장큰정사각형찾기 {
	public static void main(String[] args) {
		P_가장큰정사각형찾기 test = new P_가장큰정사각형찾기();
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int answer = test.solution(board);
		int result = 9;

		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public int solution(int [][]board) {
		int answer = 0;
		int N = board.length;
		int M = board[0].length;

		for(int i = 1; i < N; i++){
			for(int j = 1; j < M; j++){
				if(board[i][j] == 0) continue;

				int min = Math.min(board[i-1][j],Math.min(board[i][j-1],board[i-1][j-1]));
				board[i][j] = min+1;
			}

		}

		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				answer = Math.max(answer,board[i][j]);
			}
		}


		return answer*answer;
	}
}
