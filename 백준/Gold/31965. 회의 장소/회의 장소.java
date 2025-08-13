

import java.io.*;
import java.util.*;

public class Main {
	public static int N, Q;
	public static int[] data;
	public static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		data = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);

		sum = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] += sum[i - 1] + data[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			long result = find(from, to);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static long find(int from, int to) {
		int start = 1;
		int end = N;

		while (start < end) {
			int mid = (start + end) / 2;

			if (data[mid] >= from) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		int left = start;

		start = 1;
		end = N+1;
		while (start < end) {
			int mid = (start + end) / 2;

			if (data[mid] > to) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		int right = start-1;

		if (left >= right) {
			return 0;
		}

		long maxCost = Math.max(getCost(left, left, right), getCost(right, left, right));
		long minCost = getCost((left + right) / 2, left, right);

		// System.out.println("left = "+left + ", right = "+right);
		// System.out.println("maxCost = "+maxCost + ", minCost = "+minCost);

		return maxCost-minCost;
	}

	public static long getCost(int target, int left, int right) {
		long r = Math.abs(sum[right] - sum[target] - data[target]*(long)(right-(target)));
		long l = Math.abs(data[target]*(long)(target-left) - (sum[target-1]-sum[left-1]));
		// System.out.println("l = "+l + ", r = "+r);

		return l+r;
	}
}
