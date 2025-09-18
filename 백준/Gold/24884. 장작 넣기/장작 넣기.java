

import java.io.*;
import java.util.*;

public class Main {
	public static int N,W,T, K;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int result = find(W+1, 1, 0);
		System.out.println(result);
	}

	public static int find(int idx, int time, int save) {
		int[] count = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if(i == save) continue;
			int cnt = 3;
			if (data[i - 1] > 0) {
				cnt--;
			}
			if (data[i + 1] > 0) {
				cnt--;
			}
			count[i] = cnt;
		}

		int k = changeData(count, -1);

		if (k < K) {
			changeData(count, 1);
			return 0;
		}


		if (time == T) {
			changeData(count, 1);
			return 1;
		}

		int sum = 0;
		sum += find(idx, time + 1, idx);
		if (idx - 1 > 0) {
			sum += find(idx - 1, time + 1, idx - 1);
		}
		if (idx + 1 <= N) {
			sum += find(idx + 1, time + 1, idx + 1);
		}

		changeData(count, 1);

		return sum;
	}

	public static int changeData(int[] count, int m) {
		int k = 0;
		for (int i = 1; i <= N; i++) {
			data[i] += (count[i]*m);
			if (data[i] > 0) {
				k++;
			}
		}

		return k;
	}
}
