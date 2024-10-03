package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_18232_텔레포트경기장 {
	public static int N, M;
	public static int S, E;
	public static boolean[] visited;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		find();
	}

	public static void find() {
		visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(S);
		visited[S] = true;

		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			// System.out.println("turn = "+result +", size = "+size);
			for (int s = 0; s < size; s++) {
				int now = q.poll();

				// System.out.println(now);
				if (now == E) {
					System.out.println(result);
					return;
				}

				if (now > 0 && !visited[now - 1]) {
					visited[now-1] = true;
					q.offer(now-1);
				}
				if (now + 1 <= N && !visited[now + 1]) {
					visited[now+1] = true;
					q.offer(now + 1);
				}
				for (int next : list[now]) {
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
