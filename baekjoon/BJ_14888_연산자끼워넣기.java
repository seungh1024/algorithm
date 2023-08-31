package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_14888_연산자끼워넣기 {
    public static int N;
    public static int[] data;
    public static int[] operation;
    public static int maxValue, minValue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        operation = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4; i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }

        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
        find(0,data[0]);
        System.out.println(maxValue);
        System.out.println(minValue);
    }
    public static void find(int index,  int sum){
        if(index == N-1){
//            System.out.println("sum: "+sum);
//            System.out.println(Arrays.toString(operation));
            maxValue = Math.max(maxValue,sum);
            minValue = Math.min(minValue,sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operation[i] > 0){
                operation[i]--;
                find(index+1,calculation(sum,index+1,i));
                operation[i]++;
            }
        }
    }
    public static int calculation(int sum , int index, int i){
        int returnValue = 0;
//        System.out.println("sum: "+sum + ", index: "+index + ", i:"+i);
        if(i == 0){
            returnValue= sum + data[index];
        }else if(i == 1){
            returnValue= sum - data[index];
        }else if(i == 2){
            returnValue= sum * data[index];
        }else if(i == 3){
            returnValue= sum / data[index];
        }
        return returnValue;
    }
}
