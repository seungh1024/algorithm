

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] input = br.readLine().toCharArray();
		char[] data = new char[N + 1];

		for (int i = 1; i <= N; i++) {
			data[i] = input[i - 1];
		}

		int left = 1;
		int right = N;

		while (left < right && K-->0) {
			while (left <= N) {
				if (data[left] == 'C') {
					break;
				}
				left++;
			}
			while (right > 0) {
				if (data[right] == 'P') {
					break;
				}
				right--;
			}
			if(left >= right) break;
			char l = data[left];
			char r = data[right];
			data[left] = r;
			data[right] = l;
			left++;
			right--;
		}
		// System.out.println(Arrays.toString(data));

		long result = 0;
		long cnt = 0;
		long total = 0;
		for (int i = 1; i <= N; i++) {
			if (data[i] == 'P') {
				total += cnt;
				cnt++;
			} else if (data[i] == 'C') {
				result += total;
			}


		}


		System.out.println(result);
	}
}
