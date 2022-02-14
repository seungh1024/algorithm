package day0214;

import java.io.*;
import java.util.*;

public class BJ_2961_도영이가만든맛있는음식 {
	static int[] sin;//신맛
	static int[] sun;//쓴맛
	static boolean[] check;
	static int result;
	public static void main(String[] args) throws IOException{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sin = new int[N];
		sun = new int[N];
		check = new boolean[N];
		result = 1000000000;
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			sun[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(sin));
//		System.out.println(Arrays.toString(sun));
		combination(0,0,N);
		System.out.println(result);
	}
	
	public static void combination(int cnt,int index ,int N) {
		if(index==N ) {
			int mulsin = 1;
			int sumsun = 0;
			for(int i = 0; i < N; i++ ) {
				if(check[i]) {
					mulsin = mulsin*sin[i];
					sumsun += sun[i];
				}
			}
//			System.out.println(mulsin+"/"+sumsun);
			if(sumsun>0) {
				result = result<Math.abs(mulsin-sumsun)?result:Math.abs(mulsin-sumsun);
			}
			return;
		}
		
		
		check[index] = true;
		combination(cnt+1,index+1,N);
		check[index] = false;
		combination(cnt,index+1,N);
		
	}

}
