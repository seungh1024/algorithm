package 22_02_11.Bronze 1_14696_딱지놀이;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] result = new int[N];//정답을 기록 A,B,D
		StringTokenizer st;
		for(int i = 0; i <N; i++) {
			//A입력
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int[] cardA = new int[5];
			cardA = cardCheck(A,st);
			
			//B입력
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int[] cardB = new int[5];
			cardB = cardCheck(B,st);
//			System.out.println(Arrays.toString(cardA));
			
			StringBuilder sb = new StringBuilder();
			for(int c = 4; c >=0; c --) {
				if(cardA[c] > cardB[c]) {
					sb.append('A');
					break;
				}else if(cardA[c] < cardB[c]) {
					sb.append('B');
					break;
				}
			}
			
			if(sb.length()>0) {
				System.out.println(sb);
			}else {
				System.out.println('D');
			}
		}
		
		
	}
	
	//카드 담을 배열,
	public static int[] cardCheck(int n, StringTokenizer st) {
		int[] card = new int[5]; //리턴할 카드개수 담은 배열
		//카드 개수만큼 반복해서 카운트
		for(int a = 0; a < n; a++) {
			card[Integer.parseInt(st.nextToken())]++;
		}
		return card;
	}

}