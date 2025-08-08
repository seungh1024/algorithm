

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] ad = new int[N + 1];
		find(a,ad);
		// System.out.println(Arrays.toString(ad));
		// System.out.println("==");
		int[] bd = new int[N + 1];
		find(b, bd);
		int[] cd = new int[N + 1];
		find(c, cd);
		for (int i = 1; i <= N; i++) {
			if (bd[i] > 0 && cd[i] > 0) {
				bd[i] = Math.min(bd[i], cd[i]);
			} else if (bd[i] == 0 && cd[i] > 0) {
				bd[i] = cd[i];
			}
		}

		String result = "NO";
		for (int i = 1; i <= N; i++) {
			if (ad[i] > 0 && ad[i] < bd[i]) {
				result = "YES";
				break;
			}
		}
		System.out.println(result);
	}

	public static void find(int start, int[] dis) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[] {start, 1});
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 1;
		boolean[] visited = new boolean[N + 1];

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int from = now[0];
			int cost = now[1];


			if(visited[from]) continue;
			visited[from] = true;
			if (list[from].size() == 1) {
				dis[from] = cost;
			}

			for (int next : list[from]) {
				if (!visited[next] && distance[next] > distance[from] + 1) {
					distance[next] = distance[from] + 1;
					pq.offer(new int[] {next, distance[next]});
				}
			}
		}
	}
}
