package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_2230_수고르기이분탐색 {
	public static int N,M;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+1];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		data[N] = Integer.MAX_VALUE;
		Arrays.sort(data);

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int left = getLeft(data[i],0,i);
			// System.out.println("data = "+data[i] + ", left = "+data[left]);
			if (data[i] - data[left] >= M) {
				min = Math.min(min, data[i]-data[left]);
			}
			int right = getRight(data[i],i,N+1);
			if (data[right] - data[i] >= M) {
				min = Math.min(min,data[right]-data[i]);
			}

		}
		System.out.println(min);
	}
	public static int getLeft(int num, int start, int end) {
		while (start < end) {
			int mid = (start+end+1)/2;

			if (Math.abs(data[mid] - num) >= M) {
				start = mid;
			} else {
				end = mid-1;
			}
		}
		return start;
	}

	public static int getRight(int num, int start, int end) {

		while (start < end) {
			int mid = (start + end)/2;

			if (Math.abs(data[mid] - num) >= M) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}
}
