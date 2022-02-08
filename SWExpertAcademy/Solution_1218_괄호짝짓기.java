package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		
		for(int test_case = 1; test_case<=10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[] data = br.readLine().toCharArray();
//			System.out.println(Arrays.toString(data));
			int result = 1;

			for(char c : data) {
				switch(c) {
				case ')':
					//비어있지 않고 같다면 
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}else {//비어 있거나 짝이 맞지 않다면
						result = 0;
					}
					break;
				case '}':
					if(!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					}else {
						result = 0;
					}
					break;
				case ']':
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}else {
						result = 0;
					}
					break;
				case '>':
					if(!stack.isEmpty() && stack.peek() == '<') {
						stack.pop();
					}else {
						result = 0;
					}
					break;
				default:
					stack.push(c);
//					System.out.println(c);
				}//end switch
				if(result ==0) {
					break;
				}
				
			}//end for
			if(!stack.isEmpty()){
				result = 0;
			}
			System.out.println("#"+test_case+" "+result);
			stack.clear();
		}
	}
}