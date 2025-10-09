

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] data = new int[N];
		double sum = 0;
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sum += data[i];
		}
		Arrays.sort(data);

		double result = sum / (double)N;
		if (N - 2 >= 0) {
			result = Math.max(result, data[N - 2]);
		}
		System.out.println(result);
	}
}
