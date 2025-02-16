import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Integer>[] up,down;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		up = new ArrayList[N + 1];
		down = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			up[i] = new ArrayList<>();
			down[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			up[from].add(to);
			down[to].add(from);
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = find(i, up);
			cnt += find(i, down);
			if (cnt == N - 1) {
				result++;
			}
		}
		System.out.println(result);
	}

	public static int find(int i, List<Integer>[] list) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(i);
		boolean[] visited = new boolean[N + 1];
		visited[i] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int now = q.poll();;

			for (int next : list[now]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
					cnt++;
				}
			}
		}

		return cnt;
	}
}