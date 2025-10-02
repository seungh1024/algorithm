

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data);
		long result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int target = data[i] + data[j];
				int cnt = find(target, j + 1, N, data);
				result += cnt;

			}
		}
		System.out.println(result);

	}

	public static int find(int target, int s, int e, int[] data) {
		int start = s;
		int end = e;

		while (start < end) {
			int mid = (start + end) / 2;

			int value = data[mid];
			if (value + target > 0) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		int right = start;

		start = s;
		end = e;

		while (start < end) {
			int mid = (start + end) / 2;
			int value = data[mid];
			if (value + target >= 0) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		int left = start;

		return right - left;
	}
}
