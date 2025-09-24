

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.from));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = (to - from + (L - 1)) / L;
			pq.offer(new Data(from, to, cnt));
		}


		int result = 0;
		int point = 0;
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			int left = Math.max(point, now.from);
			int right = Math.max(point, now.to);
			if (right > left) {
				int cnt = (right - left + (L - 1)) / L;
				result += cnt;
				int size = cnt*L;
				point = left+size;
			}
		}

		System.out.println(result);

	}

	public static class Data{
		int from;
		int to;
		int cnt;

		@Override
		public String toString() {
			return "Data{" +
				"from=" + from +
				", to=" + to +
				", cnt=" + cnt +
				'}';
		}

		public Data(int from, int to, int cnt) {
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}
	}
}
