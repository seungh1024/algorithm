

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] data = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[N-i] = Long.parseLong(st.nextToken());
		}

		long[] sum = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] += sum[i - 1] + data[i];
		}
		// System.out.println(Arrays.toString(sum));

		long cnt = 0;
		for (int i = 1; i <= N; i++) {
			int result = find(i + 1, sum[i], sum);
			cnt += result;
		}
		System.out.println(cnt);
	}

	public static int find(int start, long target, long[] sum) {
		int end = sum.length - 1;

		int idx = start-1;
		int N = end;
		if (target >= sum[N] - sum[idx]) {
			return 0;
		}

		while (start < end) {
			int mid = (start + end) / 2;
			if (sum[mid] - sum[idx] > target && sum[N] - sum[mid] < target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return N-start;
	}

}
