import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] crane;
	public static int M;
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
		binarySearch();
	}

	public static void binarySearch() {
		long start = 0;
		long end = Integer.MAX_VALUE-1;

		while (start < end) {
			long mid = (start+end)/2;
			// System.out.println(mid);

			boolean result = makeResult(mid);

			// System.out.println(result);

			if (result) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (makeResult(start)) {
			System.out.println(start);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean makeResult(long num) {
		int craneIdx = N-1;
		int boxIdx = M-1;

		// System.out.println("======= num = "+num);
		while (craneIdx >= 0 && boxIdx >= 0) {
			// System.out.println("craneIdx = "+craneIdx + ", boxIdx = "+boxIdx);
			// System.out.println("crane = "+crane[craneIdx] + ", box = "+box[boxIdx]);
			if (crane[craneIdx] < box[boxIdx]) {
				return false;
			}
			craneIdx--;
			boxIdx-=num;
		}

		if (boxIdx >= 0 && craneIdx < 0) {
			return false;
		}

		return true;
	}
}