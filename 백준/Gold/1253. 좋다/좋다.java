

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] data = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			data[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(data);

		int[] check = new int[N + 1];

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				long sum = data[i] + data[j];
				find(j + 1, N, sum, data, check);
				find(0, i, sum, data, check);

				find(i+1 , j, sum, data, check);
			}
		}
		for (int i = 1; i <= N; i++) {
			check[i] += check[i - 1];
		}
		int cnt = 0;
		for (int i = 0; i <= N; i++) {
			if (check[i] > 0) {
				cnt++;
			}
		}
		// System.out.println(Arrays.toString(check));
		System.out.println(cnt);
	}

	public static void find(int start, int end, long target, long[] data, int[] check) {
		int s = start;
		int e = end;

		while (s < e) {
			int mid = (s + e) / 2;

			if (data[mid] > target) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		int r = s;

		s = start;
		e = end;
		while (s < e) {
			int mid = (s + e) / 2;
			if (data[mid] >= target) {
				e = mid;
			} else {
				s = mid+1;
			}
		}
		int l = s;

		// System.out.println("start = "+start + ", target = "+target);
		// System.out.println("r = "+r +", l = "+l);

		check[l]++;
		check[r]--;

	}
}
