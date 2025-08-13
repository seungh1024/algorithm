

import java.io.*;
import java.util.*;

public class Main {
	public static int N, Q;
	public static long[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		data = new long[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(data);

		long[] sum = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] += sum[i - 1] + data[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			long target = Long.parseLong(br.readLine());
			int idx = find(target);
			long result = 0;
			result += Math.abs((sum[N] - sum[idx-1] - target * (long)(N - (idx - 1)))) + Math.abs(target * (long)(idx - 1) - sum[idx - 1]);

			// System.out.println("idx = "+idx);
			// System.out.println(result);
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}

	public static int find(long target) {
		int start = 1;
		int end = N+1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (target <= data[mid]) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}
}
