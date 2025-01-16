package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_5875_오타 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] data = br.readLine().toCharArray();

		int left = 0;
		int right = 0;
		int total = 0;
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == '(') {
				left++;
				total++;
			} else {
				right++;
				total--;
			}
			if (total <= 1) {
				left = 0;
			}

			if (total == -1) {
				result = right;
				break;
			}
		}
		if (total > 0) {
			result = left;
		}
		System.out.println(result);
	}
}
