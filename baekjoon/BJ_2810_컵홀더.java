package day0225;

import java.io.*;
import java.util.*;

public class BJ_2810_컵홀더 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int result = 0;
		int check = 0;
		for(int i = 0; i < N; i++) {
			if(s.charAt(i) == 'L') {
				i++;
				check++;
			}else {
				result++;
			}
		}
		if(check>0) {
			result += check+1;
		}
		
		System.out.println(result);
	}

}
