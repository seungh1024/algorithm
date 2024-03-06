package algo_202403;

import java.util.*;

public class R_P_가장큰정사각형찾기 {
	public int solution(int [][]board)
	{
		int answer = 1234;

		int N = board.length;
		int M = board[0].length;

		int max = 0;
		for(int j = 0; j < M; j++){
			max = Math.max(max,board[0][j]);
		}

		for(int i = 1; i < N; i++){
			for(int j = 1; j < M; j++){
				if(board[i][j] != 0 && board[i-1][j] != 0 && board[i][j-1] != 0 && board[i-1][j-1] != 0){
					board[i][j] = Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
					max = Math.max(board[i][j],max);
				}
			}
		}

		answer = max*max;

		return answer;
	}
}
