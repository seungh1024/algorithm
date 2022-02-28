package day0227;

import java.io.*;
import java.util.*;

public class BJ_2578_빙고 {
	
	static int[][] bingo = new int[5][5];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		for(int i = 0; i <5; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for(int i = 0; i < 5; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <5; j++) {
				int now = Integer.parseInt(st.nextToken());
				check(now);
				count++;
				if(count>=10 && find()) {
					System.out.println(count);
					return;
				}
			}
		}
	}
	public static boolean find() {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			boolean a = true;
			boolean b = true;
			for(int j = 0; j < 5; j++) {
				if(bingo[i][j] != 0) {
					a =false;
				}
				if(bingo[j][i] != 0) {
					b = false;
				}
			}
			if(a) {
				count++;
			}
			if(b) {
				count++;
			}
			if(count>=3) {
				return true;
			}
		}
		boolean c = true;
		boolean d = true;
		for(int i = 0; i < 5; i++) {
			if(bingo[i][i] != 0) {
				c = false;
			}
			if(bingo[i][4-i] != 0) {
				d = false;
			}
		}
		if(c) {
			count++;
		}
		if(d) {
			count++;
		}
		if(count>=3) {
			return true;
		}
		return false;
	}
	
	public static void check(int now) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(bingo[i][j] == now) {
					bingo[i][j] = 0;
				}
			}
		}
		
//		System.out.println("///////////////////");
//		for(int i = 0; i < 5; i++) {
//			System.out.println(Arrays.toString(bingo[i]));
//		}
//		System.out.println();
	}

}
