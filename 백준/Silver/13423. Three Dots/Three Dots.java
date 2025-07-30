

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] data = new int[N];
			Set<Integer> set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
				set.add(data[i]);
			}
			Arrays.sort(data);

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int jump = data[j] - data[i];
					if (set.contains(data[j] + jump)) {
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
