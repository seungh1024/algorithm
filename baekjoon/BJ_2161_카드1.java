package 22_02_08.Bronze 1_2161_카드1;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while(true) {
			System.out.print(queue.poll()+" ");
			
			if(!queue.isEmpty()) {				
				queue.offer(queue.poll());
			}else {
				break;
			}
		}
	}

}