

import java.io.*;
import java.util.*;

public class Main {
	public static int N,K,P, X;
	public static int[] data;
	public static Map<Integer, Integer>[] map = new Map[] {
		Map.of(1, 4, 2, 3, 3, 3, 4, 4, 5, 3, 6, 2, 7, 3, 8, 1, 9, 2),
		Map.of(0, 4, 2, 5, 3, 3, 4, 2, 5, 5, 6, 6, 7, 1, 8, 5, 9, 4),
		Map.of(0, 3, 1, 5, 3, 2, 4, 5, 5, 4, 6, 3, 7, 4, 8, 2, 9, 3),
		Map.of(0, 3, 1, 3, 2, 2, 4, 3, 5, 2, 6, 3, 7, 2, 8, 2, 9, 1),
		Map.of(0, 4, 1, 2, 2, 5, 3, 3, 5, 3, 6, 4, 7, 3, 8, 3, 9, 2),
		Map.of(0, 3, 1, 5, 2, 4, 3, 2, 4, 3, 6, 1, 7, 4, 8, 2, 9, 1),
		Map.of(0, 2, 1, 6, 2, 3, 3, 3, 4, 4, 5, 1, 7, 5, 8, 1, 9, 2),
		Map.of(0, 3, 1, 1, 2, 4, 3, 2, 4, 3, 5, 4, 6, 5, 8, 4, 9, 3),
		Map.of(0, 1, 1, 5, 2, 2, 3, 2, 4, 3, 5, 2, 6, 1, 7, 4, 9, 1),
		Map.of(0, 2, 1, 4, 2, 3, 3, 1, 4, 2, 5, 1, 6, 2, 7, 3, 8, 1),
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		data = new int[K];
		int x = X;
		for (int i = 0; i < K; i++) {
			data[i] = x%10;
			x/=10;
		}

		int result = 0;
		for (int i = X + 1; i <= N; i++) {
			result += getValue(i);
		}
		for (int i = 1; i < X; i++) {
			result += getValue(i);
		}
		System.out.println(result);
	}

	public static int getValue(int i) {
		int result = 0;
		int[] temp = new int[K];
		int v = i;
		for (int j = 0; j < K; j++) {
			temp[j] = v%10;
			v/=10;
		}
		int p = 0;
		for (int j = 0; j < K; j++) {
			int from = data[j];
			int to = temp[j];
			Integer value = map[from].get(to);
			if (value != null) {
				p+=value;
			}
		}
		if (p > 0 && p <= P) {
			result++;
		}

		return result;
	}
}
