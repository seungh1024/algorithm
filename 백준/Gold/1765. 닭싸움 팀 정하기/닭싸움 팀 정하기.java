

import java.io.*;
import java.util.*;


public class Main {
	public static int N;
	public static int M;
	public static int[] parent;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		list = new ArrayList[N + 1];
		Queue<Integer>[] q = new ArrayDeque[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			list[i] = new ArrayList<>();
			q[i] = new ArrayDeque<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (c == 'F') {
				union(a, b);
			} else {
				list[a].add(b);
				list[b].add(a);
			}
		}
		int[] count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int p = getParent(i);
			count[p]++;
		}



		for (int i = 1; i <= N; i++) {
			int p = parent[i];
			q[p].offer(i);
		}

		int result = 0;
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if(q[i].isEmpty()) continue;


			int size = q[i].size();
			boolean[] check = new boolean[N + 1];
			for (int s = 0; s < size; s++) {
				int now = q[i].poll();
				visited[now] = true;

				for (int next : list[now]) {
					if (!check[next] && parent[next] != parent[now]) {
						check[next] = true;
						q[i].offer(next);
					}
				}
			}
			// System.out.println("i = "+i+", "+q[i]);

			while (!q[i].isEmpty()) {
				int now = q[i].poll();

				for (int next : list[now]) {
					if (parent[next] != parent[now]) {
						// visited[next] = true;
						union(i,next);
					}
				}
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(getParent(i));
		}
		System.out.println(set.size());
		// System.out.println(Arrays.toString(parent));
	}


	public static int getParent(int i) {
		if (i == parent[i]) {
			return i;
		}

		return parent[i] = getParent(parent[i]);
	}

	public static void union(int a, int b) {
		int parentA = getParent(a);
		int parentB = getParent(b);

		if (parentA <= parentB) {
			parent[parentB] = parentA;
		} else {
			parent[parentA] = parentB;
		}
	}

}
