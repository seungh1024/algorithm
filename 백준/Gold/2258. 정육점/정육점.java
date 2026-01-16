

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static Data[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new Data[N + 1];
		data[0] = new Data(Integer.MAX_VALUE, 0);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			data[i] = new Data(w, c);
		}
		Arrays.sort(data, Comparator.comparingInt((Data o) -> o.c).thenComparingInt(o -> -o.w));

		long min = Long.MAX_VALUE;
		long money = 0;
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			if (data[i - 1].c != data[i].c) {
				money = 0;
			}
			money += data[i].c;

			sum += data[i].w;
			if (sum >= M) {
				min = Math.min(min, money);
			}
		}
		if (min == Long.MAX_VALUE) {
			min = -1;
		}

		System.out.println(min);
	}

	public static int find() {
		int start = 1;
		int end = Integer.MAX_VALUE;
		while (start < end) {
			int mid = (start + end) / 2;
			boolean b = check(mid);
			if (b) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (check(start - 1)) {
			start--;
		}
		if (!check(start)) {
			start = -1;
		}

		return start;
	}

	public static boolean check(int target) {
		int sum = 0;
		int money = 0;

		for (int i = 1; i <= N; i++) {
			if (data[i - 1].c != data[i].c) {
				money = 0;
			}
			money += data[i].c;

			sum += data[i].w;
			if (sum >= M && money<= target) {

				return true;
			}
		}

		return false;
	}

	public static class Data{
		int w;
		int c;

		@Override
		public String toString() {
			return "Data{" +
				"w=" + w +
				", c=" + c +
				'}';
		}

		public Data(int w, int c) {
			this.w = w;
			this.c = c;
		}
	}
}
