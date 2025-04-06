

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static long K;
	public static long[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		data = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data);

		long min = Long.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			long left = data[0] * i;
			long right = data[i] * (N - i);
			min = Math.min(min, (K+left+right-1) / (left + right));
			// System.out.println("min = "+min + ", left = "+left + ", right = "+right);
		}
		System.out.println(min);
	}

}
