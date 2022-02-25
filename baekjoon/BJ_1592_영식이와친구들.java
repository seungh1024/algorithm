package day0225;

import java.io.*;
import java.util.*;

public class BJ_1592_영식이와친구들 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] circle = new int[N];
		int count = 0;
		int index = 0;
		
		while(N>0) {
			circle[index]++;
//			System.out.println(Arrays.toString(circle));
			if(circle[index] == M) {
				break;
			}
			count++;
			if(circle[index]%2==0) {//공을 받은 경우가 짝수번인 경우
				index =  (index+L)%N;
			}else {//홀수 번인 경우
				index -= L;
				if(index <0) {
					index += N;
				}
			}
		}
		
		System.out.println(count);
	}

}
