

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Data[] data = new Data[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			data[i] = new Data(m, v);
		}

		TreeSet<Integer> treeSet = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < K; i++) {
			int c = Integer.parseInt(br.readLine());
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
			treeSet.add(c);
		}
		Arrays.sort(data, Comparator.comparingInt((Data o) -> -o.v).thenComparingInt((Data o) -> o.m));
		// int a = treeSet.floor(2);
		// int b = treeSet.ceiling(10);
		// System.out.println(a);
		// System.out.println(b);

		int total = 0;
		long result = 0;
		for (int i = 0; i < N && total < K; i++) {
			Data now = data[i];
			Integer c = treeSet.ceiling(now.m);
			// System.out.println("m = " + now.m + ", v= " + now.v);
			// System.out.println("c = " + c);
			if (c == null)
				continue;
			result += now.v;
			Integer cnt = map.get(c);
			cnt--;
			map.put(c, cnt);
			// System.out.println("cnt = "+cnt);
			if (cnt == 0) {
				treeSet.remove(c);
				map.remove(c);
			}
			total++;
		}

		System.out.println(result);


	}

	public static int binarySearch(int start, int m, int K, int[] C) {
		int end = K;

		while (start < end) {
			int mid = (start + end) / 2;

			if (C[mid] >= m) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}


		return start;
	}

	public static class Data{
		int m;
		int v;

		public Data(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}
