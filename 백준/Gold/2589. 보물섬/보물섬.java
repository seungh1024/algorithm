import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static char[][] map;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j];
			}
		}

		int maxLength = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					int result = find(i, j);
					if (result > maxLength) {
						maxLength = result;
					}
				}
			}
		}

		System.out.println(maxLength);

	}

	public static int find(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;

		int ex = x;
		int ey = y;
		int length = -1;
		while(!q.isEmpty()) {
			length++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();

				ex = now[0];
				ey = now[1];

				for (int d = 0; d < 4; d++) {
					int nx = now[0]+dx[d];
					int ny = now[1]+dy[d];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 'L') {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}

		}

		return length;
	}
}