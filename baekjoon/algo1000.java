package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo1000 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		String A = st.nextToken();
		String B = st.nextToken();
		
		System.out.println(Integer.parseInt(A)+Integer.parseInt(B));
	}
}
