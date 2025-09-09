

import java.io.*;
import java.util.*;

public class Main {
	public static int[][] board = {
		{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
		{10, 13, 16, 19, 25},
		{20, 22, 24, 25},
		{30, 28, 27, 26, 25},
		{25, 30, 35, 40}
	};
	public static int[] data;
	public static boolean[][] visited = new boolean[5][20];
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new int[10];
		for (int i = 0; i < 10; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}



		find(0,4,0);
		System.out.println(result);
	}

	public static void find(int idx, int count, int sum) {
		if (idx >= 10) {
			result = Math.max(result, sum);
			return;
		}
		if (count > 0) {
			int x = 0;
			int y = data[idx]-1;
			if (y == 4) {
				x = 1;
				y = 0;
			}
			if (!visited[x][y]) {
				visited[x][y] = true;
				find(idx + 1, count - 1, sum + board[x][y]);
				visited[x][y] = false;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 20; j++) {
				if (visited[i][j]) {
					visited[i][j] = false;
					if (i == 0) {
						int x = i;
						int next = j+data[idx];
						if(next == 19){
							x = 4;
							next = 3;
						} else if (next == 4) {
							x = 1;
							next = 0;
						} else if (next == 9) {
							x = 2;
							next = 0;
						} else if (next == 14) {
							x = 3;
							next = 0;
						}
						if (next < 20 && !visited[x][next]) {
							visited[x][next] = true;
							find(idx + 1, count, sum + board[x][next]);
							visited[x][next] = false;
						} else {
							find(idx + 1, count, sum);
						}
					} else if (i == 1) {
						int x = i;
						int y = j+data[idx];
						if(y==4){
							x = 4;
							y = 0;
						}
						if(y >= 5){
							x = 4;
							y -= 4;
						}

						if (x == 4 && y > 3) {
							find(idx + 1, count, sum);
						}
						else if (!visited[x][y]) {
							visited[x][y] = true;
							find(idx + 1, count, sum + board[x][y]);
							visited[x][y] = false;
						}
					} else if (i == 2) {
						int x = i;
						int y = j+data[idx];
						if(y==3){
							x = 4;
							y = 0;
						}
						if(y >= 4){
							x = 4;
							y -= 3;
						}

						if (x == 4 && y > 3) {
							find(idx + 1, count, sum);
						}
						else if ( !visited[x][y]) {
							visited[x][y] = true;
							find(idx + 1, count, sum + board[x][y]);
							visited[x][y] = false;
						}
					} else if (i == 3) {
						int x = i;
						int y = j+data[idx];
						if(y==4){
							x = 4;
							y = 0;
						}
						if(y >= 5){
							x = 4;
							y -= 4;
						}

						if (x == 4 && y > 3) {
							find(idx + 1, count, sum);
						}
						else if (!visited[x][y]) {
							visited[x][y] = true;
							find(idx + 1, count, sum + board[x][y]);
							visited[x][y] = false;
						}
					} else if (i == 4) {
						int x = i;
						int y = j+data[idx];

						if (x == 4 && y > 3) {
							find(idx + 1, count, sum);
						}
						else if (!visited[x][y]) {
							visited[x][y] = true;
							find(idx + 1, count, sum + board[x][y]);
							visited[x][y] = false;
						}
					}

					visited[i][j] = true;
				}
			}
		}
	}
}
