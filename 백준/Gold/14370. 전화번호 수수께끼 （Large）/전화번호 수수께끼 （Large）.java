

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			char[] input = br.readLine().toCharArray();
			int[] count = new int[26];
			char A = 'A';
			int cnt = 0;
			for (char c : input) {
				count[c-A]++;
				cnt++;
			}
			// System.out.println(Arrays.toString(count));

			int[] result = new int[10];
			while (cnt > 0) {
				if (count['Z'-A] > 0) {
					result[0]++;
					cnt-=4;
					count['Z'-A]--;
					count['E'-A]--;
					count['R'-A]--;
					count['O'-A]--;
				}else if (count['W' - A] > 0) {
					result[2]++;
					cnt-=3;
					count['T'-A]--;
					count['W'-A]--;
					count['O'-A]--;
				} else if (count['U' - A] > 0) {
					result[4]++;
					cnt-=4;
					count['F'-A]--;
					count['O'-A]--;
					count['U'-A]--;
					count['R'-A]--;
				}else if (count['X' - A] > 0) {
					result[6]++;
					cnt-=3;
					count['S'-A]--;
					count['I'-A]--;
					count['X'-A]--;
				} else if (count['G' - A] > 0) {
					result[8]++;
					cnt-=5;
					count['E' - A]--;
					count['I' - A]--;
					count['G' - A]--;
					count['H' - A]--;
					count['T' - A]--;
				} else if (count['F' - A] > 0 && count['V' - A] > 0) {
					result[5]++;
					cnt-=4;
					count['F' - A]--;
					count['I' - A]--;
					count['V' - A]--;
					count['E' - A]--;
				}else if (count['I' - A] > 0 && count['N' - A] > 1) {
					result[9]++;
					cnt-=4;
					count['N' - A]--;
					count['I' - A]--;
					count['N' - A]--;
					count['E' - A]--;
				}else if (count['V' - A] > 0 && count['S' - A] > 0) {
					result[7]++;
					cnt-=5;
					count['S' - A]--;
					count['E' - A]--;
					count['V' - A]--;
					count['E' - A]--;
					count['N' - A]--;
				} else if (count['O' - A] > 0 && count['N' - A] > 0) {
					result[1]++;
					cnt -= 3;
					count['O' - A]--;
					count['N' - A]--;
					count['E' - A]--;
				} else {
					result[3]+=count['T'-A];
					break;
				}

			}

			// System.out.println(Arrays.toString(result));
			sb.append("Case #").append(t).append(": ");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < result[i]; j++) {
					sb.append(i);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
