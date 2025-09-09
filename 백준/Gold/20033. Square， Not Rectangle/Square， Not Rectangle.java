

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		find();
	}

	public static void find() {
		int start = 1;
		int end = 300000;

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
		System.out.println(start);
	}

	public static boolean check(int v) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (data[i] >= v) {
				cnt++;
			} else {
				if (cnt >= v) {
					return true;
				}
				cnt = 0;
			}
		}
		if (cnt >= v) {
			return true;
		}
		return false;
	}
}
