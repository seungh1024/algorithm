import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static char[][] data;
	public static Data start,end;
	public static Queue<Data> water;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new char[N][M];

		water = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				data[i][j] = input[j];
				if (data[i][j] == 'D') {
					end = new Data(i, j);
				} else if (data[i][j] == 'S') {
					start = new Data(i, j);
				} else if (data[i][j] == '*') {
					water.offer(new Data(i, j));
				}
			}
		}

		find();
	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(start);
		boolean[][] visited = new boolean[N][M];
		visited[start.x][start.y] = true;

		boolean flag = false;
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Data now = q.poll();
				if (data[now.x][now.y] == '*') {
					// System.out.println("fail = "+ now.x + ", "+now.y);
					continue;
				}

				// System.out.println(now);
				if (now.x == end.x && now.y == end.y) {
					flag = true;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					// System.out.println("nx = "+nx + ", ny = "+ny);
					if (check(nx, ny) && (data[nx][ny] == '.' || data[nx][ny] == 'D') && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Data(nx, ny));
					}
				}
			}
			if (flag) {
				break;
			}

			// printData();

			size = water.size();

			for (int s = 0; s < size; s++) {
				Data now = water.poll();

				for (int d = 0; d < 4; d++) {
					int nx= now.x+dx[d];
					int ny = now.y + dy[d];

					if (check(nx, ny) && data[nx][ny] == '.') {
						data[nx][ny] = '*';
						water.offer(new Data(nx, ny));
					}
				}
			}



			time++;
		}

		if (flag) {
			System.out.println(time);
		} else {
			System.out.println("KAKTUS");
		}
	}

	public static void printData() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
	public static class Data{
		int x;
		int y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
}