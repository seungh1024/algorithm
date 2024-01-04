package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_9625_BABBA {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		int aCount = 1;
		int bCount = 0;
		for (int i = 1; i <= K; i++) {
			int a = aCount;
			int b = bCount;
			aCount = b;
			bCount = a+b;
		}
		System.out.println(aCount + " " + bCount);
	}
}
