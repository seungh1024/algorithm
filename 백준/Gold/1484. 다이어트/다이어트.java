import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());

		long left = 1;
		long right = 2;

		List<Long> list = new ArrayList<>();
		while (left < right) {
			// System.out.println("left = "+left+ ", right = "+right);
			long r = right*right;
			long l = left*left;
			long v = r-l;
			if (v == G) {
				list.add(right);
			}
			if (v > G) {
				left++;
			} else {
				right++;
			}

			// if (r - l > 100_000) {
			// 	// break;
			// }
		}
		if (list.size() == 0) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			for (long i : list) {
				sb.append(i).append("\n");
			}
			System.out.println(sb);
		}

	}
}