import java.io.*;
import java.util.*;

public class Main {
	public static int N, d, k, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int[] data = new int[N + 1];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		int[] count = new int[d + 1];

		int left = 0;
		int right = k;
		int cnt = 0;
		int max = 0;

		for (int i = 0; i < k; i++) {
			if (count[data[i]] == 0) {
				cnt++;
			}
			count[data[i]] ++;
		}

		if (count[c] == 0) {
			max = Math.max(max, cnt + 1);
		} else if (count[c] > 0) {
			max = Math.max(max, cnt - 1);
		}

		for (; left < N; left++, right++) {
			int next = data[right % N];
			int last = data[left];
			if (count[next] == 0) {
				cnt++;
			}
			count[next] ++;
			count[last] --;
			if (count[last] == 0) {
				cnt--;
			}
			if (count[c] == 0) {
				max = Math.max(max, cnt + 1);
			} else {
				max = Math.max(max, cnt);
			}

			// System.out.println("left = "+left +", right = "+right +", cnt = "+cnt +", max = "+max);
			// System.out.println(Arrays.toString(count));
		}


		System.out.println(max);
	}
}