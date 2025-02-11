import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] crane;
	public static int[] box;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		crane = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		box = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(crane);
		Arrays.sort(box);

		// System.out.println(Arrays.toString(crane));
		// System.out.println(Arrays.toString(box));
		int[] count = new int[N];
		int last = 0;
		for (int i = 0; i < N; i++) {
			int idx = find(last, crane[i]);
			count[i] = idx - last;
			last = idx;
		}
		// System.out.println(Arrays.toString(count));

		for (int i = N - 2; i >= 0; i--) {

			while (true) {
				int min = Integer.MAX_VALUE;
				int idx = 0;
				for (int j = i + 1; j < N; j++) {
					if (count[j] < min) {
						min = count[j];
						idx = j;
					}
				}
				if(count[i] - min <= 1) break;

				count[idx]++;
				count[i]--;
			}
		}

		// System.out.println(Arrays.toString(count));
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, count[i]);
			cnt += count[i];
		}
		if (cnt != M) {
			max = -1;
		}
		System.out.println(max);
	}

	public static int find(int start, int target) {

		int end = M;
		while (start < end) {
			int mid = (start + end) / 2;

			if (box[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}