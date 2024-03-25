package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_2295_세수의합 {
	public static int N;
	public static int[] data, two;
	public static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(data);
		int range= N*N+1;
		two = new int[range];
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				two[index++] = data[i]+data[j];
			}
		}

		// System.out.println(Arrays.toString(two));
		Arrays.sort(two);

		int maxValue = 0;
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(data[i]-data[j] < 0) continue;
				int twoIndex = find(data[i]-data[j],range);
				if (two[twoIndex] == data[i] - data[j]) {
					// maxValue = Math.max(maxValue,data[j]);
					System.out.println(data[i]);
					return;
				}
			}
		}
		// System.out.println(maxValue);

	}

	public static int find(int num, int range) {
		// System.out.println(range);
		int start = 0;
		int end = range;

		while (start < end) {
			int mid = (start+end)/2;

			if (two[mid] >= num) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}
}
