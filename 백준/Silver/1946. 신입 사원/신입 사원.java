

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Data[] data = new Data[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				data[i] = new Data(a, b);
			}

			Arrays.sort(data, Comparator.comparingInt((Data o) -> o.a).thenComparingInt(o -> -o.b));
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.offer(data[0].b);
			// System.out.println("first = "+data[0]);
			int cnt = 0;
			for (int i = 1; i < N; i++) {
				Data now = data[i];
				Data last = data[i-1];
				if (last.a < now.a) { // 현재가 더 크면 b도 체크가 필요하다.
					int big = pq.peek();
					if (now.b > big) {
						cnt++;
					}
				}
				// System.out.println("now = "+now + ", cnt = "+cnt);
				pq.offer(now.b);

			}

			// System.out.println(pq);
			sb.append(N-cnt).append("\n");
		}
		System.out.println(sb);
	}

	public static class Data{
		int a;
		int b;

		public Data(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Data{" +
				"a=" + a +
				", b=" + b +
				'}';
		}
	}
}
