package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_18870_좌표압축 {
	public static int N;
	public static int[] input;
	public static int[] data;
	public static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			set.add(input[i]);
		}
		size = set.size();
		data = new int[size+1];
		int index = 0;
		for (int i : set) {
			data[index++] = i;
		}
		data[size] = Integer.MAX_VALUE;
		Arrays.sort(data);
		// System.out.println(Arrays.toString(data));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int result = find(input[i]);
			sb.append(result).append(" ");
		}
		System.out.println(sb.toString());
	}

	public static int find(int num) {
		int start = 0;
		int end = size;

		while (start < end) {
			int mid = (start+end)/2;
			if (data[mid] >= num) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		return start;
	}
}
