

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[] dp;
	public static int[] index;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N+1];
		dp[1] = data[1];
		int cnt = 1;
		for (int i = 2; i <= N; i++) {
			if (dp[cnt] < data[i]) {
				cnt++;
				dp[cnt] = data[i];
			} else {
				int idx = binarySearch(cnt, data[i]);
				dp[idx] = data[i];
			}
		}
		System.out.println(cnt);

	}

	public static int binarySearch(int end, int target) {
		int start = 1;

		while (start < end) {
			int mid = (start+end)/2;

			if (dp[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}
