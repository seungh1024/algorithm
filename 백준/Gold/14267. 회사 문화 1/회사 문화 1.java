import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] parent;
	public static int[] amount;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}

		amount = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			amount[idx] += cost;
		}

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			if(parent[i] == -1) continue;
			int p = parent[i];
			list[p].add(i);
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list[now]) {
				q.offer(next);
				amount[next] += amount[now];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(amount[i]).append(" ");
		}
		System.out.println(sb);

	}
}