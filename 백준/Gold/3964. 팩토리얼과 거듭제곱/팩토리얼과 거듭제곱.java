

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<Integer> list = new ArrayList<>();
		boolean[] check = new boolean[1000001];
		for (int i = 2; i <= 1000000; i++) {
			if(check[i]) continue;
			for (int j = i + i; j <= 1000000; j += i) {
				check[j] = true;
			}
		}
		for (int i = 2; i <= 1000000; i++) {
			if (!check[i]) {
				list.add(i);
			}
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());

			Map<Long, Long> map = new HashMap<>();
			for (int i : list) {
				long cnt = 0;
				while (k % i == 0) {
					cnt++;
					k/=i;
				}
				if (cnt > 0) {
					map.put((long)i, cnt);
				}
			}
			if (k > 1) {
				map.put(k, 1L);
			}
			// System.out.println(map);

			long min = Long.MAX_VALUE;
			for (Map.Entry<Long, Long> entry : map.entrySet()) {
				long temp = n;
				long key = entry.getKey();
				long value = entry.getValue();
				long cnt = 0;
				while (temp >= key) {
					cnt += temp/key;
					temp /= key;
				}

				min = Math.min(min, cnt/value);
			}

			sb.append(min).append("\n");

		}
		System.out.println(sb);
	}
}
