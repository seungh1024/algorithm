import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] data = new long[N];

		long sum = 0;
		for (int i = 0; i < N; i++) {
			data[i] = Long.parseLong(br.readLine());
			sum += data[i];
		}

		int left = 0;
		int right = 0;

		long now = 0;
		long max = 0;
		for (; left < N; left++) {
			while (now <= sum) {
				now += data[right];
				sum -= data[right];
				right = (right + 1) % N;

				long min = Math.min(now, sum);
				max = Math.max(max, min);
				// System.out.println("left = " + left + ", right = " + right + ", max = " + max +", min = "+min);

				if (now > sum) {
					break;
				}


			}
			sum += data[left];
			now -= data[left];
			long min = Math.min(now, sum);
			max = Math.max(max, min);

			// System.out.println("=======");

		}

		System.out.println(max);
	}
}
