package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_6209_제자리멀리뛰기 {
	public static int D, N, M;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+2];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		data[N+1] = D;
		Arrays.sort(data);

		find();
	}

	public static void find() {
		int start = 0;
		int end = D;

		int result = 0;
		while (start < end) {
			int mid = (start + end) / 2;
			// System.out.println("mid = "+mid);
			if (!check(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		// System.out.println(Arrays.toString(data));
		if (check(start)) {
			System.out.println(start);
		} else {
			System.out.println(start-1);
		}
	}

	public static boolean check(int jump) {
		int cnt = 0;
		int now = 0;
		for (int i = 1; i <= N + 1; i++) {
			if (data[i] - data[now] < jump) {
				cnt++;
			} else {
				now = i;
			}
		}

		if (cnt > M) {
			return false;
		}

		return true;
	}
}
