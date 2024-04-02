package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_13397_구간나누기2 {
	public static int N,M;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];

		st = new StringTokenizer(br.readLine());
		data[0] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int result = find();
		System.out.println(result);
	}

	public static int find() {
		int start = 0;
		int end = 10_000;

		while (start < end) {
			int mid = (start + end) / 2;
			int count = getCount(mid);

			if (count <= M) {
				end = mid;
			} else {
				start = mid +1;
			}
		}

		return start;
	}

	public static int getCount(int num) {
		int count = 1;

		int min = 10_001;
		int max = 0;
		for (int i = 0; i < N; i++) {
			min = Math.min(min,data[i]);
			max = Math.max(max,data[i]);
			if (max - min > num) {
				count++;
				max = 0;
				min = 10_001;
				i--;
			}
		}
		if (max - min == num) {
			// count++;
		}
		// System.out.println("num ="+num);
		// System.out.println(count);

		return count;
	}
}
