import java.io.*;
import java.util.*;

public class Main {
	public static long N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());

		binarySearch();

	}

	public static void binarySearch() {
		long start = 0;
		long end = N;

		while (start < end) {
			long mid = (start + end) / 2;

			long value = (mid+1)*(N-mid+1);

			if (value >= K) {

				end = mid;
			} else {
				start = mid + 1;
			}
		}

		if ((start + 1) * (N - start + 1) == K) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}