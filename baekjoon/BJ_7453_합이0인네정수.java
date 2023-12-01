package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_7453_합이0인네정수 {
    public static long[] array1,array2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }
        int size = n*n;
        array1 = new long[size+1];
        array2 = new long[size+1];
        array1[size] = Integer.MAX_VALUE;
        array2[size] = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array1[index] = A[i]+B[j];
                array2[index] = C[i]+D[j];
                index++;
            }
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));
        long result = 0;
        for(int i = 0; i <size; i++){
            result += find(array2,size,array1[i]);
        }
        System.out.println(result);
    }

    public static long find(long[] array, int n, long target) {
        int start = 0;
        int end = n;

        while (start < end) {
            int mid = (start+end)/2;

            if (array[mid] + target > 0) {
                end = mid;
            } else if (array[mid] + target <= 0) {
                start = mid+1;
            }
        }
        long right = end;

        start = 0;
        end = n;
        while (start < end) {
            int mid = (start + end)/2;

            if(array[mid] + target >= 0){
                end = mid;
            } else if (array[mid] + target < 0) {
                start = mid+1;
            }
        }

        long left = end;

//        System.out.println("right: "+right + ", end: "+end);
//        if(right == n-1) right++;

        return right-left;
    }
}
