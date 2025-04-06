

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int start = 0;
		int end = N;
		int cnt = 0;
		while (start < end && cnt++ < 20) {
			int mid = (start + end) / 2;

			System.out.println("? " + mid);
			int input = Integer.parseInt(br.readLine());
			int sheep = input;
			int wolf = mid - sheep;
			if (sheep == wolf) {
				System.out.println("! " + mid);
				System.out.flush();
				break;
			} else if (sheep < wolf) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
	}
}
