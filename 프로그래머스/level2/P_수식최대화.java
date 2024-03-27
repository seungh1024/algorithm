package algo_202403;

import java.util.*;

public class P_수식최대화 {
	public static String[] operator = {"+","-","*"};
	public static int[] check = {0,0,0};
	public static boolean[] visited;
	public static long result;
	public static String[] data;

	public long solution(String expression) {
		long answer = 0;

		result = 0;
		visited = new boolean[3];

		char[] input = expression.toCharArray();
		int length = input.length;
		Queue<String> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++){
			if(input[i] == '+' || input[i] == '-' || input[i] == '*'){
				q.offer(sb.toString());
				q.offer(input[i]+"");
				sb = new StringBuilder();
			}else{
				sb.append(input[i]);
			}
		}
		q.offer(sb.toString()); // 마지막 숫자 넣어주기

		int size = q.size();
		data = new String[q.size()];
		for(int i = 0; i < size; i++){
			data[i] = q.poll();
		}
		// System.out.println(Arrays.toString(data));


		find(0);
		// System.out.println(Arrays.toString(check));
		// makeResult();
		answer = result;

		return answer;
	}

	public static void find(int index){
		if(index == 3){
			// System.out.println(Arrays.toString(check));
			makeResult();
			return;
		}

		for(int i = 0; i < 3; i++){
			if(!visited[i]){
				visited[i] = true;
				check[index] = i;
				find(index+1);
				visited[i] = false;
			}
		}
	}

	public static void makeResult(){
		Stack<String> stack = new Stack<>();
		Stack<String> temp = new Stack<>();
		for(String s : data){
			stack.push(s);
		}
		// System.out.println(stack);

		for(int i = 0; i < 3; i++){
			while(!stack.isEmpty()){
				temp.push(stack.pop());
			}

			String op = operator[check[i]];
			while(!temp.isEmpty()){
				String now = temp.pop();
				// System.out.println(now);
				if(now.equals(op)){ // 현재 우선순위의 연산자 만난 경우
					long right = Long.parseLong(temp.pop());
					long left = Long.parseLong(stack.pop());
					long value = operation(left,right,op);
					stack.push(value+"");
				}else{ // 숫자나 현재 우선순위 아닌 연산자 만난 경우
					stack.push(now);
				}
			}
			// System.out.println(stack);
			while(!stack.isEmpty()){
				temp.push(stack.pop());
			}
			// System.out.println(temp);
		}

		long value = Long.parseLong(temp.pop());
		result = Math.max(result,Math.abs(value));
	}

	public static long operation(long left, long right, String op){
		if(op.equals("+")){
			return left+right;
		}else if(op.equals("-")){
			return left-right;
		}else{
			return left*right;
		}
	}
}
