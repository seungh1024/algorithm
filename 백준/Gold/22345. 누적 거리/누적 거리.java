

import java.io.*;
import java.util.*;

public class Main {
	public static int N, Q;
	public static List<Data> list;
	public static long[] sum,rsum;
	public static long[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			list.add(new Data(a, x));
		}
		list.add(new Data(0, Integer.MIN_VALUE));

		Collections.sort(list, Comparator.comparingInt(o -> o.x));
		list.get(0).x = list.get(1).x;
		sum = new long[N + 1];
		count = new long[N + 1];
		long cnt = list.get(1).a;
		count[1] = cnt;
		for (int i = 2; i <= N; i++) {
			long dis = list.get(i).x-list.get(i-1).x;
			sum[i] += sum[i-1]+dis*cnt;
			cnt += list.get(i).a;
			count[i] = cnt;
		}
		// System.out.println(Arrays.toString(sum));
		// System.out.println(Arrays.toString(count));

		rsum = new long[N + 2];
		long rcnt = list.get(N).a;
		for (int i = N-1; i > 0; i--) {
			long dis = list.get(i+1).x-list.get(i).x;
			rsum[i] += rsum[i+1]+dis*rcnt;
			rcnt+=list.get(i).a;
		}
		// System.out.println("rsum = "+Arrays.toString(rsum));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			long result = find(q);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static long find(long q) {
		// System.out.println("q = "+ q + " ======== ======== ======== ========");
		long result = 0;

		int start = 1;
		int end = N;

		while (start < end) {
			int mid = (start+end)/2;
			long now = list.get(mid).x;

			if (now >=q) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		// System.out.println("start  = "+start);
		int l = start;
		int r = start;
		if (list.get(l).x > q) {
			l--;
		}

		result += sum[l] - sum[0];
		result += (q-list.get(l).x)*(count[l]);

		// System.out.println("l  = "+l + ", result = "+result);
		// System.out.println(list.get(l));

		result += rsum[r]-rsum[N+1];
		result += (list.get(r).x-q)*(count[N]-count[l]);

		// System.out.println("r = " + r + ", result = " + result);
		// System.out.println(list.get(r));

		return result;
	}

	public static class Data{
		int a;
		int x;

		@Override
		public String toString() {
			return "Data{" +
				"a=" + a +
				", x=" + x +
				'}';
		}

		public Data(int a, int x) {
			this.a = a;
			this.x = x;
		}
	}
}
