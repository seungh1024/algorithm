

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o)->o[1]));
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pq.offer(new int[] {a, b});
			}

			TreeSet<Integer> set = new TreeSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(i);
			}
			int result = 0;
			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				int a = now[0];
				int b = now[1];

				Integer ceiling = set.ceiling(a);
				if (ceiling != null && ceiling <= b) {
					result++;
					set.remove(ceiling);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
