package day0220;

import java.io.*;
import java.util.*;

public class BJ_17829_222풀링 {
	static int[][] result;
	static int[][] data;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		data = new int [N][N];
		result = new int [N/2][N/2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(data[i]));
		}
		
		func(data,0,0,N);
		
		
		while(N>2) {
			func(data,0,0,N);
			N = N/2;
		}
		System.out.println(data[0][0]);
		
//		func(data,0,0,N);
//		for(int i =0; i < N/2; i++) {
//			System.out.println(Arrays.toString(data[i]));
//		}
	}
	
	public static void func(int[][] data,int x, int y , int length) {
		
		if(length == 2) {
//			System.out.println('c'+"//"+x+","+y);
			int [] second = new int [4];
			second[0] = data[x][y];
			second[1] = data[x][y+1];
			second[2] = data[x+1][y];
			second[3] = data[x+1][y+1];
			Arrays.sort(second);
			data[x/2][y/2] = second[2];
		}else {
			int half = length/2;
			func(data,x,y,half);
			func(data,x,y+half,half);
			func(data,x+half,y,half);
			func(data,x+half,y+half,half);
		}
	}
}
