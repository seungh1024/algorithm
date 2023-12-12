package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_7453_합이0인네정수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int size = N*N;
        int[] AB = new int[size+1];
        int[] CD = new int[size+1];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[index] = A[i]+B[j];
                CD[index] = C[i]+D[j];
                index++;
            }
        }
        AB[size] = Integer.MAX_VALUE;
        CD[size] = Integer.MAX_VALUE;
        Arrays.sort(AB);
        Arrays.sort(CD);
//        System.out.println(Arrays.toString(AB));
//        System.out.println(Arrays.toString(CD));
        long count = 0;
        for (int i = 0; i < size; i++) {
            int target = AB[i];
            int left = findLeft(target,size,CD);
            int right = findRight(target,size,CD);
            count += (long)(right-left);
//            if(right == size-1) count++;
//            System.out.println("i: "+i);
//            System.out.println("right: "+right + ", left: "+left);
        }
        System.out.println(count);
    }

    public static int findLeft(int target, int size, int[] CD) {
        int start = 0;
        int end = size;

        while (start < end) {
            int mid = (start+end)/2;
            if (target + CD[mid] < 0) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static int findRight(int target, int size, int[] CD) {
        int start = 0;
        int end = size;

        while (start < end) {
            int mid = (start+end)/2;
            if (target + CD[mid] <= 0) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
