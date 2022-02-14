package 22_02_10.Bronze 2_2309_일곱 난쟁이;
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] data;
	static boolean[] check;
	static boolean end = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		data = new int[7];
		check = new boolean[9];
		for(int i = 0; i <9; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		combination(0,0,0);
		
//		for(int i = 0; i < 7; i++) {
//			System.out.println(data[i]);
//		}
	}
	
	public static void combination(int cnt,int index,int sum) {
		if(index == 9 || cnt == 7 || data[6] != 0) {
//			int n = 0;
			if(end) {
				return;
			}
			if(sum == 100) {				
				for(int i = 0; i < 9; i++) {
					if(check[i]) {
						System.out.println(list.get(i));
					}
				}
//				System.out.println(Arrays.toString(check));
				end = true;
			}
			return;
		}
		
		
		check[index] = true;
//		System.out.println(index);
		combination(cnt+1,index+1,sum+list.get(index));
		check[index] = false;
		combination(cnt,index+1,sum);
		
		
	}
}