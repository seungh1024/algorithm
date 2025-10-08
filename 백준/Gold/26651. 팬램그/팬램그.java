

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println("A");
			return;
		}

		long a = 0;
		while (a * a <= N) {
			a++;
		}
		a--;
		long b = a;
		while (a * b <= N) {
			b++;
		}
		b--;

		String format = "BCDEFGHIJKLMNOPQRSTUVWXY";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a; i++) {
			sb.append("A");
		}
		sb.append(format);
		for (int i = 0; i < b; i++) {
			sb.append("Z");
		}
		long c = N - (a * b);
		if (c > 0) {

			for (int i = 0; i < c; i++) {
				sb.append("A");
			}
			sb.append(format).append("Z");
		}

		System.out.println(sb);
	}
}
