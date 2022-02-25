package day0225;

import java.io.*;
import java.util.*;

public class BJ_8320_직사각형을만드는방법 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[n+1];
		
		int result = 0;
		
		for(int i = 1; i <=n; i++) {
			int length = (int)Math.sqrt(i);
			for(int j = 1; j <=length; j++) {
				if(i%j == 0) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
