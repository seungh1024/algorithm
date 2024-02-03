package algo_202401;

import java.util.*;

public class P_미로탈출 {
	public static void main(String[] args) {
		P_미로탈출 test = new P_미로탈출();
		String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
		int answer = test.solution(maps);
		int result = 16;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static char[][] data;
	public static int startX, startY, leverX, leverY, endX, endY;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int N,M;

	public int solution(String[] maps) {
		int answer = 0;
		N = maps.length;
		M = maps[0].length();
		data = new char[N][M];

		for(int i = 0; i < N; i++){
			char[] input = maps[i].toCharArray();
			for(int j = 0; j < M; j++){
				data[i][j] = input[j];
				if(input[j] == 'S'){
					startX = i;
					startY = j;
				}else if(input[j] == 'L'){
					leverX = i;
					leverY = j;
				}else if(input[j] == 'E'){
					endX = i;
					endY = j;
				}
			}
		}

		int lever = find(leverX,leverY);
		if(lever == -1){
			return lever;
		}
		answer += lever;
		int exit = find(endX,endY);
		if(exit == -1){
			return exit;
		}
		answer+=exit;

		return answer;
	}

	public static int find(int targetX, int targetY){
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{startX,startY});
		visited[startX][startY] = true;

		int count = 0;
		while(!q.isEmpty()){
			int size = q.size();
			count++;
			for(int s= 0; s < size; s++){
				int[] now = q.poll();

				for(int d = 0; d < 4; d++){
					int nx = now[0]+dx[d];
					int ny = now[1]+dy[d];
					if(nx == targetX && ny == targetY){
						startX = targetX;
						startY = targetY;
						return count;
					}
					if(nx>= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && data[nx][ny] != 'X'){
						visited[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}
				}
			}

		}

		return -1;
	}
}
