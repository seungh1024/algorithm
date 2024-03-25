package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_2217_로프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(data);

		int temp = 0;
		for (int i = N - 1; i >= 0; i--) {
			temp = Math.max(temp,(N-i)*data[i]);

		}
		System.out.println(temp);
	}
}
