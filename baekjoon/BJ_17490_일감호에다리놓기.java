package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_17490_일감호에다리놓기 {
	public static int N, M;
	public static long K;
	public static int[] data;
	public static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		data = new int[N+1];
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		st= new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		List<int[]> list = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int[] data = {from, to};
			Arrays.sort(data);
			list.add(data);

			if (from == 1 && to == N) {
				visited[from] = true;
			} else {
				visited[to] = true;
			}
		}
		Collections.sort(list, Comparator.comparingInt(o -> o[0]));

		for (int i = 1; i < N; i++) {
			if (!visited[i + 1]) {
				union(i, i + 1);
			}
		}
		if (!visited[1]) {
			union(1, N);
		}

		for (int i = 1; i <= N; i++) {
			getParent(i);
		}

		// System.out.println(Arrays.toString(parent));
		// System.out.println(Arrays.toString(data));

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(parent[i]);
		}
		long k = 0;
		if (set.size() > 1) {
			for (int i : set) {
				k += data[i];
			}
		}
		if (k <= K) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		// System.out.println(k);
	}

	public static int getParent(int i) {
		if (i == parent[i]) {
			return i;
		}

		return parent[i] = getParent(parent[i]);
	}

	public static void union(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);

		int min = Math.min(data[pa], data[pb]);
		if (pa <= pb) {
			parent[pb] = pa;
			data[pa] = min;
		} else {
			parent[pa] = pb;
			data[pb] = min;
		}
	}

}
