package day0221;

import java.io.*;
import java.util.*;

public class SWEA_1238_Contact_BFS {
	
	static boolean[] check;
	
	public static class Node {
		int data;
		Node link;
		int count;
		
		public Node(int data , Node link) {
			this.data = data;
			this.link = link;
			this.count = 0;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[data : "+data+" link : " +link+ " count : "+count+"]";
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			Node[] nodeSet = new Node[101];
			
			check = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < size/2; i ++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodeSet[from] = new Node(to,nodeSet[from]);
				
			}//end input
			
			
//			for(int i = 0; i < 100; i++) {
//				System.out.println(nodeSet[i]);
//			}
			
			System.out.println("#"+t+ " " + bfs(nodeSet,start));
		}
	}
	
	public static int bfs(Node[] nodeSet, int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start); //출발 값을 넣어줌
		
		int result[] = {-1,-1}; //비교를 위한 result 배열 -> 깊이와 해당 값을 비교를 하기 위함
		int[] cntCheck = new int[101]; //방문한 곳의 깊이를 저장할 cntCehck
		while(!queue.isEmpty()) {
			int from = queue.poll();

			check[from] = true;//방문처리
			
			for(Node temp = nodeSet[from]; temp != null; temp = temp.link) {
				if(!check[temp.data]) {			//방문하지 않았다면
					queue.offer(temp.data);		//큐에 해당 노드의 번호를 넣어줌
					temp.count = cntCheck[from]+1; //해당 노드의 깊이를 이전 출발지의 값에서 +1 한 값으로 세팅
					if(cntCheck[temp.data] == 0) {	//깊이를 기록하는 배열이 0이면 -> 아직 방문한 적 없으면 현재 깊이로 설정 
						//-> 위의 이전 출발지의 깊이 값을 읽어오는데 사용
						cntCheck[temp.data] = temp.count;
					}
					
					if(result[0] < temp.count) { //count가 크면 무조건 temp값으로 세팅
						result[0] = temp.count;
						result[1] = temp.data;
					}else if(result[0] == temp.count) {//count가 같으면 해당하는 data값이 큰 것으로 세팅
						result[1] = result[1]>temp.data?result[1]:temp.data;
					}
					
				}
			}
		}
		
		return result[1];
		
		
	}

}


//#1 17 
//#2 96
//#3 49 
//#4 39 
//#5 49 
//#6 1 
//#7 28 
//#8 45 
//#9 59
//#10 64 

