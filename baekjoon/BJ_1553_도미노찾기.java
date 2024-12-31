package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_1553_도미노찾기 {
	public static int[][] map = new int[8][7];
	public static boolean[][] visited = new boolean[8][7];
	public static boolean[][] domino = new boolean[7][7];
	public static int result = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 7; j++) {
				map[i][j] = input[j]-'0';
			}
		}

		find(0, 0);
		System.out.println(result);
	}

	public static void find(int x, int y) {
		if (x == 8) {
			result++;
			return;
		}

		if (y == 7) {
			find(x + 1, 0);
			return;
		}

		if (!visited[x][y]) {
			visited[x][y] = true;
			int left = map[x][y];

			int nx = x + 1;
			int ny = y;

			if (nx < 8) {
				int right = map[nx][ny];

				if (!visited[nx][ny] && !domino[left][right]) {
					visited[nx][ny] = true;
					domino[left][right] = true;
					domino[right][left] = true;
					find(x, y + 1);
					visited[nx][ny] = false;
					domino[left][right] = false;
					domino[right][left] = false;
				}
			}

			nx = x;
			ny = y + 1;
			if (ny < 7) {
				int right = map[nx][ny];

				if (!visited[nx][ny] && !domino[left][right]) {
					visited[nx][ny] = true;
					domino[left][right] = true;
					domino[right][left] = true;
					find(x, y + 1);
					visited[nx][ny] = false;
					domino[left][right] = false;
					domino[right][left] = false;
				}
			}

			visited[x][y] = false;
		} else {
			find(x, y + 1);
		}
	}
}
