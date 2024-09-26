package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_14442_벽부수고이동하기2 {
	public static int N, M, K;
	public static int[][] data;
	public static boolean[][][] visited;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		visited = new boolean[K+1][N][M];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				data[i][j] = input[j]-'0';
			}
		}

		find();
	}

	public static void find() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, K,1));
		int result = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				result = now.length;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// System.out.println(now);
					if (data[nx][ny] == 1 && now.k > 0 && !visited[now.k - 1][nx][ny]) {
						visited[now.k - 1][nx][ny] = true;
						q.offer(new Node( nx, ny,now.k-1,now.length+1));
					} else if (data[nx][ny] == 0 && !visited[now.k][nx][ny]) {
						visited[now.k][nx][ny] = true;
						q.offer(new Node(nx, ny, now.k,now.length+1));
					}
				}
			}
		}
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	public static class Node{
		int x;
		int y;
		int k;
		int length;

		public Node(int x, int y, int k, int length) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.length = length;
		}

		public String toString() {
			return "x = " + x + ", y = " + y + ", k = " + k + ", length = "+length;
		}
	}
}
