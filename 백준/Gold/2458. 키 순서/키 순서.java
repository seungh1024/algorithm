import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] count;
	public static int[] parent;
	public static int[] child;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new ArrayList[N + 1];
		List<Integer>[] list2 = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}

		count = new int[N + 1];
		parent = new int[N + 1];
		child = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list2[to].add(from);
			count[to]++;
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				cnt++;
			}
		}

		int result = 0;


		for (int i = 1; i <= N; i++) {
			find(i,parent,list);
			find(i,child,list2);

		}
		for (int i = 1; i <= N; i++) {
			if (parent[i]  + child[i] == N-1) {
				result ++;
			}

		}
		// System.out.println(Arrays.toString(parent));
		// System.out.println(Arrays.toString(child));

		System.out.println(result);

	}

	public static void find(int start, int[] arr, List<Integer>[] list) {

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list[now]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
					arr[next]++;
				}
			}
		}



	}


}