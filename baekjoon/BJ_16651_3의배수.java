import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int count = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine())/3;
		if(n<3) {
			System.out.println(0);
		}
		else {
			int result = 0;
			int count = 1;
			for(int i = 3; i <=n; i++) {
				result +=count;
				count++;
			}
			System.out.println(result);
		}
		

		
//		System.out.println(Arrays.toString(data)); 
//		permutation(0,n,n);
//		System.out.println(count);
	}
	
//	public static void permutation(int cnt,int size,int sum) {
//		if(cnt == 2 ) {//개수 충족시 리턴
////			System.out.println("sum: "+sum);
//			if(sum >0) {				
//				count++;
//			}
//			return;
//		}
//		if(sum<0 || cnt >3) {
//			return;
//		}
//		
//		//중복 있게 반복
//		for(int i =1; i <size; i++) {
//			permutation(cnt+1,size,sum-i);
//		}
//	}

}
//1 3 6 10 15 21