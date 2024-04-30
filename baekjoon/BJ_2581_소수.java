package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_2581_소수 {
	public static int M,N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		boolean[] data = new boolean[10001];
		data[1] = true;

		for (int i = 2; i <= 10000; i++) {
			if(data[i]) continue;
			for (int j = i*2; j <= 10000; j += i) {
				if (j % i == 0) {
					data[j] = true;
				}
			}
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = N; i >= M; i--) {
			if (!data[i]) {
				sum+=i;
				min = i;
			}
		}

		if (sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}
}
