package SWExpertAcademy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Solution_1225_암호생성기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
		//반복 횟수
		for(int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(br.readLine());//test case num
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			//데이터 삽입
			for(int i = 0; i <8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			//암호도출 확인여부 변수
			boolean result = false;
			//0이 나올 때 까지 반복
			while(true) {
				//한 사이클이 8번이니 8번 반복
				for(int i = 1; i <= 5; i++) {
					int check = queue.poll();
					//감소 작업
					check -= i;
					if(check <=0) {
						result = true;
						queue.offer(0);
						break;
					}
					//0보다 크면 그냥 뒤로 다시 넣어줌
					queue.offer(check);
				}//end for
				
				if(result) {
					StringBuilder sb = new StringBuilder();
					sb.append("#").append(test_case).append(" ");
					//값이 있는동안 출력
					while(!queue.isEmpty()) {
						sb.append(queue.poll()).append(" ");
					}
					System.out.println(sb);
					break;//while 탈출
				}
			}//end while
			
		}//end for
	}

}
//1
//9550 9556 9550 9553 9558 9551 9551 9551 
//2
//2419 2418 2423 2415 2422 2419 2420 2415 
//3
//7834 7840 7840 7835 7841 7835 7835 7838 
//4
//4088 4087 4090 4089 4093 4085 4090 4084 
//5
//2945 2946 2950 2948 2942 2943 2948 2947 
//6
//670 667 669 671 670 670 668 671 
//7
//8869 8869 8873 8875 8870 8872 8871 8873 
//8
//1709 1707 1712 1712 1714 1710 1706 1712 
//9
//10239 10248 10242 10240 10242 10242 10245 10235 
//10
//6580 6579 6574 6580 6583 6580 6577 6581 
