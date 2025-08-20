

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] left, right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		left = new int[N+1];
		right = new int[N+1];
		int[][] data = new int[N+1][2];

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = a-b;
			int r = a+b;
			left[i] = l;
			right[i] = r;
			data[i][0] = l;
			data[i][1] = r;
		}

		left[0] = Integer.MIN_VALUE;
		right[0] = Integer.MIN_VALUE;
		Arrays.sort(left);
		Arrays.sort(right);

		for (int i = 1; i <= N; i++) {
			int l = data[i][0];
			int r = data[i][1];

			int li = getLeft(l, right);
			int ri = getRight(r, left);

			sb.append(li).append(" ").append(ri).append("\n");
		}
		System.out.println(sb);
	}

	public static int getLeft(int target, int[] arr) {
		int start = 1;
		int end = N;

		while (start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}


		return start;
	}

	public static int getRight(int target, int[] arr) {
		int start = 1;
		int end = N+1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}


		start--;
		return start;
	}
}
