

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list[from].add(new Data(to, cost));
				list[to].add(new Data(from, cost));
			}

			// int start = 1;
			// for (int i = 1; i <= N; i++) {
			// 	if (list[i].size() > 1) {
			// 		start = i;
			// 		break;
			// 	}
			// }

			int result = find(1, 0, Integer.MAX_VALUE);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int idx, int parent, int cost) {
		if (parent != 0 && list[idx].size() == 1) {
			return cost;
		}
		int sum = 0;
		for (Data next : list[idx]) {
			if(next.to == parent) continue;
			// System.out.println("now = "+idx +", next = "+next.to);
			sum += find(next.to, idx, next.cost);
		}
		// System.out.println("idx = " + idx + ", parent = " + parent + ", cost = " + cost + ", sum = " + sum);
		return Math.min(sum, cost);
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}


// 1
// 8 7
// 1 2 3
// 2 3 4
// 2 4 1
// 5 1 4
// 6 5 1
// 7 5 2
// 3 8 1