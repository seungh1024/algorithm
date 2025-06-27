

import java.io.*;
import java.util.Arrays;

public class Main {
	public static int N;
	public static String[] data;
	public static String[] reverse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new String[N];
			reverse = new String[N];
			for (int i = 0; i < N; i++) {
				data[i] = br.readLine();
				char[] input = data[i].toCharArray();
				StringBuilder sb = new StringBuilder();
				for (int j = input.length - 1; j >= 0; j--) {
					sb.append(input[j]);
				}
				reverse[i] = sb.toString();
			}

			// System.out.println("t = "+t);
			if (!find(0,0, ""+0)) {
				find(0,1, ""+1);
			}
		}

		// System.out.println("XC".compareTo("DZ"));


	}

	public static boolean find(int idx, int check, String s) {
		// System.out.println("check = "+check +", idx = "+idx + ", s = "+s);
		if (idx == N-1) {
			System.out.println(s);
			return true;
		}

		if (check == 0) { // 정방향
			if (data[idx].compareTo(data[idx + 1]) < 0) {
				// System.out.println(data[idx] +", " + data[idx+1]);
				if (find(idx + 1, 0, s + 0)) {
					return true;
				}
			} 
			if (data[idx].compareTo(reverse[idx + 1]) < 0) {
				if (find(idx + 1, 1, s + 1)) {
					return true;
				}
			}

		} else {
			if (reverse[idx].compareTo(data[idx + 1]) < 0) {
				if (find(idx + 1, 0, s + 0)) {
					return true;
				}
			} 
			if (reverse[idx].compareTo(reverse[idx + 1]) < 0) {
				if (find(idx + 1, 1, s + 1)) {
					return true;
				}
			}

		}

		return false;
	}
}
