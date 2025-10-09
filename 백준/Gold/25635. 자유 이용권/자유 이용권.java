

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long sum = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			long num = Integer.parseInt(st.nextToken());
			sum += num;
			max = Math.max(max, num);
		}

		long v= 0;
		if (sum % 2 == 0) {
			v = sum / 2;
		} else {
			v = sum / 2 + 1;
		}

		if (v < max) {
			System.out.println((sum - max) * 2 + 1);
		} else {
			System.out.println(sum);
		}
	}
}
