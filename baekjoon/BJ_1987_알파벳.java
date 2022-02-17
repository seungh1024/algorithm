package day0217;

import java.io.*;
import java.util.*;

public class BJ_1987_알파벳 {
	
	static char[][] alpha;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int max;
	static int result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		alpha  = new char[R][C];
		result = 0;
		
		for(int i = 0; i < R; i++) {
			alpha[i] = br.readLine().toCharArray();
//			System.out.println(Arrays.toString(alpha[i]));
		}
		
		String s = "";
		for(int i = 0; i <R; i++) {
			for(int j = 0; j <C; j++) {
				if(!s.contains(""+alpha[i][j])) {
					s+= alpha[i][j];
				}
			}
		}
		max = s.length();
		
		dfs(0,0,""+alpha[0][0],R,C,1); //0,0에서 시작, 0,0의 알파벳 넘겨주고 R,C의 값과 처음 자기자신부터 시작하니 카운트는 1
		
		System.out.println(result);
		
	}
	
	public static boolean dfs(int x, int y, String s, int R, int C, int count) {
//		if(!s.contains(""+alpha[x][y])) {//해당 값을 포함하지 않는다면
//			return;
//		}else {
//			result++;
//		}
		
		result = result>count?result:count;
		
		if(s.length() == max) {
			return true;
		}
		
//		System.out.println(count);
		
		for(int i = 0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
//			System.out.println(nx+","+ny);
			if(nx>=0 && nx <R && ny >=0 && ny < C && !s.contains(""+alpha[nx][ny])) {
//				System.out.println(alpha[nx][ny] + ","+nx+","+ny+"//"+s);
				boolean tf = dfs(nx,ny,s+alpha[nx][ny],R,C,count+1);
				if(tf) {
					return true;
				}
			}
		}
		return false;
	}

}
