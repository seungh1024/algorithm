package algo_202402;

import java.util.*;

public class P_빛의경로사이클 {
	public static void main(String[] args) {
		P_빛의경로사이클 test = new P_빛의경로사이클();
		String[] grid = {"R","R"};
		int[] answer = test.solution(grid);
		int[] result = {4,4};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	private static char[][] data;
	private static int[] dx;
	private static int[] dy;
	private static int N,M;
	private static boolean[][][] visited;
	public int[] solution(String[] grid) {
		N = grid.length;
		M = grid[0].length();
		data = new char[N][M];
		dx = new int[]{0,1,0,N-1};
		dy = new int[]{1,0,M-1,0};
		for(int i = 0; i < N; i++){
			char[] input = grid[i].toCharArray();
			for(int j = 0; j < M; j++){
				data[i][j] = input[j];
			}
		}
		visited = new boolean[N][M][4];

		Queue<Integer> pq = new PriorityQueue<>();
		int qSize = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				for(int d = 0; d < 4; d++){
					int result = findCycle(i,j,d);
					if(result != 0){
						pq.offer(result);
						qSize++;
					}
				}
			}
		}

		int[] answer = new int[qSize];
		for(int i = 0; i < qSize; i++){
			answer[i] = pq.poll();
		}

		return answer;
	}

	private static int findCycle(int x, int y, int d){
		int count = 0;


		int nx = (x+dx[d])%N;
		int ny = (y+dy[d])%M;


		while(!visited[nx][ny][d]){
			count++;
			visited[nx][ny][d] = true;

			if(data[nx][ny] == 'L'){
				d = (d+3)%4;
			}else if(data[nx][ny] == 'R'){
				d = (d+1)%4;
			}

			nx = (nx+dx[d])%N;
			ny = (ny+dy[d])%M;
		}


		return count;
	}
}
