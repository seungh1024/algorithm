package day0407;

import java.io.*;
import java.util.*;

public class BJ_2239_스도쿠 {
	
	static int[][] map;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		map = new int[9][9];
		list = new ArrayList<>();
		
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			String s = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 0) {
					list.add(new int[] {i,j});
				}
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		/////////////end input /////////////////////
		
		sdk(0,list.size());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i ++) {
			for(int j = 0; j < 9; j++) {
				sb.append(map[i][j]+"");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean sdk(int index, int size) {
//		System.out.println(index+"//"+size);
		if(index == size) {
			return true;
		}
		
		int x,y;
		
			x = list.get(index)[0];
			y = list.get(index)[1];
			if(map[x][y] == 0) {//채워야 하는 곳이면 실행				
				for(int j = 1; j <= 9; j++) {
//					System.out.println(map[x][y]);
					if(isAvailable(x,y,j)) {
//						System.out.println(x+","+y+","+j);
						map[x][y] = j;
						if(sdk(index + 1,size)) {
							return true;
						}
						map[x][y] = 0;
					}
				}
			}
		
		
		return false;
	}
	
	public static boolean isAvailable(int x, int y, int value) {
		for(int i = 0; i < 9; i++) { //행 방향 숫자 겹치는지 체크
			if(map[x][i] == value) {
				return false;
			}
		}
		for(int i = 0; i < 9; i++) {// 열 방향 숫자 겹치는지 체크
			if(map[i][y] == value) {
				return false;
			}
		}
		int lenX = x/3*3;
		int lenY = y/3*3;
		for(int i = lenX; i < lenX+3; i++) { //3x3 배열에서 넣으려는 숫자체크
			for(int j = lenY; j < lenY+3; j++) {
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		
		return true;
	}
}
