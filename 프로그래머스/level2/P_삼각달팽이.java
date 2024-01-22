package algo_202401;

import java.util.Arrays;

public class P_삼각달팽이 {
	public static void main(String[] args) {
		P_삼각달팽이 test = new P_삼각달팽이();
		int n = 6;
		int[] answer = test.solution(n);
		int[] result = {1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11};
		if (Arrays.equals(answer,result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[] dx = {1,0,-1};
	public static int[] dy = {0,1,-1};

	public int[] solution(int n) {
		int[][] data = new int[n][n];
		int d = 0;
		int x = 0;
		int y = 0;
		int range = 0;
		for(int i = 1; i <= n; i++){
			range += i;
		}

		for(int i = 1; i <= range; i++){
			data[x][y] = i;
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>= 0 && nx < n && ny >= 0 && ny < n && data[nx][ny] == 0){
				x = nx;
				y = ny;
			}else{
				d = (d+1)%3;
				x = x+dx[d];
				y = y+dy[d];
			}
		}

		int[] answer = new int[range];
		int index = 0;
		for(int i = 0; i <n; i++){
			for(int j = 0; j < n; j++){
				if(data[i][j] != 0){
					answer[index++] = data[i][j];
				}
			}
		}
		return answer;
	}
}
