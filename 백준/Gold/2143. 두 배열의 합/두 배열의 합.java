import java.io.*;
import java.util.*;

public class Main {
	public static int T,N, M;
	public static long[] A, B;
	public static List<Long> list1, list2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		A = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			A[i] = Long.parseLong(st.nextToken()) + A[i - 1];
		}
		M = Integer.parseInt(br.readLine());
		B = new long[M+1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= M; i++) {
			B[i] = Long.parseLong(st.nextToken()) + B[i - 1];
		}
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		makeList(list1, A, N);
		makeList(list2, B, M);
		// System.out.println(list1);
		// System.out.println(list2);

		long sum = 0;
		for (long num : list1) {
			sum += getLength(T-num,list2);
		}
		System.out.println(sum);
	}

	public static long getLength(long target, List<Long> list) {
		int start = 0;
		int end = list.size();

		int right = 0;
		while (start < end) {
			int mid = (start+end)/2;

			long v = list.get(mid);
			if (v > target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		right = start;

		start = 0;
		end = list.size();
		int left = 0;
		while (start < end) {
			int mid = (start+end)/2;

			long v = list.get(mid);
			if (v >= target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		left = start;

		// System.out.println("target = "+target +", right = "+right +", left = "+left);

		if (left >= list.size() || list.get(left) != target) {
			// return 0;
		}

		return right-left;
	}

	public static void makeList(List<Long> list, long[] arr, int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				list.add(arr[j] - arr[i]);
			}
		}
		Collections.sort(list);
	}
}