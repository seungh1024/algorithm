

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String s = "111";

		find(0,"");
	}

	public static boolean find(int idx, String s) {
		if (idx == N) {
			System.out.println(s);
			return true;
		}

		// System.out.println("idx = " + idx + ", s = " + s);
		for (int i = 1; i <= 3; i++) {
			String next = s + i;
			int length = next.length();
			int range = length/2;
			boolean flag = false;
			// System.out.println("range = "+range);
			for (int j = 1; j <= range; j++) {
				String sub = next.substring(length - j);
				// System.out.println("sub = "+sub + ", startswith = "+next.startsWith(sub,length-sub.length()));
				if (!sub.isEmpty() && next.startsWith(sub, length - sub.length()*2)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				if (find(idx + 1, next)) {
					return true;
				}
			}
		}

		return false;
	}
}
