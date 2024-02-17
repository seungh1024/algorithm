package algo_202402;

import java.util.Arrays;

public class P_당구연습 {
	public static void main(String[] args) {
		P_당구연습 test = new P_당구연습();
		int m  = 10;
		int n = 10;
		int startX = 3;
		int startY = 7;
		int[][] balls = {{7,7},{2,7},{7,3}};
		int[] result = test.solution(m, n, startX, startY, balls);
		int[] answer = {52, 37, 116};
		if (Arrays.equals(result, answer)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int length = balls.length;
		int[] answer = new int[length];

		for(int i = 0; i < length; i++){
			int x = balls[i][0];
			int y = balls[i][1];
			int min = Integer.MAX_VALUE;
			if(y == startY){ // 가는길에 공이 있으면 안됨
				if(x < startX){ // 타겟이 나보다 왼쪽에 있으면 오른쪽 쿠션 사용
					min = Math.min(min,getLength(x+(m-x)*2,y,startX,startY));
				}
				if(x > startX){ //타겟이 나보다 왼쪽에 있으면 왼쪽 쿠션 사용
					min = Math.min(min,getLength(-x,y,startX,startY));
				}
				min = Math.min(min,getLength(x,y+(n-y)*2,startX,startY));
				min = Math.min(min,getLength(x,-y,startX,startY));

			}else if(x == startX){
				if(y < startY){ // 타겟이 나보다 아래에 있으면 위쪽 쿠션 사용
					min = Math.min(min,getLength(x,y+(n-y)*2,startX,startY));
				}
				if(y > startY){ // 타겟이 나보다 위에 있으면 아래쪽 쿠션 사용
					min = Math.min(min,getLength(x,-y,startX,startY));
				}
				min = Math.min(min,getLength(x+(m-x)*2,y,startX,startY));
				min = Math.min(min,getLength(-x,y,startX,startY));
			}else{
				min = Math.min(min,getLength(x+(m-x)*2,y,startX,startY));
				min = Math.min(min,getLength(-x,y,startX,startY));
				min = Math.min(min,getLength(x,y+(n-y)*2,startX,startY));
				min = Math.min(min,getLength(x,-y,startX,startY));

			}
			answer[i] = min;
		}


		return answer;
	}

	private static int getLength(int x, int y, int xx, int yy){
		int a = xx-x;
		int b = yy-y;
		return a*a+b*b;
	}
}
