package day0217;

import java.io.*;
import java.util.*;

public class BJ_3109_빵집 {
	static int result;
	static boolean[][] check;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		check = new boolean[R][C]; //방문했는지 확인
		char[][] gas = new char[R][C];
		for(int i = 0; i <R; i++) {
			gas[i] = br.readLine().toCharArray();
//			System.out.println(gas[i]);
		}
		
		result = 0;
		
		for(int i = 0; i < R; i++) {
			if(gas[i][0] != 'x') {				
				findLine(gas,i,0,R,C);
			}
		}
		System.out.println(result);
	}
	
	public static boolean findLine(char[][] gas ,int nowRow, int nowCol , int R, int C) {
		
		
		if(nowCol == C-1 ) {//마지막까지 도달했다면 카운트를 시켜줘야함
			check[nowRow][nowCol] = true;
			result++;
//			System.out.println("result "+result);
//			System.out.println("////////////////////////");
//			for(int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(check[i]));
//			}
//			System.out.println(nowCol + ","+C);
			return true;
		}
		
		for(int r = -1; r<2; r++) {//현재 위치에서 다음 위치로 이동할 때 행이 움직일 수 있는 범위
//			System.out.println((nowRow+r) + "," +(nowCol+1) );
			if(available(gas,nowRow+r,nowCol+1)) {//다음 위치가 이동이 가능하면
				check[nowRow][nowCol] = true; //다음 지점 방문 체크
				
				if(findLine(gas,nowRow+r,nowCol+1,R,C)) {
					return true;
				}
				
			}
		}
		return false;
	}
	
	public static boolean available(char[][] gas,int nowRow, int nowCol) {
		if( nowRow>=gas.length || nowRow<0 || nowCol >= gas[0].length || check[nowRow][nowCol] ||gas[nowRow][nowCol] == 'x' ) {
			return false;
		}
		
		return true;
	}

}

//5 5
//...x.
//.....
//..x.x
//.....
//...x.


//5 6
//...x..
//.....x
//..x.xx
//.....x
//...x..

//5 6
//...x.x
//......
//..x..x
//.x...x
//..xx.x

//5 6
//...x..
//......
//..x...
//.x....
//..xx..
