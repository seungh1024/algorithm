

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		find(0, N, "");
	}

	public static boolean find(int idx, int N, String s) {
		// System.out.println("idx = "+idx +", s = "+s);
		if (idx == N) {
			System.out.println(s);
			return true;
		}

		for (int i = 1; i <= 3; i++) {
			// System.out.println("s = "+s +", i = "+i);
			if (check(s + i)) {
				if (find(idx + 1, N, s + i)) {
					return true;
				}
			}
			// System.out.println("after s =" + s +", i = "+i);
		}


		return false;
	}

	private static boolean check(String s) {
		// System.out.println("s = "+s);
		int length = s.length();
		int range = length / 2;

		for (int i = 1; i <= range; i++) {
			String s1 = s.substring(length - i);
			String s2 = s.substring(length - i * 2, length - i);
			if (s1.equals(s2)) {
				// System.out.println("false s = "+s);
				return false;
			}
		}

		// System.out.println("return true");

		return true;
	}
}
