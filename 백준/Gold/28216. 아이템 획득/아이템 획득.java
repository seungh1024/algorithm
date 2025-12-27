

import java.io.*;
import java.util.*;

public class Main {
	public static int N, Q;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static Map<Integer, List<Data>> xmap = new HashMap<>();
	public static Map<Integer, List<Data>> ymap = new HashMap<>();
	public static Map<Integer, List<Long>> xsumMap = new HashMap<>();
	public static Map<Integer, List<Long>> ysumMap = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		xmap = new HashMap<>(); //x 좌표 기준 y 리스트
		ymap = new HashMap<>(); // y 좌표 기준 x 리스트

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			xmap.putIfAbsent(x, new ArrayList<>());
			ymap.putIfAbsent(y, new ArrayList<>());

			List<Data> xlist = xmap.get(x);
			xlist.add(new Data(y, w));

			List<Data> ylist = ymap.get(y);
			ylist.add(new Data(x, w));


		}

		xsumMap = new HashMap<>();
		for (Map.Entry<Integer, List<Data>> entry : xmap.entrySet()) {
			List<Data> list = entry.getValue();
			list.add(new Data(-1000000, 0));
			Collections.sort(list, Comparator.comparingInt(o -> o.idx));
			List<Long> sumList = new ArrayList<>();
			sumList.add(0L);
			int size = list.size();
			for (int i = 1; i < size; i++) {
				long v = sumList.get(i - 1) + list.get(i).w;
				sumList.add(v);
			}
			xsumMap.put(entry.getKey(), sumList);
		}

		ysumMap = new HashMap<>();
		for (Map.Entry<Integer, List<Data>> entry : ymap.entrySet()) {
			List<Data> list = entry.getValue();
			list.add(new Data(-1000000, 0));
			Collections.sort(list, Comparator.comparingInt(o -> o.idx));
			List<Long> sumList = new ArrayList<>();
			sumList.add(0L);
			int size = list.size();
			for (int i = 1; i < size; i++) {
				long v = sumList.get(i - 1) + list.get(i).w;
				sumList.add(v);
			}
			ysumMap.put(entry.getKey(), sumList);
		}

		int x = 1;
		int y = 1;
		int nx = 0;
		int ny = 0;
		long result = 0;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			nx = x+dx[d]*v;
			ny = y+dy[d]*v;

			// System.out.println("x = "+ x + ", y = "+y + ", nx  "+nx +", ny = "+ny);
			switch(d) {
				case 0 ->{
					List<Data> list = ymap.get(ny); // y 좌표 기준 x 리스트 조회 -> x를 훑기 때문
					if(list != null) {
						int left = find(x, list); // 시작점 좌표
						if (list.get(left).idx > x) { // x는 포함하지 않으므로 빼준다
							left--;
						}
						int right = find(nx, list);
						if (list.get(right).idx > nx) { // 이동한 좌표보다 큰 곳은 포함하지 않으므로 빼준다.
							right--;
						}

						List<Long> sumList = ysumMap.get(ny);
						result += sumList.get(right)-sumList.get(left);
					}
				}
				case 1 -> {
					List<Data> list = xmap.get(nx);
					if (list != null) {
						int left = find(y, list);
						if (list.get(left).idx > y) {
							left--;
						}
						int right = find(ny, list);
						if (list.get(right).idx > ny) {
							right--;
						}

						List<Long> sumList = xsumMap.get(nx);
						result += sumList.get(right) - sumList.get(left);
					}
				}
				case 2 -> { // 이동한 nx가 x보다 더 작은 값을 가짐
					List<Data> list = ymap.get(ny); // y 좌표 기준 x 리스트 조회 -> x를 훑기 때문
					if(list != null) {
						int left = find(nx, list); // 시작점 좌표
						if (list.get(left).idx >= nx) { // nx까지 포함해야 하니까 좌표값 같으면 빼줌
							left--;
						}
						int right = find(x, list);
						if (list.get(right).idx >= x) { // x랑 같아도 현재 지점 포함하면 안되니까 빼줌
							right--;
						}

						List<Long> sumList = ysumMap.get(ny);
						result += sumList.get(right)-sumList.get(left);
					}
				}
				case 3 -> {
					List<Data> list = xmap.get(nx);
					if (list != null) {
						int left = find(ny, list);
						if (list.get(left).idx >= ny) {
							left--;
						}
						int right = find(y, list);
						if (list.get(right).idx >= y) {
							right--;
						}

						List<Long> sumList = xsumMap.get(nx);
						result += sumList.get(right) - sumList.get(left);
					}
				}
			}
			x = nx;
			y = ny;
			// System.out.println(result);
		}
		System.out.println(result);
	}

	private static int find(int target, List<Data> list) {
		int start = 1;
		int end = list.size()-1;

		while (start < end) {
			int mid = (start+end)/2;
			Data d = list.get(mid);
			if (d.idx >= target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}


		return start;
	}

	public static class Data{
		int idx;
		int w;

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", w=" + w +
				'}';
		}

		public Data(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}
	}
}
