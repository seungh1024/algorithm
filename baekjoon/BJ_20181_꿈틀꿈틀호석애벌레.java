package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_20181_꿈틀꿈틀호석애벌레 {
	public static int N,K;
	public static int[] data;
	public static long[] dp;
	public static long[] sum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new int[N];
		sum = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				sum[i] = sum[i - 1] + data[i];
			} else {
				sum[i] = data[i];
			}
		}

		dp = new long[N];
		Arrays.fill(dp, -1);
		long result = find(0);
		System.out.println(result);
		// System.out.println(Arrays.toString(dp));
	}

	public static long find(int index) {
		if (index >= N) {
			return 0;
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		long max = find(index+1);

		int target = getTarget(index);
		if (target != N) {
			long now = sum[target] - sum[index] + data[index];
			max = Math.max(max,now-K + find(target+1));
		}

		return dp[index] = max;
	}

	public static int getTarget(int start) {
		int end = N;

		long startData = sum[start];
		int originData = data[start];

		while (start < end) {
			int mid = (start + end) / 2;

			if (sum[mid] - startData + originData >= K) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

}
