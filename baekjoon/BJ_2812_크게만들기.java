package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_2812_크게만들기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] input = br.readLine().toCharArray();

		Deque<Character> dq = new ArrayDeque<>();
		dq.offer(input[0]);
		for(int i = 1; i < N; i++){
			char next = input[i];

			while(!dq.isEmpty() && K > 0){
				char now = dq.pollLast();
				if(now < next){
					K--;
				}else{
					dq.offerLast(now);
					break;
				}
			}
			dq.offerLast(next);
		}
		for(int i = K; i > 0; i--){
			dq.pollLast();
		}
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()){
			sb.append(dq.pollFirst());
		}
		System.out.println(sb);
	}
}
