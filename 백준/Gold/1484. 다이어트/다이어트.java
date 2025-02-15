import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());

		long left = 1;
		long right = 1;

		StringBuilder sb = new StringBuilder();
		do {
			long rr = right * right;
			long ll = left * left;
			if (rr - ll == G) {
				sb.append(right).append("\n");
				right++;
			} else if (rr - ll < G) {
				right++;
			} else {
				left++;
			}
			// System.out.println("left = "+left + ", right = "+right);

		} while (left < right);

		if (sb.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}
}