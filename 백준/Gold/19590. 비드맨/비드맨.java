

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			long v = Long.parseLong(br.readLine());
			max = Math.max(max, v);
			sum += v;
		}

		if (max >= sum - max) {
			System.out.println(max-(sum-max));
		}else{
			if (sum % 2 == 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
	}
}
