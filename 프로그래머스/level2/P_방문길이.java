package algo_202401;

import java.util.*;

public class P_방문길이 {

	public static void main(String[] args) {
		P_방문길이 test = new P_방문길이();
		String dirs = "ULURRDLLU";
		int result = 7;
		int answer = test.solution(dirs);
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public static int[] dx = {-1,1,0,0}; // U, D, R, L
	public static int[] dy = {0,0,1,-1};
	public static Map<Character, Integer> map;
	public int solution(String dirs) {
		int answer = 0;
		initMap();
		answer = getFirstLength(dirs);
		return answer;
	}

	public static int getFirstLength(String dirs){
		char[] data = dirs.toCharArray();
		int minX = 0;
		int maxX = 10;
		int minY = 0;
		int maxY = 10;

		boolean[][][][] visited = new boolean[11][11][11][11];

		int x = 5;
		int y = 5;

		int result = 0;

		for(char move : data){
			int d = map.get(move);
			// System.out.println("d: "+d);
			int nx = x+dx[d];
			int ny = y+dy[d];

			// System.out.println("x: "+x +", y: "+ y + ", nx : "+nx + ", ny: "+ny);
			if(nx >= minX && nx <= maxX && ny >= minY && ny <= maxY){
				if(!visited[x][y][nx][ny] && !visited[nx][ny][x][y]){
					visited[x][y][nx][ny] = true;
					visited[nx][ny][x][y] = true;
					result++;

				}

				x = nx;
				y = ny;

			}
		}

		return result;
	}

	public static void initMap(){
		map = new HashMap<>();
		map.put('U',0);
		map.put('D',1);
		map.put('R',2);
		map.put('L',3);
	}
}
