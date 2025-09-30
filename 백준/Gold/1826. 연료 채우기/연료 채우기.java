

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] fuel = new int[1000001];
		int[] gs = new int[N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			fuel[a] = b;
			gs[i] = a;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		gs[N] = L;
		Arrays.sort(gs);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int now = P;
		for (int i = 0; i <= P; i++) {
			if (fuel[i] > 0) {
				pq.offer(fuel[i]);
			}
		}

		int result = -1;
		int cnt = 0;
		while (!pq.isEmpty()) {
			if (now >= L) {
				result = cnt;
				break;
			}
			int p = pq.poll();
			int next = Math.min(L, now + p);
			for (int i = now + 1; i <= next; i++) {
				if (fuel[i] > 0) {
					pq.offer(fuel[i]);
				}
			}
			cnt++;
			now = next;
		}


		System.out.println(result);


	}

	public static int binarySearch(int N, int target, int[] gs) {
		int start = 0;
		int end = N;

		while (start < end) {
			int mid = (start + end) / 2;

			if (gs[mid] >= target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		System.out.println("start = "+start);
		if (gs[start] > target) {
			start--;
		}

		return start;
	}


	public static class Data{
		int a;
		int b;
		int cnt;

		@Override
		public String toString() {
			return "Data{" +
				"a=" + a +
				", b=" + b +
				'}';
		}

		public Data(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public Data(int a, int b, int cnt) {
			this.a = a;
			this.b = b;
			this.cnt = cnt;
		}
	}
}
