

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
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			double max = Integer.MIN_VALUE;
			for (int j = i + 1; j < N; j++) {
				double v = ((double)data[j] - data[i]) / ((double)(j - i));
				if (v > max) {
					max = v;
					cnt++;
				}
			}
			max = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				double v = ((double)data[i] - data[j]) / ((double)(i-j));
				if (v < max) {
					max = v;
					cnt++;
				}
			}
			count[i] = cnt;
			result = Math.max(result,cnt);
		}
		System.out.println(result);
	}
}
