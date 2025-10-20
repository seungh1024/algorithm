

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		find();
	}

	public static void find() {
		int start = 0;
		int end = 2000000;

		while (start < end) {
			int mid = (start + end) / 2;

			int cnt = getCnt(mid);
			// System.out.println("mid = "+mid + ", cnt = "+cnt);
			if (cnt < K) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		// System.out.println("start = "+start);
		if (getCnt(start) < K) {
			start--;
		}

		int min = Integer.MAX_VALUE;
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			sum += data[i];
			if (sum >= start) {
				min = Math.min(sum, min);
				// System.out.println("sum = "+sum);
				sum = 0;
				cnt++;
			}
		}
		if (cnt < K) {

			min = Math.min(sum, min);
		}

		System.out.println(min);
	}

	public static int getCnt(int target) {
		int sum = 0;
		int cnt= 0;

		for (int i = 0; i < N; i++) {
			sum += data[i];
			if (cnt < K-1 && sum >= target) {
				cnt++;
				sum = 0;

			}
		}
		if (sum >=target) {
			cnt++;
		}
		return cnt;
	}
}
