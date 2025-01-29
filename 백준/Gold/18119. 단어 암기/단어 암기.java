import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static long[] data;

	public static long memory;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N];

		for (int i = 0; i < 28; i++) {
			memory |= 1<<i;
		}

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < input.length; j++) {
				int idx = (int)(input[j] - 'a');
				data[i] |= 1<<idx;
			}
		}


		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int idx = st.nextToken().toCharArray()[0] - 'a';

			if (num == 1) {
				memory ^= 1<<idx;
			} else {
				memory |= 1<<idx;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				long value = memory & data[i];
				if (value == data[i]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");

		}

		System.out.println(sb);

	}
}