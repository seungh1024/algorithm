

import java.io.*;
import java.util.*;

public class Main {
	public static List<Integer>[] list;
	public static int[] job;
	public static List<Integer> start;
	public static int[] count;

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
			if(input == null || input.isEmpty() || input.isBlank()) break;

			StringTokenizer st = new StringTokenizer(input);
			Character now = st.nextToken().charAt(0);
			int time = Integer.parseInt(st.nextToken());
			int idx = now - 'A';
			job[idx] = time;

			if (st.hasMoreTokens()) {
				char[] arr = st.nextToken().toCharArray();
				for (char c : arr) {
					int lastIdx = c - 'A';
					list[lastIdx].add(idx);
					count[idx]++;
				}
			} else {
				start.add(idx);
			}
		}
		find();
	}

	public static void find() {
		int max = 0;
		Queue<int[]> q = new ArrayDeque<>();
		for (int i : start) {
			q.offer(new int[] {i, job[i]});
			max = Math.max(max, job[i]);
		}

		int[] maxValue = new int[26];

		while (!q.isEmpty()) {
			int[] now = q.poll();


			for (int next : list[now[0]]) {
				count[next]--;
				maxValue[next] = Math.max(maxValue[next], now[1] + job[next]);
				max = Math.max(max, maxValue[next]);
				if(count[next] > 0) continue;

				q.offer(new int[] {next, maxValue[next]});
			}
		}
		// System.out.println(Arrays.toString(maxValue));
		System.out.println(max);
	}
}
