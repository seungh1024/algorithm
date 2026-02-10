

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int N, C;
	public static int[] data;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N];
		List<Long> list1 = new ArrayList<>();
		find(0, 0, N / 2, list1);
		List<Long> list2 = new ArrayList<>();
		find(N / 2, 0, N, list2);

		Collections.sort(list2);
		int result = 0;
		for (long num : list1) {
			// System.out.println("num = "+num);
			int v = binarySearch(C - num, list2);
			// System.out.println("v = "+v);
			result += v;
		}
		System.out.println(result);

	}

	public static int binarySearch(long num, List<Long> list) {
		int start = 0;
		int end = list.size();

		while (start < end) {
			int mid = (start + end) / 2;

			if (list.get(mid) > num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start == 0 ? 1 : start;
	}

	public static void find(int idx, int sum, int limit, List<Long> list) {
		// System.out.println("idx = "+idx +", sum = "+sum);

		if (idx >= limit) {
			long v = 0;
			int start = 0;
			if (limit == N) {
				start = N / 2;
			}
			for (int i = start; i < limit; i++) {
				if (visited[i]) {
					v += data[i];
				}
			}
			if (v <= C) {
				list.add(v);
			}
			return;
		}

		visited[idx] = true;
		find(idx + 1, sum + data[idx], limit, list);
		visited[idx] = false;
		find(idx + 1, sum, limit, list);

	}

}
