

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		data[0] = Integer.MIN_VALUE;
		data[N+1] = Integer.MAX_VALUE;
		List<Integer> indexes = new ArrayList<>();
		// int last = data[0];
		for (int i = 1; i <= N; i++) {
			if (data[i-1] > data[i]) {
				// System.out.println("last = "+last + ", data[i] = "+data[i] + ", i ="+i);
				indexes.add(i);
			} 
		}

		// System.out.println(indexes);
		if (indexes.size() >= 2) {
			System.out.println(0);
		} else if (indexes.size() == 1) {
			int idx = indexes.get(0);
			int result = 0;
			if (data[idx - 1] <= data[idx + 1]) {
				result++;
			}
			if (data[idx - 2] <= data[idx]) {
				result++;
			}

			System.out.println(result);
		} else {
			System.out.println(N);
		}
	}

}
