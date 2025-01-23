import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Integer> list = List.of(1, 2, 3);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		find(0,"");
	}

	public static boolean find(int length, String s) {
		if (length == N) {
			System.out.println(s);
			return true;
		}

		for (int i : list) {
			if (check(s + i)) {
				if (find(length + 1, s + i)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean check(String s) {
		int length = s.length();
		int range= length/2;
		for (int i = 1; i <= range; i++) {
			if (s.substring(length - i * 2, length - i).equals(s.substring(length - i))) {
				return false;
			}
		}

		return true;
	}
}