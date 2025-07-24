

import java.io.*;
import java.util.*;


public class Main {
	public static int N;
	public static int K;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(data);

		find();
	}

	public static void find() {
		int start = 1;
		int end = 1000000000;

		while (start < end) {
			int mid = (start + end) / 2;

			int value = getValue(mid);
			if (value <= K) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		System.out.println(start);
	}

	public static int getValue(int range) {
		int idx = 0;
		int jump = range*2;

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (data[i] - data[idx] > jump) {
				idx = i;
				cnt++;
				i--;
			}
		}
		if (idx < N) {
			cnt++;
		}

		return cnt;
	}
}
