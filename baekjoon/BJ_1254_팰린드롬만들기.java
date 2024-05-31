package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_1254_팰린드롬만들기 {
	public static char[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine().toCharArray();

		int max = 1;
		int length = data.length;
		for (int i = 1; i < length; i++) {
			int left = i-1;
			int right = i+1;
			int count = 1;
			while (left >= 0 && right < length) {
				if (data[left] != data[right]) {
					break;
				}
				count += 2;
				left--;
				right++;
			}
			if (right == length) {
				max = Math.max(max,count);
			}

			left = i-1;
			right = i;
			count = 0;
			while (left >= 0 && right < length) {
				if (data[left] != data[right]) {
					break;
				}
				count+=2;
				left--;
				right++;
			}

			if (right == length) {
				max = Math.max(max,count);
			}

		}

		System.out.println(max + (length-max)*2);
	}

}
