

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] xInfo, yInfo;
	public static long[] xSum, ySum;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		xInfo = new int[N + 1];
		yInfo = new int[N + 1];
		xSum = new long[N + 1];
		ySum = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xInfo[i] = x + 1000000;
			yInfo[i] = y + 1000000;
		}
		Arrays.sort(xInfo);
		Arrays.sort(yInfo);

		for (int i = 1; i <= N; i++) {
			xSum[i] += xSum[i - 1] + xInfo[i];
			ySum[i] += ySum[i - 1] + yInfo[i];
		}

		StringBuilder sb = new StringBuilder();
		char[] cmd = br.readLine().toCharArray();
		int x = 1000000;
		int y = 1000000;
		for (char c : cmd) {
			if (c == 'S') {
				y++;
			} else if (c == 'J') {
				y--;
			} else if (c == 'I') {
				x++;
			} else if (c == 'Z') {
				x--;
			}

			long result = find(x, xInfo, xSum);
			result +=find(y, yInfo, ySum);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static long find(long target, int[] arr, long[] sum) {
		int start = 1;
		int end = N;

		while (start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		long left = target * (start-1) - sum[start - 1];
		long right = Math.abs(sum[N] - sum[start - 1] - target * (N - start + 1));
		// System.out.println(sum[N]-sum[start-1]);
		// System.out.println(target*(N-start+1));
		// System.out.println("start = "+start + "< left = "+left + ", right = "+right);

		return right+left;
	}
}
