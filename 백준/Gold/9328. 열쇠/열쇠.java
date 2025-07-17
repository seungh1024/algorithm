

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M;
	public static char[][] data;
	public static Set<Integer> set;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			data = new char[N+2][M+2];
			for (int i = 0; i <= N+1; i++) {
				for (int j = 0; j <= M + 1; j++) {
					data[i][j] = '.';
				}
			}
			for (int i = 1; i <= N; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 1; j <= M; j++) {
					data[i][j] = input[j - 1];
				}
			}
			set = new HashSet<>();
			char[] input = br.readLine().toCharArray();
			for (char c : input) {
				set.add(c-32);
			}

			// for (int i = 0; i <= N + 1; i++) {
			// 	System.out.println(Arrays.toString(data[i]));
			// }
			find();
			// System.out.println("end");
		}

	}

	public static void find() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 2][M + 2];
		q.offer(new int[] {0, 0});
		visited[0][0] = true;

		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 'A'; i <= 'Z'; i++) {
			map.put(i, new ArrayList<>());
		}

		int result = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// System.out.println(Arrays.toString(now));
			for (int d = 0; d < 4; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];
				if (nx >= 0 && nx <= N + 1 && ny >= 0 && ny <= M + 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (data[nx][ny] != '*') {
						if (data[nx][ny] == '$') {
							result++;
							q.offer(new int[] {nx, ny});
						} else if (data[nx][ny] == '.') {
							q.offer(new int[] {nx, ny});
						} else {
							if (data[nx][ny] < 'a') {
								int key = data[nx][ny];
								if (!set.contains(key)) {
									List<int[]> list = map.get(key);
									list.add(new int[] {nx, ny});
								} else {
									q.offer(new int[] {nx, ny});
								}
							} else {
								int key = data[nx][ny] - 32;
								if (!set.contains(key)) {
									List<int[]> list = map.get(key);
									for (int[] i : list) {
										q.offer(i);
									}
									map.remove(key);
								}
								set.add(key);
								q.offer(new int[] {nx, ny});
							}
						}
					}
				}
			}
		}

		System.out.println(result);
	}
}
