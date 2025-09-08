


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] sum = new long[10];
		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			char[] data = br.readLine().toCharArray();
			long temp = 1;
			for (int j = data.length - 1; j >= 0; j--) {
				int idx = data[j]-'A';
				if (sum[idx] == 0) {
					cnt++;
				}
				sum[idx] += temp;
				temp*=10;
			}
			set.add(data[0] - 'A');
		}

		// System.out.println(Arrays.toString(sum));
		boolean[] visited = new boolean[10];
		long min = Long.MAX_VALUE;
		int idx = 0;

		if (cnt == 10) {

			for (int i = 0; i < 10; i++) {
				if(set.contains(i)) continue;
				if (sum[i] < min) {
					min = sum[i];
					idx = i;
				}
			}
			visited[idx] = true;
		}
		long result = 0;
		for (int i = 9; i > 0; i--) {
			long max = Long.MIN_VALUE;
			for (int j = 0; j < 10; j++) {
				if(visited[j]) continue;
				if (sum[j] > max) {
					max = sum[j];
					idx = j;
				}
			}
			if (!visited[idx]) {
				visited[idx] =true;
				result += (max * i);
			}
		}
		System.out.println(result);

	}
}
