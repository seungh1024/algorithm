package algo_202404;

import java.util.*;

public class P_2차원동전뒤집기 {
	public static List<int[]> list;
	public static int N,M,range;
	public static boolean[] visited;
	public static int result;
	public static boolean flag;

	public int solution(int[][] beginning, int[][] target) {
		int answer = -1;
		init(beginning, target);
		find(0,0,beginning,target);
		if(flag){
			answer = result;
		}
		return answer;
	}

	public static void find(int index, int count, int[][] beginning, int[][] target){
		if(count > range) return;

		if(index >= range){
			int[][] copy = new int[N][M];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					copy[i][j] = beginning[i][j];
				}
			}
			for(int i = 0; i < range; i++){
				if(visited[i]){
					int[] now = list.get(i);
					int x = now[0];
					int y = now[1];
					int dx = now[2];
					int dy = now[3];

					while(x < N && y < M){
						copy[x][y] *= -1;
						x += dx;
						y += dy;
					}
				}
			}
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					if(copy[i][j] != target[i][j]){
						return;
					}
				}
			}
			flag = true;
			result = Math.min(result,count);
			return;
		}

		visited[index] = true;
		find(index+1,count+1,beginning,target);
		visited[index] = false;
		find(index+1,count,beginning,target);
	}

	public static void init(int[][] beginning, int[][] target){
		list = new ArrayList<>();
		N = beginning.length;
		M = beginning[0].length;
		for(int i = 0; i < N; i++){
			list.add(new int[]{i,0,0,1}); // 행의 시작지점 i,0과 dx,dy
		}
		for(int i = 0; i < M; i++){
			list.add(new int[]{0,i,1,0});
		}

		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(beginning[i][j] == 0){
					beginning[i][j] = -1;
				}
				if(target[i][j] == 0){
					target[i][j] = -1;
				}
			}
		}

		range = N+M;
		visited = new boolean[range];

		result = Integer.MAX_VALUE;
		flag = false;
	}
}
