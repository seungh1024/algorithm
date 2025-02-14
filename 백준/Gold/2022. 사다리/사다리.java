import java.io.*;
import java.util.*;

public class Main {
	public static double x,y, c;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());

		find();
	}

	public static void find() {
		double start = 0;
		double end = Math.min(x,y);

		while (start + 0.001 <= end) {
			double mid = (start + end) / 2;

			double h1 = Math.sqrt(x * x - mid * mid);
			double h2 = Math.sqrt(y * y - mid * mid);
			double target = h1 * h2 / (h1 + h2);

			if (c > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		System.out.println(String.format("%.3f",start));
	}
}