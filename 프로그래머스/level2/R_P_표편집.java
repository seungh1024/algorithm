package algo_202403;

import java.util.*;

public class R_P_표편집 {
	// 기본 이동 방향
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};

	private static int N,M;
	private static boolean[][][][] visited;
	private static int[][] data;

	public int solution(int[][] board) {
		int answer = 0;
		N = board.length;
		M = board[0].length;
		data = new int[N][M];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				data[i][j] = board[i][j];
			}
		}
		answer = find();
		return answer;
	}

	private static int find(){
		Data start = new Data(0,0,0,1);
		Queue<Data> q = new ArrayDeque<>();
		q.offer(start);
		visited = new boolean[N][M][N][M];
		// visited[0][0][0][1] = true;
		// visited[0][1][0][0] = true;

		int count = 0;
		int check = 0;
		while(!q.isEmpty()){
			int size = q.size();
			// System.out.println("=============");
			for(int s = 0; s < size; s++){
				Data now = q.poll();
				// System.out.println(now);
				int x1 = now.x1;
				int y1 = now.y1;
				int x2 = now.x2;
				int y2 = now.y2;

				if((x1 == N-1 && y1 == M-1) || (x2 == N-1 && y2 == M-1)){
					return count;
				}
				if(visited[x1][y1][x2][y2] || visited[x2][y2][x1][y1]){
					continue;
				}
				visited[x1][y1][x2][y2] = true;
				visited[x2][y2][x1][y1] = true;

				// 일반 이동
				for(int d = 0; d < 4; d++){
					int nx1 = x1+dx[d];
					int ny1 = y1+dy[d];
					int nx2 = x2+dx[d];
					int ny2 = y2+dy[d];

					if(isMove(nx1,ny1,nx2,ny2,d)){
						q.offer(new Data(nx1,ny1,nx2,ny2));
						q.offer(new Data(x2,y2,nx2,ny2)); // 오른쪽 기준 회전 했을 때 좌표
						q.offer(new Data(x1,y1,nx1,ny1)); // 왼쪽 기준 회전 했을 때 좌표
					}
				}



			}
			count++;


		}

		return count;
	}

	private static boolean isMove(int nx1, int ny1, int nx2, int ny2 , int d){

		if(nx1>=0 && nx1 < N && ny1 >= 0 && ny1 < M && nx2 >= 0 && nx2 < N && ny2>= 0 && ny2 < M && !visited[nx1][ny1][nx2][ny2] && !visited[nx2][ny2][nx1][ny1] && data[nx1][ny1] == 0 && data[nx2][ny2] == 0){
			return true;
		}
		return false;
	}

	private static class Data{
		int x1;
		int y1;
		int x2;
		int y2;

		public Data(int x1, int y1, int x2, int y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public String toString(){
			return "x1 = "+x1 + ", y1 = "+y1 + ", x2 = "+x2 + ", y2 = "+ y2 ;
		}
	}
}
