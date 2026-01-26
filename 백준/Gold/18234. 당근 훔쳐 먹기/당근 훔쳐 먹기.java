

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		long cnt = T - N;
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingLong(o->o.p));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long w = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			pq.offer(new Data(w, p));
		}

		long result = 0;
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			result += now.w+ now.p*cnt;
			cnt++;
		}
		System.out.println(result);
	}

	public static class Data {
		long w;
		long p;

		@Override
		public String toString() {
			return "Data{" +
				"w=" + w +
				", p=" + p +
				'}';
		}

		public Data(long w, long p) {
			this.w = w;
			this.p = p;
		}
	}
}
