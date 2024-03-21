package algo_202403;

import java.util.*;

public class R_P_표편집 {
	public String solution(int n, int k, String[] cmd) {
		String answer = "";

		Node head = new Node();
		Node tail = new Node();
		tail.index = -1;
		Node last = head;
		for(int i = 0; i < n; i++){
			Node node = new Node();
			node.index = i;
			last.next = node;
			node.last = last;
			last = node;
		}
		last.next = tail;
		tail.last = last;
		Node now = head.next;

		// Node test = now;
		// while(test.index != -1){
		//     System.out.println(test.index);
		//     test = test.next;
		// }

		for(int i = 0; i < k; i++){
			now = now.next;
		}

		Stack<Node> stack = new Stack<>();
		for(String s : cmd){
			int length = s.length();
			if(length>1){
				String[] input = s.split(" ");
				int X = Integer.parseInt(input[1]);
				if(input[0].equals("U")){
					for(int i = 0; i < X; i++){
						now = now.last;
					}
				}else if(input[0].equals("D")){
					for(int i = 0; i < X; i++){
						now = now.next;
					}
				}
				// System.out.println("index = "+now.index);
			}else{
				if(s.equals("C")){
					stack.push(now);
					Node up = now.last;
					Node down = now.next;
					up.next = down;
					down.last = up;
					if(down.index == -1){
						now = up;
					}else{
						now = down;
					}
				}else if(s.equals("Z")){
					Node rollBack = stack.pop();
					Node up = rollBack.last;
					Node down = rollBack.next;
					up.next = rollBack;
					down.last = rollBack;
				}
			}
		}

		Node test = head.next;

		String[] result = new String[n];
		Arrays.fill(result,"X");
		now = head.next;
		while(now.index != -1){
			result[now.index] = "O";
			now = now.next;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			sb.append(result[i]);
		}
		answer = sb.toString();
		return answer;
	}

	public static class Node{
		Node last;
		Node next;
		int index;

		public Node(){}
	}
}
