package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_2469_사다리타기 {
	public static int K, N;
	public static char[][] data;
	public static int[] up,down;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		data = new char[N][K];


		String s = br.readLine();
		int[] nums = new int[K];
		for (int i = 0; i < K; i++) {
			nums[i] = s.charAt(i)-'A';
		}

		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < K-1; j++) {
				data[i][j] = chars[j];
			}
		}

		up = new int[K];
		down = new int[K];
		for (int i = 0; i < K; i++) {
			up[i] = i;
			down[i] = nums[i];
		}
		for (int i = 0; i < N; i++) {
			if(data[i][0] == '?') break;
			int[] temp = new int[K];
			for (int j = 0; j < K; j++) {
				if (j == K - 1) {
					if (data[i][j - 1] == '-') {
						temp[j - 1] = up[j];
					} else {
						temp[j] = up[j];
					}
					continue;
				}
				if (data[i][j] == '*') {
					if (j > 0 && data[i][j - 1] == '-') {
						temp[j - 1] = up[j];
					} else {
						temp[j] = up[j];
					}
				} else {
					temp[j+1] = up[j];
				}
			}

			for (int j = 0; j < K; j++) {
				up[j] = temp[j];
			}
		}

		for(int i = N-1; i >= 0; i--){
			if(data[i][0] == '?') break;
			int[] temp = new int[K];
			for (int j = 0; j < K; j++) {
				if (j == K - 1) {
					if (data[i][j - 1] == '-') {
						temp[j - 1] = down[j];
					} else {
						temp[j] = down[j];
					}
					continue;
				}
				if (data[i][j] == '*') {
					if (j > 0 && data[i][j - 1] == '-') {
						temp[j - 1] = down[j];
					} else {
						temp[j] = down[j];
					}
				} else {
					temp[j+1] = down[j];
				}
			}

			for (int j = 0; j < K; j++) {
				down[j] = temp[j];
			}
		}

		// System.out.println(Arrays.toString(up));
		// System.out.println(Arrays.toString(down));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K - 1; i++) {
			if (up[i] == down[i]) {
				sb.append('*');
			} else if (up[i] == down[i + 1]) {
				sb.append('-');
				int left = down[i];
				int right = down[i + 1];
				down[i] = right;
				down[i + 1] = left;
			} else {
				sb = new StringBuilder();
				for (int j = 0; j < K - 1; j++) {
					sb.append('x');
				}
				break;
			}
		}

		// System.out.println(Arrays.toString(down));
		System.out.println(sb);
	}


}
