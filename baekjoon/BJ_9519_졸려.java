package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_9519_졸려 {
	public static int N;
	public static char[] data;
	public static Map<Integer,char[]> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = br.readLine().toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < data.length; i++) {
			deque.offer(data[i]);
		}
		map = new HashMap<>();
		map.put(0,data);

		find(0, deque);

		// System.out.println(map.size());
		// for (Map.Entry<Integer, char[]> entry : map.entrySet()) {
		// 	System.out.println(Arrays.toString(entry.getValue()));
		// }

		int idx = (map.size()  - (N % map.size()))%map.size();
		// System.out.println(idx);
		char[] value = map.get(idx);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < value.length; i++) {
			sb.append(value[i]);
		}
		System.out.println(sb);
	}

	public static void find(int cnt, Deque<Character> deque) {
		// if (cnt == 10) {
		// 	return;
		// }
		char[] temp = new char[data.length];
		int idx = 0;
		while (!deque.isEmpty()) {
			temp[idx++] = deque.pollFirst();
			if (!deque.isEmpty()) {
				temp[idx++] = deque.pollLast();
			}
		}
		cnt++;
		if (Arrays.equals(data, temp)) {
			return;
		}
		map.put(cnt,temp);
		for (int i = 0; i < data.length; i++) {
			deque.offer(temp[i]);
		}
		find(cnt,deque);
	}
}
