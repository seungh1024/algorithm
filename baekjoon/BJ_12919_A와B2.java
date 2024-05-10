package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_12919_A와B2 {
	public static String S;
	public static char[] T;
	public static int tSize;
	public static char[] temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine().toCharArray();

		tSize = T.length;
		temp = new char[tSize];
		if (find()) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static boolean find() {
		if (S.length() == tSize) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tSize; i++) {
				sb.append(T[i]);
			}

			// System.out.println(sb);
			// System.out.println(tSize);

			if (S.equals(sb.toString())) {
				return true;
			}
			return false;
		}

		if (T[0] == 'B') {
			swap();
			tSize--;
			if (find()) {
				return true;
			}
			tSize++;
			swap();
		}
		if (T[tSize-1] == 'A') {
			tSize--;
			if (find()) {
				return true;
			}
			tSize++;
		}

		return false;
	}

	public static void swap() {
		for (int i = 0; i < tSize; i++) {
			temp[i] = T[tSize-1-i];
		}

		for (int i = 0; i < tSize; i++) {
			T[i] = temp[i];
		}
	}

}
