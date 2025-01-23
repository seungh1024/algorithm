import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		binarySearch();
	}

	public static void binarySearch() {
		int start = 0;
		int end =10000;

		while (start < end) {
			int mid = (start+end)/2;
			int cnt = getCount(mid);
			if (cnt < M) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(start);
		// System.out.println(getCount(start));
	}

	public static int getCount(int range) {
		int cnt = 0;
		int left = 0;
		int min = data[left];
		int max = data[left];

		for (int i = 1; i < N; i++) {
			min = Math.min(min, data[i]);
			max = Math.max(max, data[i]);
			if (Math.abs(max - min) > range) {
				cnt++;
				left = i;
				min = data[left];
				max = data[left];
			}
		}

		return cnt;
	}
}