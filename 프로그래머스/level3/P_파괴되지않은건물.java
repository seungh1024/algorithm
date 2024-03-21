package algo_202403;

import java.util.*;

public class P_파괴되지않은건물 {
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;

		int N = board.length;
		int M = board[0].length;

		int[][] partSum = new int[N+1][M+1];

		for(int[] s : skill){
			int type = s[0];
			int r1 = s[1];
			int c1 = s[2];
			int r2 = s[3];
			int c2 = s[4];
			int degree = s[5];
			if(type == 1){
				degree = -degree;
			}
			partSum[r1][c1] += degree;
			partSum[r1][c2+1] -= degree;
			partSum[r2+1][c1] -= degree;
			partSum[r2+1][c2+1] += degree;


		}

		//  2  0  0  -2
		//  0  0  0   0
		//  0  0  0   2
		// -2  0  2   0
		//

		for(int i = 0; i <= N; i++){
			for(int j = 1; j <= M; j++){
				partSum[i][j] += partSum[i][j-1];
			}
		}
		// for(int i = 0; i < N; i++){
		//     System.out.println(Arrays.toString(partSum[i]));
		// }
		// System.out.println("========");
		for(int i = 1; i <= N; i++){
			for(int j = 0; j <= M; j++){
				partSum[i][j] += partSum[i-1][j];
			}
		}
		// for(int i = 0; i <= N; i++){
		//     System.out.println(Arrays.toString(partSum[i]));
		// }
		System.out.println("_____");
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				board[i][j] += partSum[i][j];
				if(board[i][j] > 0){
					answer++;
				}
			}
		}

		// for(int i = 0; i < N; i++){
		//     System.out.println(Arrays.toString(board[i]));
		// }


		return answer;
	}
}
