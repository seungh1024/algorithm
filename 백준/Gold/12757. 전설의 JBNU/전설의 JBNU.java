import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static TreeMap<Integer,Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map.put(key, value);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());

			int realKey = -1;
			Integer ceilingKey = map.ceilingKey(key);
			int gap = Integer.MAX_VALUE;
			if (ceilingKey != null) {
				gap = Math.abs(key - ceilingKey);
				if (gap <= K) {
					realKey = ceilingKey;
				}
			}

			Integer lowerKey = map.lowerKey(key);
			if (lowerKey != null) {
				int otherGap = Math.abs(key - lowerKey);
				if (otherGap <= K && otherGap < gap) {
					realKey = lowerKey;
				} else if (otherGap == gap && otherGap <= K) {
					realKey = -2;
				}
			}

			// System.out.println("command = " + command + ", key = "+key +", realKey = "+realKey);

			if (command == 1) {
				int value = Integer.parseInt(st.nextToken());
				map.put(key, value);
			} else if (command == 2) {
				int value = Integer.parseInt(st.nextToken());
				if (realKey >= 0) {
					map.put(realKey, value);
				}
			} else if (command == 3) {
				if (realKey == -2) {
					sb.append("?");
				} else if (realKey == -1) {
					sb.append(realKey);
				} else {
					sb.append(map.get(realKey));
				}
				sb.append("\n");
			}

			// System.out.println(map);
		}
		System.out.println(sb);
	}

}