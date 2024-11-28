package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_10472_십자뒤집기 {
	public static int end;
	public static int[][] indexes = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	public static Map<Integer,int[]> map;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			end = 0;
			int idx = 1;
			map = new HashMap<>();
			for (int i = 0; i < 3; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < 3; j++) {
					if (input[j] == '*') {
						end = end | 1<<idx;
					}
					map.put(idx, new int[] {i, j});
					idx++;
				}
			}

			// System.out.println("t = "+t);
			find();
			// System.out.println("end = "+end);
		}
	}

	public static void find() {
		boolean[] visited = new boolean[2000];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		visited[0] = true;

		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int now = q.poll();
				// System.out.println("now = "+now);

				if (now == end) {
					System.out.println(result);
					return;
				}

				for (int i = 1; i < 10; i++) {
					int[] xy = map.get(i);
					int x = xy[0];
					int y = xy[1];
					int next = now ^ 1 << indexes[x][y];
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y +dy[d];
						if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
							next = next ^ 1 << indexes[nx][ny];
						}
					}

					if (!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			result++;
		}
	}


}
