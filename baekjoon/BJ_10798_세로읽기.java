package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_10798_세로읽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Character>[] list = new ArrayDeque[5];
		for (int i = 0; i < 5; i++) {
			list[i] = new ArrayDeque<>();
		}

		for (int i = 0; i < 5; i++) {
			char[] input = br.readLine().toCharArray();
			for(char c : input){
				list[i].offer(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		while(true){
			boolean flag = false;
			for (int i = 0; i < 5; i++) {
				if (!list[i].isEmpty()) {
					flag = true;
					sb.append(list[i].poll());
				}
			}
			if(!flag) break;
		}

		System.out.println(sb);
	}

}
