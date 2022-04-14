package day0413;

import java.io.*;
import java.util.*;

public class BJ_15662_톱니바퀴2 {
	
	static int[][] map;
	static int[] header;
	static int T;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		map = new int[T+1][8];
		header = new int[T+1];
		for(int i = 1; i <=T; i++) {
			String s = br.readLine();
			for(int j = 0; j < 8; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int wheel,clock;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			wheel = Integer.parseInt(st.nextToken());//바퀴 번호
			clock = Integer.parseInt(st.nextToken());// 시계,반시계. 시계는 1, 반시계는 -1
			move(wheel,clock);
		}
		int result = 0;
		
		for(int i = 1; i <= T; i++) {
			if(map[i][header[i]] == 1) {
				result++;
			}
		}
		System.out.println(result);
//		System.out.println(Arrays.toString(header));
	}
	
	public static void move(int wheel, int clock) {
//		System.out.println("move "+wheel);
		int nowHeader = header[wheel];//현재 중심 바퀴의 헤더
		if(wheel + 1 <= T) {//우측 톱니가 있는 경우
			setHeader(wheel+1,true,wheel,(nowHeader+2)%8,clock*(-1));
		}
		
		if(wheel -1 >= 1) {//좌측 톱니가 있는 경우
			setHeader(wheel-1,false,wheel,(nowHeader+6)%8,clock*(-1));
		}
		
		if(clock == 1) {
			header[wheel] = (nowHeader+7)%8;
		}else {
			header[wheel] = (nowHeader+1)%8;
		}
	}
	
	//check는 중심 바퀴 기준 오른쪽인지 왼쪽인지 체크, ns는 centerWheel톱니의 맞물린 위치의 극의 위치
	public static void setHeader(int wheel, boolean check,int centerWheel, int ns, int clock){
		if(wheel >T || wheel <1) return; //범위 벗어나면 리턴
//		System.out.println(wheel+" wheel");
//		System.out.println("last: "+ns);
		int head = header[wheel]; //맞물린 바퀴의 헤더
		int point = 0; //맞물린 톱니의 위치 +2,+6 할 것임
		
		if(check) { //오른쪽에 맞물려 있다면
			point = 6; //+6한 곳이 톱니 위치
		}else {
			point = 2;
		}
//		System.out.println(map[centerWheel][ns] +","+ map[wheel][(head+point)%8]);
		if(map[centerWheel][ns] == map[wheel][(head+point)%8]) {//회전 안함 -> 극이같기때문
			return;
		}else {//회전 함
			if(check) {//우측 맞물린 경우
				setHeader(wheel+1,true,wheel,(head+2)%8,clock*-1); //다음으로 맞물린 오른쪽 바퀴 재귀호출하여 회전
			}else {//좌측에 연속해서 맞물린 경우
				setHeader(wheel-1,false,wheel,(head+6)%8,clock*-1); //다음으로 맞물린 왼쪽 바퀴 재귀호출하여 회전
			}
			if(clock == 1) {//시계 방향 회전 하는 경우
				header[wheel] = (head+7)%8; //헤더 위치를 현재 값에서 한 칸 뒤로 옮김
			}else {//반시계일경우
				header[wheel] = (head+1)%8;//헤더 위치를 현재 값에서 한 칸 앞으로 옮김
			}
		}
	}
}
