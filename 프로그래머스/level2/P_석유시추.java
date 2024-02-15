package algo_202402;

import java.util.*;

public class P_석유시추 {
	private static int[] oilCount;
	private static int N,M;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	public int solution(int[][] land) {
		int answer = 0;

		N = land.length;
		M = land[0].length;
		oilCount = new int[M];

		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(land[i][j] == 1){
					findOil(i,j,land);
				}
			}
		}
		Arrays.sort(oilCount);
		answer = oilCount[M-1];
		return answer;
	}

	public static void findOil(int x, int y, int[][] land){
		int target = land[x][y];
		int count = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y});
		land[x][y] = 0;
		Set<Integer> set = new HashSet<>();
		set.add(y);


		while(!q.isEmpty()){
			int[] now = q.poll();

			for(int d = 0; d < 4; d++){
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];
				if(nx>=0&&nx<N&&ny>=0&&ny<M && land[nx][ny] == target){
					count++;
					land[nx][ny] = 0;
					q.offer(new int[]{nx,ny});
					set.add(ny);
				}
			}
		}

		for(int i : set){
			oilCount[i] += count;
		}
	}
}
