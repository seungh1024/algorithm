package algo_202405;

import java.io.*;
import java.util.*;
public class BJ_1283_단축키지정 {
	public static int N;
	public static boolean[] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new boolean[30];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			String[] data = input.split(" ");

			boolean fit = true;

			int dataLength = data.length;
			boolean dataCheck = false;
			int dataIndex = 0;
			for (int j = 0; j < dataLength; j++) {
				char[] array = data[j].toLowerCase().toCharArray();
				int target = array[0]-'a';
				if (!check[target]) {
					check[target] = true;
					dataCheck = true;
					dataIndex = j;
					break;
				}
			}

			if (dataCheck) {
				for (int j = 0; j < dataLength; j++) {
					if (dataIndex == j) {
						char[] array = data[j].toCharArray();
						int length = array.length;
						sb.append("[").append(array[0]).append("]");
						for (int k = 1; k < length; k++) {
							sb.append(array[k]);
						}
						sb.append(" ");
					} else {
						sb.append(data[j]).append(" ");
					}
				}
				sb.append("\n");
				continue;
			}
			// ----------- 첫글자 찾기 end

			boolean flag = false;
			int index = 0;

			for(String s : data){
				if (flag) {
					sb.append(s).append(" ");
					continue;
				}
				char[] array = s.toLowerCase().toCharArray();
				int length = array.length;
				for (int j = 0; j < length; j++) {
					int target = array[j]-'a';
					if (!check[target]) {
						flag = true;
						check[target] = true;
						index = j;
						break;
					}
				}

				if (flag) {
					for (int j = 0; j < length; j++) {
						if (j == index) {
							sb.append("[").append(s.charAt(j)).append("]");
						} else {
							sb.append(s.charAt(j));
						}
					}
					sb.append(" ");
				} else {
					for (int j = 0; j < length; j++) {
						sb.append(s.charAt(j));
					}
					sb.append(" ");
				}
			}

			// --------- 중간 단어 찾기 end

			// if (flag) {
			// 	System.out.println("?");
			// 	for (String s : data) {
			// 		sb.append(s).append(" ");
			// 	}
			// 	System.out.println(sb);
			// }
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
