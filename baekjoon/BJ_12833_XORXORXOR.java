package AlgoStudy;

import java.io.*;
import java.util.*;

public class BJ_12833_XORXORXOR {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		C = C%2;
		
		for(int i = 0; i <C; i++) {
			A = A^B;
		}
		System.out.println(A);
	}

}
