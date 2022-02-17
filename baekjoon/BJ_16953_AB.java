package algo.study;

import java.io.*;
import java.util.*;

public class BJ_16953_AB {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.out.println(Integer.MAX_VALUE);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		while(A<B) {
			if(B%10 == 1) {
				B-=1;
				B=B/10;
			}
			else if(B%2 == 0) {
				B = B/2;
			}else {
				break;
			}
			count++;
			
//			System.out.println(A+","+B);
		}
		if(A == B) {
			System.out.println(count+1);
		}else {
			System.out.println(-1);
		}
		
		
	}

}
