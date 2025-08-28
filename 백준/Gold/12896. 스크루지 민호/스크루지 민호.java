

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

		int[] first = getFarPoint(1); // 현재 지점에서 가장 먼 지점 탐색
		int[] second = getFarPoint(first[1]); // first로부터 가장 먼 지점 탐색 -> 트리 내에서 가장 먼 양 끝단
		int[] third = getFarPoint(second[2]); // 중앙 지점에서 가장 먼 거리를 찾음
		System.out.println(third[0]);

	}

	public static int[] getFarPoint(int start) {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(start, 0));


		int[] lastIndex = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		int cnt = -1;
		int last = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Data now = q.poll();
				last = now.to;
				// System.out.println("now = "+now);
				for (int next : list[now.to]) {
					if(visited[next]) continue;
					// System.out.println("next = "+next);
					visited[next] = true;
					lastIndex[next] = now.to;
					q.offer(new Data(next, now.to + 1));
				}
			}
			cnt++;
			// System.out.println("cnt = "+cnt + " pq = "+q);
		}

		// System.out.println("start = "+start);
		// System.out.println(Arrays.toString(lastIndex));

		int idx = last;
		// System.out.println("start idx = "+idx);
		for (int i = 1; i <= cnt/2; i++) {
			idx = lastIndex[idx];
			// System.out.println("idx = "+idx);
		}

		// System.out.println("cnt = "+cnt + ", idx = "+idx +", last = "+last);

		return new int[] {cnt, last, idx};
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public String toString(){
			return " to = " + to + ", cost = " + cost;
		}
	}
}
