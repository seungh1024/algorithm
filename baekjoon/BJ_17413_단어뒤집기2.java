package day0216;

import java.io.*;
import java.util.*;

public class BJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		char[] data = br.readLine().toCharArray();
		
		boolean check = false;
		for(char c : data) {
			if(c == ' ') {
				result.append(sb+" ");
				sb.setLength(0);
			}
			else if(c == '<') {
				sb.append(c);
				check = true;
			}else if(c == '>') {
				sb.append(c);
				result.append(sb);
				sb.setLength(0);
				check = false;
			}else {				
				if(check) {
					sb.append(c);
				}else {
					sb.insert(0, c);
				}
			}
			
		}
		result.append(sb);
		
		System.out.println(result);
	}

}
