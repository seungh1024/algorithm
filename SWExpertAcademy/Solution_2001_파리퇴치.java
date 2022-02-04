package day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] data = new int[N][N];
			
			//입렵 값
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N-(M-1); i++) {
				for(int j = 0; j < N-(M-1); j++) {
					int xsize = i+M;
					int ysize = j+M;
//					System.out.println(size);
					int sum = 0;
					for(int k = i; k <xsize; k++) {
						for(int l = j; l < ysize; l++) {
//							System.out.println("i,j: " + k +","+l+"  "+data[k][l]);
							sum += data[k][l];
						}
					}
					result = sum>result?sum:result;
//					System.out.println(result);
				}
			}
			System.out.println("#"+test_case+ " " +result);
		}
	
	}
	

}


