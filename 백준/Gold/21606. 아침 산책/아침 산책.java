

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static boolean[] inOut;
	public static List<Integer>[] list;
	public static boolean[] visited;
	public static long[] count;

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

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		visited = new boolean[N + 1];
		count = new long[N + 1];
		long result = 0;
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			if (inOut[i]) {
				find(i);
				// System.out.println("i = "+i);
				// System.out.println(Arrays.toString(count));
				visited[i] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			result += count[i];
		}


		System.out.println(result);
	}

	public static void find(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);

		long cnt = 0;
		List<Integer> last = new ArrayList<>();
		while (!q.isEmpty()) {
			int now = q.poll();

			if (inOut[now] && start != now) {
				count[start]++;
				count[now]++;
				continue;
			}

			for (int next : list[now]) {
				if (!visited[next]) {
					last.add(next);
					visited[next] = true;
					q.offer(next);
				}
			}
		}

		for (int i : last) {
			if (i!=start) {
				visited[i] = false;
			}
		}
	}

}
