package day0215;

import java.io.*;
import java.util.*;

public class BJ_1074_Z {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = 1;
		for(int i = 0; i < N; i++) { //배열 사이즈 설정
			size = size *2;
		}
		N = size;
		size = size*size;
		
//		System.out.println(size);
		
		int count = 0;
		int half = 0;
		while(size>4) {
			int piece = size/4;
			half = N/2;
//			System.out.println("half "+half+ " r " + r + " c "+c);
			if(r<half) {
				if(c<half) {//r,c가 북서쪽에 있을 경우
//					System.out.println("a " + count);
				}else {//r,c가 북동쪽에 있을 경우
					count+= piece;
					c-=half;
//					System.out.println("b " + count);
				}
			}else {
				if(c<half) {//r,c가 남서쪽에 있을 경우
					count += 2*piece;
					r -= half;
//					System.out.println("c " + count);
				}else {//r,c가 남동쪽에 있을 경우
					count += 3*piece;
					r-=half;
					c-=half;
//					System.out.println("d " + count);
				}
			}
			
			size = size/4;
			N = N/2;

		}
//		System.out.println(trashr+","+trashc);
		int[][] last = {{0,1},{2,3}};
		count += last[r][c];
		
		System.out.println(count);
		
	}

}
