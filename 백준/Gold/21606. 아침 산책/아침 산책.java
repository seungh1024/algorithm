

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static boolean[] inOut;
	public static List<Integer>[] list;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		inOut = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (input[i-1] - '0' == 1) {
				inOut[i] = true; // 실내
			}
		}
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		long result = 0;
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);

			if (inOut[from] && inOut[to]) {
				result+=2;
			}
		}

		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			if (!inOut[i]) {
				visited[i] = true;
				long cnt = find(i);
				// System.out.println("i = " + i + ", cnt = " + cnt);
				result += (cnt * (cnt - 1));
			}
		}




		System.out.println(result);
	}


	public static long find(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);

		long cnt = 0;
		boolean[] check = new boolean[N + 1];
		while (!q.isEmpty()) {
			int now = q.poll();

			if (inOut[now]) {
				cnt++;
				continue;
			} else {
				visited[now] = true;
			}

			for (int next : list[now]) {
				if (!check[next]) {
					check[next] = true;
					q.offer(next);
				}
			}
		}

		if (cnt < 2) {
			cnt = 0;
		}

		return cnt;
	}

}
