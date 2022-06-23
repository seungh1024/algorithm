package algoSolveAgain;

import java.io.*;
import java.util.*;

public class BJ_1992_쿼드트리 {
	public static int N;
	public static char[][] array;
	public static StringBuilder result;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			array[i] = br.readLine().toCharArray();
//			System.out.println(Arrays.toString(array[i]));
		}
		
		result = new StringBuilder();
		
		makeString(N,0,0);
		
		System.out.println(result);
	}
	
	public static void makeString(int size, int x, int y) {
//		System.out.println("x: "+x+" y: "+y+ " size: "+size);
		if(size == 1) {
			result.append(array[x][y]);
			return;
		}
		
		
		char first = array[x][y];
		boolean check = false;
		
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if(first != array[i][j]) {
					check =true;
					break;
				}
			}
		}
		
		if(check) {
			result.append("(");
			int nsize = size/2;
			makeString(nsize,x,y);
			makeString(nsize,x,y+nsize);
			makeString(nsize,x+nsize,y);
			makeString(nsize,x+nsize,y+nsize);
			result.append(")");
		}
		else {
			result.append((first));
		}
		
	}
}
