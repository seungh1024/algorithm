import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static long[] data;
	public static long mem;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new long[N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (char c : input) {
				data[i] |= 1 << (c - 'a');
			}
		}

		mem = 0L;
		char a = 'a';
		for (int i = 0; i < 26; i++) {
			mem |= 1 << (a - 'a');
			a = (char)(a + 1);
		}
		// System.out.println(mem);

		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			if (cmd == 1) {
				mem ^= 1 << (c - 'a');
			} else {
				mem |= 1 << (c - 'a');
			}

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				if (data[i] == (mem & data[i])) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}