package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_13908_비밀번호 {
	public static int N, M;
	public static int[] data;
	public static int[] target;
	public static int result = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if (M == 0) {
			int num = 1;
			for (int i = 0; i < N; i++) {
				num *= 10;
			}
			System.out.println(num);
			return;
		}

		data = new int[N];
		target = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}


		find(0);
		System.out.println(result);
	}

	public static void find(int idx) {
		if (idx == N) {
			// System.out.println(Arrays.toString(data));
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (target[i] == data[j]) {
						cnt++;
						break;
					}
				}
			}
			if (cnt == M) {
				result++;
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			data[idx] = i;
			find(idx+1);
		}
	}
}
