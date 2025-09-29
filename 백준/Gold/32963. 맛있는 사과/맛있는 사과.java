

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		Apple[] apples = new Apple[N];

		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st2.nextToken());
			apples[i] = new Apple(t, s);
		}
		Arrays.sort(apples,Comparator.comparingInt((Apple o)->o.t));

		int[] count = new int[N+1];
		int size= -1;
		int cnt = 0;

		for (int i = N-1; i >= 0; i--) {
			Apple a = apples[i];
			if (a.s == size) {
				cnt++;
			} else if (a.s > size) {
				size = a.s;
				cnt = 1;
			}
			count[i] = cnt;
		}
		// System.out.println(Arrays.toString(apples));
		// System.out.println(Arrays.toString(count));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int p = Integer.parseInt(br.readLine());
			// System.out.println("p = "+p);
			int idx = getLeft(p,apples);
			// System.out.println("idx = "+idx);
			sb.append(count[idx]).append("\n");
		}
		System.out.println(sb);
	}

	public static int getLeft(int target, Apple[] data) {
		int start = 0;
		int end = data.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (data[mid].t >= target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}

	public static int getRight(int target, Apple[] data) {
		int start = 0;
		int end = data.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (data[mid].t > target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}

	public static class Apple {
		int t;
		int s;

		public Apple(int t, int s) {
			this.t = t;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Apple{" +
				"t=" + t +
				", s=" + s +
				'}';
		}
	}
}
