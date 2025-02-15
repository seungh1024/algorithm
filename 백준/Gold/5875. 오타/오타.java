import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] data = br.readLine().toCharArray();
		int N = data.length;

		int left = 0;
		int right = 0;

		int max = 0;
		for (int i = 0; i < N; i++) {
			if (data[i] == '(') {
				left++;
			} else {
				right++;
			}

			if (right > left) {
				max = right;
				break;
			}
		}

		left = 0;
		right = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (data[i] == '(') {
				left++;
			} else {
				right++;
			}

			if (left > right) {
				max = left;
				break;
			}
		}

		System.out.println(max);
	}
}