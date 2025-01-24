import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken())+1;
		long K = Long.parseLong(st.nextToken());


		String s = N+"";
		int idx = s.length()-1;
		int length = s.length();
		long plus = 1;
		int range = 0;
		while (true && range++ < 1000) {
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '5') {
					cnt++;
				}
			}

			if (cnt >= K) {
				System.out.println(s);
				break;
			} else {
				N += plus;
			}
			s = N+"";
			if (s.length() > length) {
				length++;
				idx++;
			}
			if (s.charAt(idx) == '5') {
				plus *= 10;
				idx--;
			}
			// System.out.println("s = "+s);
		}

	}

	public static boolean check(long N, long K) {
		String s = N + "";
		char[] data = s.toCharArray();
		int cnt = 0;
		for (char c : data) {
			if (c == '5') {
				cnt++;
			}
		}

		if (cnt >= K) {
			return true;
		}

		return false;
	}
}