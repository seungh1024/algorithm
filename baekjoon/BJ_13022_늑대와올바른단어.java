package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_13022_늑대와올바른단어 {
	public static void main(String[] args) throws IOException{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var input = br.readLine().toCharArray();
		int size = input.length;

		Map<Character, Character> lastChar = Map.of('o', 'w', 'l', 'o', 'f', 'l');

		var result = 1;
		var count = 0;
		var index = 0;
		var last = 'w';
		while (index < size) {
			if (input[index] == 'w') {
				count++;
				last = 'w';
				index++;
				// System.out.println(count);
				// System.out.println(index);
			} else {
				var target = input[index];
				// System.out.println("index = "+index);
				// System.out.println("target = "+target);
				// System.out.println("last = " + last + ", real = " + lastChar.get(target));
				if (last != lastChar.get(target)) {
					result = 0;
					break;
				}

				var range = index+count;
				// System.out.println("index = "+index + ", range = "+range);
				var nowCount = 0;
				for (; index < range && index < size; index++) {
					if (target == input[index]) {
						nowCount++;
					} else {
						break;
					}
				}
				if (count != nowCount) {
					result = 0;
					break;
				}
				last = target;
				if (last == 'f') {
					count = 0;
				}
			}
		}

		if (count > 0) {
			result = 0;
		}

		System.out.println(result);

	}

}
