package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2467_용액 {
    public static int N;
    public static int[] data;
    public static int rl,rr; // 결과 왼쪽 오른쪽
    public static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        min = Math.abs(data[0] + data[N-1]);
        rl = 0;
        rr = N-1;
        find();
        System.out.println(data[rl] + " "+data[rr]);
    }

    public static void find(){
        int left = 0;
        int right = N-1;
        int sum = 0;
        while(left <right){
            int lv = data[left];
            int rv = data[right];
            sum = lv+rv;
            int abs = Math.abs(sum);
            if(abs < min){
                rl = left;
                rr = right;
                min = Math.abs(sum);
            }else if(sum >= 0){
                right --;
            }else if(sum < 0){
                left ++;
            }
//            System.out.println("right: "+right+", left: "+left);
        }
    }
}
