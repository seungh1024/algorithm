

import java.io.*;
import java.util.*;

public class Main {
	public static int result = 0;
	public static Set<Long> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		set = new HashSet<>();

		find(4, A, B,1);
		find(7, A, B,1);

		System.out.println(result);
	}

	public static void find(long n, long A, long B, long temp) {
		if(n > B || set.contains(n)) return;

		if (n >= A && n <= B) {
			result++;
		}

		set.add(n);
		long nextTemp = temp*10;
		find(n + nextTemp * 4, A, B, nextTemp);
		find(n + nextTemp * 7, A, B, nextTemp);
		find(n * 10 + 4, A, B, nextTemp);
		find(n * 10 + 7, A, B, nextTemp);
	}
}
