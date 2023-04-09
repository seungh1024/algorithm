package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2470_두용액 {
    public static int N;
    public static int[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new int[N];
        for(int i = 0; i <N;i ++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
//        System.out.println(Arrays.toString(data));
        find();
    }

    public static void find(){
        int left = 0;
        int right = N-1;
        int li = 0;
        int ri = N-1;
        int min = Integer.MAX_VALUE;
        while(left<right){
            int num = data[left]+data[right];
            if(Math.abs(num) < min){
                min = Math.abs(num);
                li = left;
                ri = right;
            }
            if(num == 0){
                li = left;
                ri = right;
                break;
            }else if(num < 0){
                left++;
            }else if(num > 0){
                right --;
            }
        }
        System.out.println(data[li]+" "+data[ri]);
    }

}
