

import java.io.*;
import java.util.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		if (N % 2 == 0) {
			System.out.println("NOT POSSIBLE");
			return;
		}
		int size = input.length/2;
		int resultCnt = 0;
		String result = null;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			int cnt = 0;
			int idx = 0;
			while (cnt < size) {
				if (idx != i) {
					cnt++;
					sb1.append(input[idx]);
				}
				idx++;
			}
			cnt = 0;
			while (cnt < size) {
				if (idx != i) {
					cnt++;
					sb2.append(input[idx]);
				}
				idx++;
			}
			if (sb1.compareTo(sb2) == 0) {
				if (!set.contains(sb1.toString())) {
					set.add(sb1.toString());
					resultCnt++;
					result = sb1.toString();
				}
			}
			// System.out.println("sb1 = "+sb1 + ", sb2 = "+sb2 + ", equals = "+ sb1.toString().equals(sb2.toString()));
		}

		if (resultCnt == 0) {
			result = "NOT POSSIBLE";
		} else if (resultCnt > 1) {
			result = "NOT UNIQUE";
		}
		System.out.println(result);

	}

}
