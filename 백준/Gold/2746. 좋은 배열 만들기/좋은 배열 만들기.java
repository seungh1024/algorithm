

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sum += data[i];
		}
		Arrays.sort(data);
		// System.out.println(Arrays.toString(data));
		long result = 0;
		// i를 선택하고 다른 수를 선택 후 제거하여 data[N-1]을 만들 수 있는 방법 탐색
		for (int i = 0; i < N - 1; i++) {
			int start = i;
			int end = N-1;
			if (start < end) {

				result+=find(start+1,end,sum-data[start]-data[N-1], data[N-1]);
			}
		}

		if (sum - data[N - 1] - data[N - 2] - data[N - 3] == data[N - 3]) {
			result++;
		}
		for (int i = N - 3; i >= 0; i--) {
			if (sum - data[N - 1] - data[i]-data[N-2] == data[N - 2]) {
				result++;
			}
		}

		System.out.println(result);

	}

	public static int find(int start, int end, long sum, int target) {
		int l = start;
		int r = end;
		while (l < r) {
			int mid = (l + r) / 2;

			if (sum - data[mid] <= target) {
				r = mid;
			} else {
				l = mid+1;
			}
		}
		int left = l;

		l = start;
		r = end;
		while (l < r) {
			int mid = (l + r) / 2;

			if (sum - data[mid] < target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		int right = l;

		// System.out.println("start = "+start +", end = "+end + ", left = "+left + ", right = "+right + ", target = "+target + ", sum = "+sum);
		return right-left;
	}
}
