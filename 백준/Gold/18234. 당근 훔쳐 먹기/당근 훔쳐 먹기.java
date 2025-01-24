import java.io.*;
import java.util.*;

public class Main {
	public static int N, T;
	public static List<Carrot> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long w = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			list.add(new Carrot(w, p));
		}

		list.sort(Comparator.comparing((Carrot carrot) -> carrot.p));
		long temp = T-N;
		long result = 0;
		for (Carrot carrot : list) {
			// System.out.println(carrot);
			result += carrot.w+(carrot.p*temp);
			temp++;
		}
		System.out.println(result);
	}

	public static class Carrot{
		long w;
		long p;

		public Carrot(long w, long p) {
			this.w = w;
			this.p = p;
		}


		public String toString() {
			return " w = "+w + ", p = "+p;
		}
	}
}