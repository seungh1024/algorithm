

import java.io.*;
import java.util.*;

public class Main {
	public static int D,N, M;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+2];

		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(br.readLine());
			data[i] = num;
		}
		data[N+1] = D;
		Arrays.sort(data);

		int result = find();
		System.out.println(result);
	}

	public static int find() {
		int start = 0;
		int end = 1_000_000_000;

		while (start < end) {
			int mid = (start + end) / 2;

			if (!check(mid)) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (!check(start)) {
			start--;
		}

		return start;
	}

	public static boolean check(int jump) {
		int left = 0;
		int m = M;
		for (int right = 1; right <= N + 1; right++) {
			if (data[right] - data[left] < jump) {
				m--;
			} else {
				left = right;
			}
			if (m < 0) {
				return false;
			}
		}

		return true;
	}

	public static class Data{
		int left;
		int right;
		int value;

		@Override
		public String toString() {
			return "Data{" +
				"left=" + left +
				", right=" + right +
				", value=" + value +
				'}';
		}

		public Data(int left, int right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}
}
