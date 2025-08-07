

import java.io.*;
import java.util.*;

public class Main {
	public static long x,y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());


		long num = 1;
		long sum = x+y;
		while (sum - num >= 0) {
			sum -= num;
			num++;
		}

		num--;
		// System.out.println("sum = "+sum +", num = "+num);

		if (sum != 0) {
			System.out.println(-1);
			return;
		}

		int cnt= 0;
		while (x > 0) {
			x -= num;
			num--;
			cnt++;
		}
		System.out.println(cnt);

	}
}
