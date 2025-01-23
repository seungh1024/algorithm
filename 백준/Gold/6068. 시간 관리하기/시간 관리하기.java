import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Job> list;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new Job(t, s));
		}

		Collections.sort(list, Comparator.comparingInt(o -> o.s));

		int min = Integer.MAX_VALUE;
		int now = 0;

		for (Job job : list) {
			now += job.t;
			if (now > job.s) {
				min = -1;
				break;
			}
			min = Math.min(min, job.s - now);
		}

		System.out.println(min);

	}

	public static class Job{
		int t;
		int s;

		public Job(int t, int s) {
			this.t = t;
			this.s = s;
		}
	}
}