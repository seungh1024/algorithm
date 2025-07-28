

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] data = new char[N];
		for (int i = 0; i < N; i++) {
			data[i] = br.readLine().charAt(0);
		}

		Deque<Character> dq = new ArrayDeque<>();
		
		int left = 0;
		int right = N-1;


		while (left <= right) {
			// System.out.println("left = "+left + ", right = "+right);
			if (data[left] < data[right]) {
				dq.offer(data[left]);
				left++;
			} else if (data[left] > data[right]) {
				dq.offer(data[right]);
				right--;
			} else {

				int l = left;
				int r = right;
				boolean isLeft = false;

				while (l< r) {
					if (data[l] != data[r]) {

						if (data[l] < data[r]) {
							isLeft = true;
						}
						break;
					}
					l++;
					r--;
				}

				// System.out.println("l = "+l +", r = "+r +", isLeft = "+isLeft +", isRight = "+isRight);
				if (isLeft) {
					dq.offer(data[left]);
					left++;
				} else  {
					dq.offer(data[right]);
					right--;
				}

			}
		}

		StringBuilder sb = new StringBuilder();
		int line = 0;
		while (!dq.isEmpty()) {
			sb.append(dq.poll());
			line++;
			if (line % 80 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
