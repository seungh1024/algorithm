import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;


		int max = 0;
		int cnt = 0;
		int limit = 0;
		for (int i = 0; i < N; i++) {
			if (data[i] % 2 == 0) {
				cnt++;
			} else {
				limit++;
			}

			if (limit > K) {
				while (limit > K) {
					if (data[left] % 2 == 0) {
						cnt--;
					} else {
						limit--;
					}
					left++;
				}
			}
			max = Math.max(max, cnt);

		}

		System.out.println(max);
	}
}