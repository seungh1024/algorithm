package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_9012_괄호 {
	public static int T;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			char[] input = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			for(char c : input){
				if(c == '('){
					stack.push(c);
				}else{
					if (stack.isEmpty()) {
						flag = true;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (flag || !stack.isEmpty()) {
				sb.append("NO");
			} else {
				sb.append("YES");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
