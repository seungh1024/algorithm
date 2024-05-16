package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_21314_민겸수 {
	public static Queue<Character> q;
	public static Queue<Character> q2;
	public static char[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine().toCharArray();

		int length = data.length;
		q = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
		StringBuilder big = new StringBuilder();
		StringBuilder small = new StringBuilder();
		for (int i = 0; i < length; i++) {
			q.offer(data[i]);
			if(data[i] == 'K'){
				String result = changeNumber(q,true);
				big.append(result);
			}

			if (!q2.isEmpty()) {
				if (q2.peek() == 'M' && data[i] == 'M') {
					q2.offer(data[i]);
				} else {
					small.append(changeNumber(q2,false));
					q2.offer(data[i]);
				}
			} else {
				q2.offer(data[i]);
			}
		}
		if (!q.isEmpty()) {
			big.append(changeNumber(q,true));
		}
		if (!q2.isEmpty()) {
			small.append(changeNumber(q2,false));
		}
		System.out.println(big);
		System.out.println(small);
	}

	public static String changeNumber(Queue<Character> queue, boolean flag) {
		int size = queue.size();

		StringBuilder sb = new StringBuilder();
		StringBuilder bigSb = new StringBuilder();
		for (int i = 1; i < size; i++) {
			char now = queue.poll();
			sb.append(0);
			bigSb.append(1);
		}
		char last = queue.poll();
		if (last == 'K') {
			return 5 + sb.toString();
		} else {
			if (flag) {
				return 1 + bigSb.toString();
			}
			return 1 + sb.toString();
		}
	}
}
