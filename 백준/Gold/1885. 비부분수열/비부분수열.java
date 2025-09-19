

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
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

		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			set.add(data[i]);
			if (set.size() == K) {
				cnt++;
				set = new HashSet<>();
			}
		}
		System.out.println(cnt+1);
	}
}
