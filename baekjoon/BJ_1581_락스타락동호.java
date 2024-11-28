package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_1581_락스타락동호 {
	public static int FF, FS, SF, SS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		FF = Integer.parseInt(st.nextToken());
		FS = Integer.parseInt(st.nextToken());
		SF = Integer.parseInt(st.nextToken());
		SS = Integer.parseInt(st.nextToken());

		int result = 0;
		boolean f = false;
		boolean s = false;
		if (FF > 0 || FS > 0) {
			if (FF > 0 && FS == 0) {
				result += FF;
			} else if (FF == 0 && FS > 0) {
				result += 1;
				FS -= 1;

				if (SS > 0) {
					result += SS;
				}

				if (SF > 0) {
					result += 1;
					SF -= 1;
					int min = Math.min(FS, SF);
					result += min * 2;
					FS -= min;
					SF -= min;

					if (FS > 0) {
						result += 1;
					}
				}

			} else if (FF > 0 && FS > 0) {
				result += FF;
				result += 1;
				FS -= 1;

				if (SS > 0) {
					result += SS;
				}

				if (SF > 0) {
					result += 1;
					SF -= 1;
					int min = Math.min(FS, SF);
					result += min * 2;
					FS -= min;
					SF -= min;

					if (FS > 0) {
						result += 1;
					}
				}

			}
		} else {
			result += SS;
			if (SF > 0) {
				result += 1;
			}
		}

		System.out.println(result);

	}
}
