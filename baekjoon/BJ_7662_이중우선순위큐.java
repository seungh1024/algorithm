package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_7662_이중우선순위큐 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			TreeSet<Integer> set = new TreeSet<>();
			Map<Integer, Integer> map = new HashMap<>();
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (command.equals("I")) {
					Integer value = map.get(num);
					if (value == null) {
						map.put(num, 1);
					} else {
						map.put(num, value + 1);
					}
					set.add(num);
				} else {
					if(set.isEmpty()) continue;

					if (num == 1) { // 최대값 빼기
						Integer last = set.last();
						Integer value = map.get(last);
						if (value == 1) {
							set.remove(last);
							map.remove(last);
						} else {
							map.put(last, value - 1);
						}
					} else {
						Integer first = set.first();
						Integer value = map.get(first);
						if (value == 1) {
							set.remove(first);
							map.remove(first);
						} else {
							map.put(first, value - 1);
						}
					}
				}
			}

			if (set.isEmpty()) {
				sb.append("EMPTY");
			} else {
				int min = set.first();
				int max = set.last();
				sb.append(max).append(" ").append(min);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
