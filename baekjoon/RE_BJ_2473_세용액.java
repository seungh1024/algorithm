package algo_202310;

import java.io.*;
import java.util.*;

public class RE_BJ_2473_세용액 {
    public static int N;
    public static long[] data;
//    public static int left, right;
    public static long[] result;
    public static long check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
//        System.out.println(Arrays.toString(data));

        result = new long[3];
        check = Long.MAX_VALUE;

        int leftSize = N-2;
        int rightSize = N;

        for(int i = 0; i < leftSize; i++){
            for(int j = i+2; j < rightSize; j++){
                makeValue(i,j);
            }
        }

        System.out.println(result[0]+" "+result[1]+" "+result[2]);


    }

    public static void makeValue(int start, int end){
        int left = start;
        int right = end;
        long value = data[start]+data[end];
        long midValue = data[(start+end)/2];
//        long midValue = 0;
        long min = value+midValue;
        start++;
        end--;
        while(start< end){
            int mid = (start+end)/2;
            long sum = value + data[mid];
            long abs = Math.abs(sum);

            if(abs == 0){
                min = 0;
                midValue = data[mid];
                break;
            }
            else if(abs<min){
                min = abs;
                midValue = data[mid];
            }

            if(sum < 0){
                start = mid+1;
            }else if(sum > 0){
                end = mid-1;
            }
        }

//        System.out.println(min);
//        System.out.println("left: "+ left + ", right: "+ right);
        long abs = Math.abs(min);
        long sum = value +data[start];
        if(Math.abs(sum) < abs){
            abs = Math.abs(sum);
            midValue = data[start];
        }


        if(abs < check){
            check = abs;
            result[0] = data[left];
            result[1] = midValue;
            result[2] = data[right];
        }
    }
}
//-38915640
//-382436
