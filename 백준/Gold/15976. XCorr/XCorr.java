

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] xarr;
	public static int[] xidx;
	public static int M;
	public static int[] yidx;
	public static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		xarr = new int[N + 1];
		xidx = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xidx[i] = Integer.parseInt(st.nextToken())+1;
			xarr[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		yidx = new int[M + 1];
		sum = new long[M + 1];
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			yidx[i] = Integer.parseInt(st.nextToken())+1;
			sum[i] += sum[i - 1] + Long.parseLong(st.nextToken());
		}

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		long result = 0;
		for (int i = 1; i <= N; i++) {
			int idx = xidx[i];
			int left = getLeft(idx + a);
			int right = getRight(idx + b);

			// System.out.println("i = "+i +", left = "+left +", right = "+right);
			long s = sum[right] - sum[left];
			result += xarr[i] * s;
		}

		System.out.println(result);

	}

	public static int getLeft(int idx) {
		int start = 1;
		int end = M;

		while (start < end) {
			int mid = (start + end) / 2;
			int target = yidx[mid];

			if (target >= idx) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (yidx[start] >= idx) {
			start--;
		}
		return start;
	}

	public static int getRight(int idx) {
		int start = 1;
		int end = M+1;

		while (start < end) {
			int mid = (start + end) / 2;
			int target = yidx[mid];

			if (target > idx) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		start--;

		return start;

	}
}
