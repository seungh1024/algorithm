package AlgoStudy;

import java.io.*;
import java.util.*;

public class BJ_17419_비트가넘쳐흘러 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String K = br.readLine();
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(K.charAt(i) == '1') {
				count++;
			}
		}

		
		System.out.println(count);
	}

}
