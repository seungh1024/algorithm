

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long mod = 1000000007;

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] data = new long[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				data[i] = Long.parseLong(st.nextToken());
			}
			if (N == 1) {
				sb.append(1).append("\n");
				continue;
			}

			PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((long[] o)->o[0]).thenComparingLong(o->o[1]));
			for (int i = 1; i <= N; i++) {
				long a = data[i]/mod;
				long b = data[i]%mod;
				pq.offer(new long[]{a,b});
			}

			long sum = 1;
			while (pq.size()>=2) {
				long[] now = pq.poll();
				long[] next = pq.poll();

				long a = now[0] + next[0];
				long value = now[1] * next[1];
				a += value/mod;
				long b = value%mod;
				sum *= b;
				sum %= mod;
				pq.offer(new long[] {a, b});
			}
			sb.append(sum).append("\n");

		}
		System.out.println(sb);
	}
}
