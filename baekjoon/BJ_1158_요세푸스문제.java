package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		//데이터 입력
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 0; i < K-1; i++) {
				queue.add(queue.poll());//앞에 값을 빼서 뒤로 넣음
			}
			sb.append(queue.poll()).append(", ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
