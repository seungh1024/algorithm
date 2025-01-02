package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_2671_잠수함식별 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] data = br.readLine().toCharArray();
		int N = data.length;
		int idx = 0;

		boolean flag = false;
		while (idx < N) {
			if (data[idx] == '1') {
				// System.out.println("1" + ", idx = "+idx);
				if (idx + 2 > N) {
					flag = true;
					break;
				}

				int cnt = 0;
				idx++;
				boolean check1 = false;
				boolean check2 = false;
				while (idx < N && data[idx] == '0') {
					idx++;
					cnt++;
					check1 = true;
				}
				if (cnt < 2) {
					flag = true;
					break;
				}
				while (idx < N && data[idx] == '1') {
					if (check2 && idx + 2 < N && data[idx + 1] == '0' && data[idx+2] == '0') {
						// idx++;
						break;
					}
					check2 = true;
					idx++;
				}
				if (!check1 || !check2) {
					flag = true;
					break;
				}
			} else {
				// System.out.println("0" +", idx = "+idx);
				if (idx + 1 < N && data[idx + 1] == '1') {
					idx += 2;
				} else {
					flag = true;
					break;
				}
			}
		}

		if (!flag) {
			System.out.println("SUBMARINE");
		} else {
			System.out.println("NOISE");
		}
	}
}
