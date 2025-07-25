

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		// System.out.println(Arrays.toString(data));
		find();
	}
	public static void find() {
		int start = 1;
		int end = 300000;


		while (start < end) {
			int mid = (start + end) / 2;

			int value = getValue(mid);
			// System.out.println("value = "+value + ", mid = "+mid);

			if (value <= mid) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		if (getValue(start) != start) {
			start--;
		}


		System.out.println(start);
		// System.out.println("??"+getValue(4));
	}

	public static int getValue(int size) {
		int cnt = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (data[i] < size) {
				max = Math.max(max, cnt);
				cnt = 0;
				continue;
			}
			cnt++;
		}
		max = Math.max(max, cnt);
		// System.out.println(cnt + ", " + max);

		return max;

	}
}
