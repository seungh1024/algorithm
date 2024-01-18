package algo_202401;

import java.util.*;

public class P_프렌즈4블록 {
	public static void main(String[] args) {
		P_프렌즈4블록 test = new P_프렌즈4블록();
		int m = 4;
		int n = 5;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		int answer = test.solution(m, n, board);
		int result = 15;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[] dx = {0,0,1,1};
	public static int[] dy = {0,1,0,1};
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] data = new char[m][n];
		for(int i = 0; i < m; i++){
			char[] input = board[i].toCharArray();
			for(int j = 0; j < n; j++){
				data[i][j] = input[j];
			}
		}

		answer = makeResult(m,n,data);

		return answer;
	}

	public static int makeResult(int m, int n, char[][] data){
		int result = 0;
		while(true){
			int count = removeAndCount(m,n,data);
			if(count == 0) break;
			result += count;
			compactData(m,n,data);
		}

		return result;

	}

	public static void compactData(int m, int n, char[][] data){
		for(int i = m-1; i >= 0; i--){
			for(int j = 0; j < n; j++){
				if(data[i][j] == '0') continue;
				int x = i;
				for(int k = i; k < m; k++){
					if(data[k][j] == '0'){
						x = k;
					}else if(data[k][j] != '0' && k != x){
						break;
					}
				}
				char temp = data[i][j];
				data[i][j] = '0';
				data[x][j] = temp;
			}
		}
	}

	public static int removeAndCount(int m, int n, char[][] data){
		int xsize = m-1;
		int ysize = n-1;

		boolean[][] visited = new boolean[m][n];

		for(int i = 0; i < xsize; i++){
			for(int j = 0; j < ysize; j++){
				int target = data[i][j];
				if(target == '0') continue;
				int count = 0;
				for(int d = 1; d < 4; d++){
					if(target == data[i+dx[d]][j+dy[d]]){
						count++;
					}
				}
				if(count == 3){
					for(int d = 0; d < 4; d++){
						visited[i+dx[d]][j+dy[d]] = true;
					}
				}
			}
		}

		int count = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(visited[i][j]){
					data[i][j] = '0';
					count++;
				}
			}
		}

		return count;
	}
}
