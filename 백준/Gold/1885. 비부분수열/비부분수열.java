

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		int[] count = new int[K + 1];

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
			count[data[i]]++;
		}

		// System.out.println(Arrays.toString(count));

		Set<Integer> set = new HashSet<>();
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (!set.contains(data[i])) {
				set.add(data[i]);
			}
			if (set.size() == K) {
				set = new HashSet<>();
				result++;
			}
		}



		System.out.println(result+1);
	}
}
