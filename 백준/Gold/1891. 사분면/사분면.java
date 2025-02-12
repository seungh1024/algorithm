import java.io.*;
import java.util.*;

public class Main {
	public static long d;
	public static char[] input;
	public static long px,py;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Long.parseLong(st.nextToken());
		input = st.nextToken().toCharArray();
		st = new StringTokenizer(br.readLine());
		px = Long.parseLong(st.nextToken());
		py = Long.parseLong(st.nextToken());



		long x = 0;
		long y = 0;

		long n = d;
		for (char c : input) {
			n--;
			long size = (long)Math.pow(2, n);
			if (c == '2') {

			} else if (c == '1') {
				y += size;
			}else if(c == '3'){
				x += size;
			} else if (c == '4') {
				x+=size;
				y+=size;
			}

			// System.out.println("x = "+x +", y = "+ y + ", size = "+size);
		}

		x -= py;
		y += px;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < d; i++) {
			long range = (long)Math.pow(2, d - i);
			long half = range/2;

			// System.out.println("range = "+range +", half = "+half);

			if (x >= 0 && x < half && y >= 0 && y < half) {
				sb.append(2);
			} else if (x >= 0 && x < half && y >= half && y < range) {
				sb.append(1);
				y -= half;
			} else if (x >= half && x < range && y >= 0 && y < half) {
				sb.append(3);
				x -= half;
			} else if(x >= half && x < range && y >= half && y < range){
				sb.append(4);
				x -= half;
				y -= half;
			}
		}

		if (sb.length() == d) {
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}
}