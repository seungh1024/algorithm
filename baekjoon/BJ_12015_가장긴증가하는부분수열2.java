package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_12015_가장긴증가하는부분수열2 {
    public static int N;
    public static int[] data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        data[0] = Integer.parseInt(st.nextToken());
        int index = 0;
        for(int i = 1; i < N; i++){
            int input = Integer.parseInt(st.nextToken());
            if(input > data[index]){
                index++;
                data[index] = input;
            }else if(input == data[index]){
                continue;
            }else{
                find(0,index,input);
            }
//            System.out.println(Arrays.toString(data));
        }
        System.out.println(index+1);
    }

    public static void find(int start, int end,int num){
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
//            System.out.println("?");
            if(data[mid] > num){
                end = mid;
            }else if(data[mid] == num){
                data[mid] = num;
                break;
            }else{
                start = mid+1;
            }
        }
        mid = (start+end)/2;
        data[mid] = num;
    }
}
