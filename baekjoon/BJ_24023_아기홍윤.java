package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_24023_아기홍윤 {
	public static int N,K;
	public static int[] data;
	public static int[] count;
	public static String one = "1", zero = "0";

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		count = new int[32];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		long sum = 0;
		String binary = null;

		boolean flag = false;
		while (right < N) {
			if (sum < K) { // 더 더해줘야 하는 경우
				binary = Integer.toBinaryString(data[right]);
				sum = plusBinaryCount(binary);
				right++;

			} else {
				binary = Integer.toBinaryString(data[left]);
				sum = minusBinaryCount(binary);
				left++;
				if (left > right) {
					right++;
				}
			}
			if (sum == K) {
				left++;
				flag = true;
				break;
			}
			// System.out.println("left = "+left + ", right = "+right + ",sum = "+sum);
		}

		if (flag) {
			System.out.println(left + " " + right);
		} else {
			System.out.println(-1);
		}

	}

	public static long plusBinaryCount(String s) {
		int length = s.length();
		long result = 0;
		// System.out.println("binary = "+s);
		for (int i =0; i <length; i++) {
			if (s.charAt(i) == '1') {
				count[length-1-i]++;
			}
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				result += (1L << i);
			}
		}
		// System.out.println("plus = "+result);
		// System.out.println("count = "+Arrays.toString(count));
		return result;
	}

	public static long minusBinaryCount(String s) {
		int length = s.length();

		// System.out.println("binary minus = "+s);
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == '1') {
				count[length-1-i]--;
			}
		}

		long result = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				result += (1L << i);
			}
		}

		// System.out.println("minus = "+result);
		// System.out.println("count = "+Arrays.toString(count));
		return result;
	}
}
