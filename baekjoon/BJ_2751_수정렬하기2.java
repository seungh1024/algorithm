package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_2751_수정렬하기2 {
	public static int N;
	public static int[] data;
	public static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		temp = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(0,N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(data[i]).append("\n");
		}
		System.out.println(sb);
	}

	public static void mergeSort(int start, int end) {
		// System.out.println("start = "+start +", end = "+end);
		if (start + 1 == end) {
			return;
		}

		int mid = (start+end)/2;
		mergeSort(start,mid);
		mergeSort(mid,end);
		merge(start,mid,end);
	}

	public static void merge(int start, int mid, int end) {
		int ai = start;
		int bi = mid;

		for (int i = start; i < end; i++) {
			if (ai == mid) {
				temp[i] = data[bi++];
			} else if (bi == end) {
				temp[i] = data[ai++];
			} else if (data[ai] >= data[bi]) {
				temp[i] = data[bi++];
			} else if (data[ai] < data[bi]) {
				temp[i] = data[ai++];
			}
		}

		for (int i = start; i < end; i++) {
			data[i] = temp[i];
		}
	}
}
