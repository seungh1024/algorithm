package day0223;

import java.io.*;
import java.util.*;

public class BJ_15686_치킨배달 {
	
	static int N;
	static int M;
	static ArrayList<Chicken> chicken = new ArrayList<>();//치킨집 위치 정보
	static ArrayList<House> house = new ArrayList<>(); //가정집 위치 정보
	
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int spot = Integer.parseInt(st.nextToken());
				if(spot == 1) {
					house.add(new House(i,j));
				}else if(spot == 2) {
					chicken.add(new Chicken(i,j));
				}
				map[i][j] = spot;
			}
//			System.out.println(Arrays.toString(map[i]));
		}
//		System.out.println(house.toString());
//		System.out.println(chicken.toString());
		visited = new boolean[chicken.size()];
		//////////end input//////////////
		
		com(0,0,chicken.size());
		System.out.println(result);
	}
	
	public static void bfs(Chicken[] side) {
		
		int sum = 0;
		for(int s = 0,size = house.size(); s < size; s++) {
			Queue<House> queue = new LinkedList<>();
			queue.offer(house.get(s));
			int[] dx = {0,0,1,-1};
			int[] dy = {1,-1,0,0};
			boolean[][] checkMap = new boolean[N][N];
			int[][] chickenMap = new int[N][N];
			for(int c = 0,length = side.length; c<length; c++) {
				chickenMap[side[c].x][side[c].y] = 2;
			}
			
			int count = 0;
		
			while(!queue.isEmpty()) {
				int qSize = queue.size();
				count++;
				for(int q =0; q < qSize; q++) {					
					House now = queue.poll();
					for(int i = 0; i <4; i++) {
						int nx = now.x + dx[i];
						int ny = now.y + dy[i];
						
						if(nx>=0 && nx< N && ny>=0 && ny < N && !checkMap[nx][ny]) {
							checkMap[nx][ny] = true;
							if(chickenMap[nx][ny] == 2) {
								sum += count;
								queue.clear();
								q = qSize-1;
								break;
							}
				
							queue.offer(new House(nx,ny));
							
						}
					}

				}
			}
			if(sum > result) {
				return;
			}
		}
		
		result = Math.min(result, sum);
	}
	
	public static void com(int cnt, int idx, int size) {
		if(cnt == M){
			Chicken[] side = new Chicken[M];
			int cIndex = 0;
			for(int i = 0; i < size; i++) {
				if(visited[i]) {
					side[cIndex] = chicken.get(i);
					cIndex++;
				}
			}
//			System.out.println(Arrays.toString(side));
			int sum = 0;
			for(int i = 0, h = house.size(); i < h; i++) {
				int now = Integer.MAX_VALUE;
				for(int j = 0; j <M ; j++) {
					now = Math.min(now, Math.abs(house.get(i).x-side[j].x)+Math.abs(house.get(i).y-side[j].y));
				}
				sum+= now;
			}
			result = Math.min(result, sum);
//			bfs(side);
			return;
		}
		if(idx == size) {
			return;
		}
		
		visited[idx] = true;
		com(cnt+1,idx+1,size);
		visited[idx] = false;
		com(cnt,idx+1,size);
	}
	
	public static class House{
		int x;
		int y;
		
		public House(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "x : " + x + " y : " + y;
		}
	}
	
	public static class Chicken{
		int x;
		int y;
		
		public Chicken(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "x : " + x + " y : " + y;
		}
	}
}
