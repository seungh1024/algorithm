package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int[][] paper = new int[100][100];
//		System.out.println(paper.length);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0; // 종이 다 붙이기 전에 도화지 다 채우는지 확인할 변수
		//start input
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); //x,y좌표
			int lengthx = x+10;
			int lengthy = y+10;
//			System.out.println(x+","+y);
			for(int p = x; p < lengthx; p++) {
				for(int q = y; q < lengthy; q++) {
					if(p<100&& q < 100 && paper[p][q] == 0) {
						count++;
						paper[p][q] =1;//방문처리
					}
					if(count == 10000) {
						System.out.println(10000);
						return;//프로그램 종료
					}
				}
			}
			
		}//end input
		
		int result = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				result += paper[i][j]==1?1:0;
			}
		}
		System.out.println(result);
	}

}
