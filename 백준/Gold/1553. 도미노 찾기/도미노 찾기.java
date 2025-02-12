import java.io.*;
import java.util.*;

public class Main {
	public static boolean[][] visited,domino;
	public static int[][] data;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = new int[8][7];
		for (int i = 0; i < 8; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 7; j++) {
				data[i][j] = input[j] - '0';
			}
		}

		visited = new boolean[8][7];
		domino = new boolean[7][7];
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
			int left = data[x][y];

			int nx = x + 1;
			int ny = y;

			if (nx < 8) {
				int right = data[nx][ny];
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
				int right = data[nx][ny];
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