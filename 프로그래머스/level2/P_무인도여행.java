package algo_202401;

import java.util.*;

public class P_무인도여행 {
	public static void main(String[] args) {
		P_무인도여행 test = new P_무인도여행();
		String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
		int[] answer = test.solution(maps);
		int[] result = {1,1,27};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static char[][] data;
	public static boolean[][] visited;
	public static int N,M;

	public int[] solution(String[] maps) {
		N = maps.length;
		M = maps[0].length();
		data = new char[N][M];
		for(int i = 0; i < N; i++){
			char[] input = maps[i].toCharArray();
			for(int j = 0; j < M; j++){
				data[i][j] = input[j];
			}
		}

		visited = new boolean[N][M];
		Queue<Integer> days = new PriorityQueue<>();
		int size = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(!visited[i][j] && data[i][j] !='X'){
					int day = findSurvivalDay(i,j);
					size++;
					days.offer(day);
				}
			}
		}
		int[] answer;

		if(size == 0){
			answer = new int[]{-1};
		}else{
			answer = new int[size];
			int index = 0;
			while(!days.isEmpty()){
				answer[index++] = days.poll();
			}
		}

		return answer;
	}

	public static int findSurvivalDay(int x, int y){
		int result = data[x][y]-'0';

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y});
		visited[x][y] = true;

		while(!q.isEmpty()){
			int[] now = q.poll();

			for(int d = 0; d < 4; d++){
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && data[nx][ny]!='X'){
					q.offer(new int[]{nx,ny});
					result += data[nx][ny]-'0';
					visited[nx][ny] = true;
				}
			}
		}

		return result;
	}
}
