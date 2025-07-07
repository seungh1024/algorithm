

import java.io.*;
import java.util.*;

public class Main {
	public static List<Integer>[] list;
	public static int[] count;
	public static int[] job;
	public static List<Integer> start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			list[i] = new ArrayList<>();
		}
		job = new int[26];
		count = new int[26];
		start = new ArrayList<>();
		while (true) {
			String input = br.readLine();
			if (input == null || input.isBlank() || input.isBlank()) {
				break;
			}
			StringTokenizer st = new StringTokenizer(input);
			int to = st.nextToken().charAt(0) - 'A';
			int cost = Integer.parseInt(st.nextToken());
			job[to] = cost;

			if (st.hasMoreTokens()) {
				char[] data = st.nextToken().toCharArray();
				for (char c : data) {
					int from = c - 'A';
					list[from].add(to);
					count[to]++;
				}
			} else {
				start.add(to);
			}
		}

		find();
	}

	public static void find() {
		Queue<int[]> q = new ArrayDeque<>();
		for (int i : start) {
			q.offer(new int[] {i, job[i]});
		}

		int[] max = new int[26];

		int result = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			result = Math.max(result, now[1]);

			for(int next : list[now[0]]) {
				count[next]--;
				max[next] = Math.max(max[next], now[1] + job[next]);
				if (count[next] == 0) {
					q.offer(new int[]{next,max[next]});
				}
			}
		}

		System.out.println(result);
		// System.out.println(Arrays.toString(max));
	}
}
