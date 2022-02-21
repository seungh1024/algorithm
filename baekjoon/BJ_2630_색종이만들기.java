package day0218;


import java.util.*;
import java.io.*;

public class BJ_2630_색종이만들기 {
	
	static int blue = 0;
	static int white = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] data = new int[N][N];
		for(int i = 0; i < N; i++) {//start input
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(data[i]));
		}//end input
		
		cut(data,N,0,0);
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	public static void cut(int[][] data, int length , int x, int y) {
		int num = data[x][y];
		boolean check = false;
		for(int i = x; i < x+length; i++) {
			for(int j = y; j <y+length; j++) {
				if(num != data[i][j]) {
					check =true;
					break;
				}
			}
			if(check) {
				break;
			}
		}
		
		if(check) {//모두 같은 수가 아닐 경우 잘라서 다시 탐색
			int half = length/2;
			cut(data,half,x,y);
			cut(data,half,x,y+half);
			cut(data,half,x+half,y);
			cut(data,half,x+half,y+half);
		}else if(num == 1) {
			blue++;
		}else if(num == 0) {
			white++;
		}
	}
}
