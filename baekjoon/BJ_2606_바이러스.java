package day0219;

import java.io.*;
import java.util.*;

public class BJ_2606_바이러스 {
	static boolean check[];
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		check = new boolean[com+1];
		
		Node[] node = new Node[com+1];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(node[a] != null) {
				node[a].data.add(b);
			}
			else if(node[a] == null) {				
				node[a] = new Node(b);
			}
			if(node[b] != null){

				node[b].data.add(a);
			}
			else if(node[b] == null){
				node[b] = new Node(a);
			}
//			System.out.println(node[a].data.toString());
		}
		
		
		bfs(node);
		System.out.println(result);
	}
	
	public static void bfs(Node[] node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		check[1] = true;
		
		while(!queue.isEmpty()) {
			int com = queue.poll();
			if(node[com]!=null) {				
				for(int comNum : node[com].data) {
					if(!check[comNum]) {					
						queue.offer(comNum);
						result++;
						check[comNum] = true;
					}
				}
			}
			
		}
	}
	
	public static class Node{
		ArrayList<Integer> data;
		
		public Node(int data) {
			super();
			this.data = new ArrayList<>();
			this.data.add(data);
		}
	}
}

