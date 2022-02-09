package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;

public class Algo_2304_창고다각형 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>(700);

		//L,H 입력
		int max = 0;
		int maxKey = 0;
		int result = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if(H>=max) {//가장 오른쪽에 있는 max값을 넣기 위함
				max = H;
				maxKey = L;
			}
			map.put(L, H); 
		}
		
		//키 값 저장
		Set<Integer> key = map.keySet();
		int left = 0; //비교를 위한 왼쪽 키 값
		int right=0; //비교를 위한 오른쪽 키 값
		
		//최고점 이후에 값들을 저장할 스택 -> 끝에서부터 비교할 수 있게
		Stack<Integer> stack = new Stack<>();
		for(int k : key) {
			if(left == maxKey) { //최고값의 키 값과 같다면 넣어줌 비교할 값을 넣어줌
//				System.out.println(k);
				stack.push(k);
				continue;
			}
			//첫번째 값 없으면 키 값을 넣어 줌
			if(left==0) {
				left = k;
				continue;
			}
			//오른쪽 키 값 -> 왼쪽이랑 비교할 값임
			right = k;
			
			//제일 큰 값 기준으로 3개로 분류
			if(map.get(right)<=max) {//max보다 같거나 작으면 left,rigt 비교 왼쪽에서 오른쪽 레이저 쏘는 것
				if(map.get(left)<=map.get(right)) {//왼쪽 값이 같거나 더 작은 경우
					result += map.get(left)*(right-left);
					left = right; //왼쪽 값 갱신
//					System.out.println(left+"//"+result);
				}
			}
		}//end for
//		System.out.println(stack.toString());
		
		/////////맥스값 보다 작은 값들 연산 시작/////////
		if(!stack.isEmpty()) {// 왼쪽 값 세팅
			left = stack.pop(); //key 값을 확인
		}
//		System.out.println(map.get(left));
		while(!stack.isEmpty()) {//비어있지 않다면
			right = stack.pop(); //비교를 위한 right
//			System.out.println(map.get(right));
			
			if(map.get(left)<=map.get(right)) {//왼쪽 값이 같거나 더 작은 경우
				result += map.get(left)*(Math.abs(right-left));
				left = right; //왼쪽 값 갱신
			}
		
		}//max전까지 값들로 모두 더해줌
		//마지막에 max값과 떨어진 거리만큼 더해줌
//		System.out.println(left);
		
		//마지막 스택 값에서 기둥이 되는 곳까지 넓이 더해줌
		result += map.get(left)*(Math.abs(maxKey-left));
		result+=max;//기둥이 되는 점 더해줌
		System.out.println(result);
	}
}
