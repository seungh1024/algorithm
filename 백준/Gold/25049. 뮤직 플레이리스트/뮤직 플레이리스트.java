

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N + 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		long[] ldp = new long[N + 2];
		long[] maxLdp = new long[N + 2];
		maxLdp[0] = Long.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			ldp[i] = Math.max(data[i], ldp[i - 1] + data[i]);
			maxLdp[i] = Math.max(maxLdp[i - 1], ldp[i]);
		}

		long[] rdp = new long[N + 2];
		long[] maxRdp = new long[N + 2];
		maxRdp[N + 1] = Long.MIN_VALUE;
		for (int i = N; i > 0; i--) {
			rdp[i] = Math.max(data[i], rdp[i + 1] + data[i]);
			maxRdp[i] = Math.max(maxRdp[i + 1], rdp[i]);
		}

		long max = Math.max(0, maxLdp[N]);
		long result = data[N];
		for (int i = 1; i < N; i++) {
			max = Math.max(maxLdp[i] + maxRdp[i + 1], max);
			result += data[i];
		}

		result += max;
		System.out.println(result);
	}
}

