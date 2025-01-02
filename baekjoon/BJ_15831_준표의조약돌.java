package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_15831_준표의조약돌 {
	public static int N, B, W;
	public static char[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		data = br.readLine().toCharArray();

		int left = 0;
		int right = 0;

		int b = 0;
		int w = 0;
		int max = 0;
		int cnt = 0;
		boolean flag = false;
		while (left<=N &&!flag) {
			if (data[right] == 'W') {
				w++;
			} else {
				b++;
			}
			cnt++;
			right = (right+1)%N;
			if (b <= B && w >= W) {
				max = Math.max(max, cnt);
			}
			// System.out.println("right = "+right +", cnt = "+cnt + ", w = "+ w +", b = "+b);
			if (right == 0) {
				flag = true;
			}
			while (b > B && left < N) {
				if (data[left] == 'W') {
					w--;
				} else {
					b--;
				}
				cnt--;
				left++;

				if (b <= B && w >= W) {
					max = Math.max(max, cnt);
				}
				// System.out.println("left = "+left +", cnt = "+cnt+ ", w = "+ w +", b = "+b);
			}

		}
		System.out.println(max);

	}
}
