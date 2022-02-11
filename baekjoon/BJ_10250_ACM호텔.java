package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10250_ACM호텔 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); //호텔의 높이
			int W = Integer.parseInt(st.nextToken()); //각 층의 방 수
			int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님인지
			
			int front = N%H; //몇 층인지
			int back = N/H+1; //몇 호인지
			
			StringBuilder sb = new StringBuilder();
			
			if(front == 0) {
				sb.append(H);
				back-=1;
			}else {				
				sb.append(front);
			}
			if(back<10) {
				sb.append("0").append(back);
			}else {
				sb.append(back);
			}
			
			System.out.println(sb);
		} 

	}

}
