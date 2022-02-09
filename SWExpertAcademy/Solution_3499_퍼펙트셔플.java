package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Solution_3499_퍼펙트셔플 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			Deque<String> deque1 = new LinkedList<>();
			Deque<String> deque2 = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			int n = (N+1)/2;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				deque1.add(st.nextToken());
			}
			for(int i = n; i <N; i++) {
				deque2.add(st.nextToken());
			}
//			System.out.println(deque1.toString());
//			System.out.println(deque2);
			System.out.print("#"+test_case+" ");
			while(!deque1.isEmpty()) {
				System.out.print(deque1.pop()+" ");
				if(!deque2.isEmpty()) {
					System.out.print(deque2.pop()+" ");
				}
			}
			System.out.println();
		}
	}

}
