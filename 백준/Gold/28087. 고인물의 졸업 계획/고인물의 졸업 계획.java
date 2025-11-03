

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o)->o[1]));
		for (int i = 1; i <= M; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(new int[]{i,num});
		}

		PriorityQueue<int[]> X = new PriorityQueue<>(Comparator.comparingInt((int[] o)->-o[1]));
		int sum = 0;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();

			if (sum + now[1] < N) {
				sum += now[1];
				X.offer(now);
			} else if (sum + now[1] >= N && sum + now[1] <= 2 * N) {
				sum += now[1];
				X.offer(now);
				break;
			} else {
				while (!X.isEmpty()) {
					int[] last = X.poll();
					sum -= last[1];
					if (sum + now[1] <= 2 * N) {
						sum += now[1];
						X.offer(now);
						break;
					}
				}

				if (sum >= N && sum <= 2 * N) {
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(X.size()).append("\n");
		while (!X.isEmpty()) {
			sb.append(X.poll()[0]).append("\n");
		}
		System.out.println(sb);
	}
}
