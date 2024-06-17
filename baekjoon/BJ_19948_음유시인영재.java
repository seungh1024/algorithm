package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_19948_음유시인영재 {
	public static int[] count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int spaceBar = Integer.parseInt(br.readLine());
		count = new int[26];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 26; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == ' ') {
				if(i >0 && input.charAt(i-1) == ' ') continue;
				if (spaceBar-- <= 0) {
					sb = new StringBuilder("-1");
					break;
				}
				continue;
			}

			if (i > 0) {
				char last = input.charAt(i-1);
				if (c != last) { // 다를 때만 카운트 진행
					if (!isValid(c)) {
						sb = new StringBuilder("-1");
						break;
					}
				}
				if(last == ' '){
					int target = Character.toUpperCase(c) - 'A';

					if (count[target] <= 0) {
						sb = new StringBuilder("-1");
						break;
					} else {
						count[target] --;
						sb.append(Character.toUpperCase(c));
					}
				}
			} else {
				if (!isValid(c)) {
					sb = new StringBuilder("-1");
					break;
				}
				int target = Character.toUpperCase(c) -'A';
				if (count[target] <= 0) {
					sb = new StringBuilder("-1");
					break;
				} else {
					count[target] --;
					sb.append(Character.toUpperCase(c));
				}
			}
		}

		System.out.println(sb);


	}

	public static boolean isValid(char c) {
		int targetIndex = Character.toUpperCase(c)-'A';
		if (count[targetIndex] > 0) {
			count[targetIndex]--;
			return true;
		} else {
			return false;
		}
	}
}
