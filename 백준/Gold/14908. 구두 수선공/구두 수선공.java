

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Data> pq = new PriorityQueue<>(
			Comparator.comparingDouble((Data o) -> -(double)o.s / (double)o.t).thenComparingInt(o -> o.idx));
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			pq.offer(new Data(i, t, s));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			// System.out.println(now);
			sb.append(now.idx).append(" ");
		}
		System.out.println(sb);
	}

	public static class Data{
		int idx;
		int t;
		int s;

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", t=" + t +
				", s=" + s +
				'}';
		}

		public Data(int idx, int t, int s) {
			this.idx = idx;
			this.t = t;
			this.s = s;
		}
	}
}
