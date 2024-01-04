package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_9656_돌게임2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N % 2 == 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}
