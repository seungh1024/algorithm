package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SWEA_1210_Ladder1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] move = new int[] {-1,1}; //왼쪽,오른쪽, 아래도 왼쪽과 같은 값으
		for(int test_case=1; test_case<=10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] ladder = new int[100][100];
			//입력
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			char[] last = br.readLine().toCharArray();
//			ladder[99] = last;
//			System.out.println(last);
			int x = 99;
			int y = 0;
			//출발지 찾기
			for(int i= 0; i < 100; i ++) {
				if(ladder[99][i] == 2) {
//					System.out.println(ladder[99][i]);
					y = i;
				}
			}
//			System.out.println(startY);
			
			//1이면 움직일 수 있는 상태
			int left = 1;
			int right = 1;
			while(true) {
				if(x==0) {
					System.out.println("#"+test_case+" "+y);
					break;
				}
				if(left==1 && y>0 && ladder[x][y-1] == 1) {
					right = 0;
					y-=1;
					if(ladder[x-1][y] == 1) {
						x-=1;
						right = 1;
					}
				}else if(right ==1 && y < 99 && ladder[x][y+1] ==1) {
					left = 0;
					y+=1;
					if(ladder[x-1][y] == 1) {
						x-=1;
						left = 1;
					}
				}
//				else if(y>0&& y<99 &&ladder[x][y-1] == 0 && ladder[x][y+1] == 0) {
//					x-=1;
//				}
				else {
					x-=1;
				}
//				System.out.println(x+"//"+y);
			}
		}
	}

}