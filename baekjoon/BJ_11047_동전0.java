package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_11047_동전0 {
	public static int N,K;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if(data[i] > K) continue;
			int a = K/data[i];
			K %= data[i];
			count += a;
		}
		System.out.println(count);
	}


}
