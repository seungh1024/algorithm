

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		TreeSet<Integer> set = new TreeSet<>();
		int point = 0;
		st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			if (data[i] == 1) {
				set.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			if (q == 1) {
				int idx = Integer.parseInt(st.nextToken()) - 1;
				if (data[idx] == 0) {
					data[idx] = 1;
					set.add(idx);
				} else {
					data[idx] = 0;
					set.remove(idx);
				}
			} else if (q == 2) {
				int x = Integer.parseInt(st.nextToken());
				point += x;
				point %= N;
			} else if (q == 3) {
				int jump = find(N, point, set);
				sb.append(jump).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static int find(int N, int point, TreeSet<Integer> set) {
		if (set.isEmpty()) {
			return -1;
		}
		Integer ceiling = set.ceiling(point);
		if (ceiling == null) {
			return N - point + set.first();
		} else {
			return ceiling-point;
		}
	}
}
