

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int[] count = new int[N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (b != -1) {
				count[b]++;
				list[a].add(new Data(b, false));
			}
			if (c != -1) {
				count[c]++;
				list[a].add(new Data(c, true));
			}
		}
		int start = 0;
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				start = i;
				break;
			}
		}

		int result = find(start, true)-1;
		System.out.println(result);
	}

	public static int find(int idx, boolean lr) {

		int sum = 0;
		// System.out.println("idx = "+idx + ", lr = "+lr);
		if (list[idx].size() > 0) {
			for (Data next : list[idx]) {
				if (!next.lr) { // left
					sum += find(next.idx, false);
				} else { // right
					sum += find(next.idx, lr & true);
				}
			}

			if (lr) {
				sum += 1;
			} else {
				sum += 2;
			}
			// System.out.println("return idx = "+idx + ", sum = "+sum);

			return sum;
		} else {
			if (lr) {
				// System.out.println("right end idx = " + idx);
				return 1;
			} else {
				// System.out.println("left end idx = "+idx);
				return 2;
			}
		}
	}

	public static class Data{
		int idx;
		boolean lr;

		public Data(int idx, boolean lr) {
			this.idx = idx;
			this.lr = lr;
		}
	}
}
