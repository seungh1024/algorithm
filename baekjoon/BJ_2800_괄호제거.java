package day0309;

import java.io.*;
import java.util.*;

public class BJ_2800_괄호제거 {
	
	static char[] data;
	static ArrayList<String> result = new ArrayList<>();
	static ArrayList<Point> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		data= br.readLine().toCharArray();
		
		
		int size = data.length;
		int count = 0; //괄호 쌍의 개수 파악
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < size; i++) {
			if(data[i] == '(') {
				stack.push(i);
				count++;
			}else if(data[i] == ')') {
				int left = stack.pop();
				list.add(new Point(left,i));
			}
		}
		
		subset(count,0,0,new boolean[count]);
		Collections.sort(result);
		int resultSize = result.size();
		String s = result.get(0);
		String rs;
		for(int i = 1; i <resultSize;i++) {
			rs = result.get(i);
			if(!s.equals(rs)) {
				System.out.println(rs);
				s = rs;
			}
		}
	}
	public static class Point{
		int left;
		int right;
		public Point(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	public static void subset(int n, int cnt, int idx, boolean[] visited) {
		if(idx == n) {
			StringBuilder sb = new StringBuilder();
			int size = data.length;
			boolean[] check = new boolean[size];
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					check[list.get(i).left] = true;
					check[list.get(i).right] = true;
				}
			}
			for(int i = 0; i <size; i++ ) {
				if(check[i]) continue;
				sb.append(data[i]);
			}
			result.add(sb.toString());
			return;
		}
		
		visited[idx] = true;
		subset(n,cnt+1,idx+1,visited);
		visited[idx] = false;
		subset(n,cnt,idx+1,visited);
	}
}
