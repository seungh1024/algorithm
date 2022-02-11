package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1 {
	static int[][] data;
	static int[][] check;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int N,M,R;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//행
		M = Integer.parseInt(st.nextToken());//열
		R = Integer.parseInt(st.nextToken());//회전 수
		
		data = new int[N][M]; //값이 들어갈 배열
		check = new int[N][M];
		
		
		//input
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
//				System.out.print(data[i][j]);
			}
		}//end input
		
		//길 생성
		for(int i =1; i <=N/2; i++) {
			for(int j = i; j < N-i; j++) {
				for(int k = i; k < M-i; k++) {					
					check[j][k] = i;
				}
			}
		}
		
		int point = (N<M?N:M)/2; //출발점 포인트
		//각 외곽의 가장 왼쪽 위 부분을 찍어주기 위함
		
		//변의 길이를 이용해서 몇바퀴 돌아야 하는지 최소화 할 것임
		int lengthx = N;
		int lengthy = M;
		
		for(int p = 0; p < point; p++) {
//			System.out.println('p');
			int x = p;
			int y = p;
			int count =2*lengthx+2*lengthy-4; //한 바퀴
			int move = R%count; 
//			R = R % count;// ==> 왜 안되지?
			
			//R을 move로 바꾸니까 됨 왜..?
			for(int r = 0; r < move; r++) {
//				System.out.println('r');
				int index = 0;
				int nowNum;
				int nextNum = data[p][p];
				for(int c = 0; c < count; c++) {
//					System.out.println('c');
					int nx = x + dx[index%4];
					int ny = y + dy[index%4];
					if(nx<0 || ny < 0 || nx >=N || ny >=M || check[nx][ny] != check[p][p]) {
						index ++;
						nx = x + dx[index%4];
						ny = y + dy[index%4];
					}
					nowNum = nextNum;
					nextNum = data[nx][ny];
					data[nx][ny] = nowNum;
//					System.out.println(nowNum);
//					System.out.print(data[nx][ny]);
					
					x = nx;
					y = ny;
				}
			}
			
			//2씩 줄어드니까 줄여줌
			lengthx-=2;
			lengthy-=2;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
			
	}
}
