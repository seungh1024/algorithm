package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식_비트마스킹 {
	static int[] sin;//신맛
	static int[] sun;//쓴맛
	static int result;
	public static void main(String[] args) throws IOException{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sin = new int[N];
		sun = new int[N];
		result = 1000000000;
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			sun[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(sin));
//		System.out.println(Arrays.toString(sun));
		combination(0,0,N,0);
		System.out.println(result);
	}
	
	public static void combination(int cnt,int index ,int N,int flag) {
		if(index==N ) {
			int mulsin = 1;
			int sumsun = 0;
			for(int i = 0; i < N; i++ ) {
				if((flag & 1<<i) != 0) {
					mulsin = mulsin*sin[i];
					sumsun += sun[i];
				}
			}
//			System.out.println(mulsin+"/"+sumsun);
			if(sumsun>0) {
				result = result<Math.abs(mulsin-sumsun)?result:Math.abs(mulsin-sumsun);
			}
			return;
		}
		
		
		combination(cnt+1,index+1,N,flag | 1<<index);
		combination(cnt,index+1,N, flag);
		
	}
}