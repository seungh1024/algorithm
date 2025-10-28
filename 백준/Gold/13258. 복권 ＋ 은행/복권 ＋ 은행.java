

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] data = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Double.parseDouble(st.nextToken());
		}
		double J = Integer.parseInt(br.readLine());
		double C = Integer.parseInt(br.readLine());

		double num = data[0];
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += data[i];
		}

		double result = num + (num*J*C)/sum;
		System.out.println(result);
	}
}
