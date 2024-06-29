package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_2195_문자열복사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		char[] data = br.readLine().toCharArray();

		String sum = Character.toString(data[0]);
		int count = 0;
		for (int i = 1; i < data.length; i++) {
			if (!S.contains(sum + data[i])) {
				count++;
				sum = Character.toString(data[i]);
			} else {
				sum += data[i];
			}
		}
		System.out.println(count+1);
	}
}
