package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_20365_블로그2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] data = br.readLine().toCharArray();

		int count = 1;
		for (int i = 1; i < N; i++) {
			if (data[i - 1] != data[i] && data[i] != data[0]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
