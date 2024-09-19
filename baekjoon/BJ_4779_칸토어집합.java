package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_4779_칸토어집합 {
	public static int size;
	public static boolean[] line;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		StringBuilder sb = new StringBuilder();
		while(true){
			input=br.readLine();
			if (input == null || input.isBlank()) {
				break;
			}
			int N = Integer.parseInt(input);
			size = 1;
			for (int i = 0; i < N; i++) {
				size *= 3;
			}
			line = new boolean[size];
			find(0,size);
			for (boolean b : line) {
				if (!b) {
					sb.append('-');
				} else {
					sb.append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void find(int start, int end) {

		int jump = (end-start)/3;
		int left = start+jump;
		int right = left+jump;
		for (int i = left; i < right; i++) {
			line[i] = true;
		}

		if(end-1 == start) {
			return;
		}
		find(start,left);
		find(right,end);
	}
}
