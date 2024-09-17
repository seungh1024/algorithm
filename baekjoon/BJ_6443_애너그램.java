package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_6443_애너그램 {
	public static int N;
	public static char[] data;
	public static int[] anagram;
	public static char[] result;
	public static StringBuilder sb;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			data = br.readLine().toCharArray();
			anagram = new int[26];
			result = new char[data.length];
			for(char c : data){
				anagram[c-'a']++;
			}

			find(0);
		}
		System.out.println(sb);
	}

	public static void find(int idx) {
		if (idx == data.length) {
			sb.append(new String(result)).append("\n");
			return;
		}

		for (int i = 0; i < anagram.length; i++) {
			if (anagram[i] > 0) {
				anagram[i]--;
				result[idx] = (char)(i+'a');
				find(idx+1);
				anagram[i]++;
			}
		}
	}
}
