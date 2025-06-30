

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Problem> pq = new PriorityQueue<>(Comparator.comparingLong((Problem o) -> o.D).thenComparingLong(o->o.P));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long D = Integer.parseInt(st.nextToken());
			long P = Integer.parseInt(st.nextToken());
			long T = Integer.parseInt(st.nextToken());
			long E = Integer.parseInt(st.nextToken());

			if (T == 1) {
				P = 0;
			}
			if (E == 1) {
				D = D / 2 + D % 2;

				P = P / 2;
			}
			Problem p = new Problem(i, D, P, T);
			pq.offer(p);
		}

		st = new StringTokenizer(br.readLine());
		long hd = Integer.parseInt(st.nextToken());
		long hp = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> vq = new PriorityQueue<>();
		long cnt = 0;
		while (M-- > 0) {
			while (!pq.isEmpty() && pq.peek().D <= hd) {
				vq.offer(pq.poll().P);
			}

			if (vq.isEmpty()) {
				System.out.println(-1);
				return;
			}

			long v = vq.poll();
			if (v > hp) {
				cnt += v - hp;
			}
			hd++;
			hp++;
		}
		System.out.println(cnt);
	}

	public static class Problem{
		long idx, D,P,T;

		public Problem(int idx, long D, long P, long T) {
			this.idx = idx;
			this.D = D;
			this.P = P;
			this.T = T;
		}

		@Override
		public String toString() {
			return "Problem{" +
				"idx=" + idx +
				", D=" + D +
				", P=" + P +
				", T=" + T +
				'}';
		}
	}
}
