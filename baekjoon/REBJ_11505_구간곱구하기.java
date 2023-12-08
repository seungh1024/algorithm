package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_11505_구간곱구하기 {
    public static long mod = 1000000007;
    public static int N, M, K, S;
    public static long[] data;
    public static long[] segment;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int length = M+K;
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                change(1,b,c,1,N);
            } else if (a == 2) {
                long result = getData(1,b,c,1,N);
                sb.append(result).append("\n");
            }
//            System.out.println(Arrays.toString(segment));
//            System.out.println(Arrays.toString(data));
//            System.out.println("=============");
        }
        System.out.println(sb);
    }

    public static long getData(int index, int from, int to, int start, int end) {
        if (start == end) {
            return segment[index];
        }

        if (from == start && to == end) {
            return segment[index];
        }

        int mid = (start + end)/2;
        long left = 1;
        long right = 1;

//        if (from <= mid) {
//            left = getData(index*2,from,mid,start,mid);
//        } else if (from > mid) {
//            left = getData(index*2+1,from,to,mid+1,end);
//        }
//
//        if (to <= mid) {
//            right = getData(index*2,from,to,start,mid);
//        } else if (to > mid) {
//            right = getData(index*2+1,mid+1,to,mid+1,end);
//        }

        if (to <= mid) {
            left = getData(index * 2, from, to, start, mid);
            right = 1;
        } else if (from <= mid && to > mid) {
            left = getData(index * 2, from, mid, start, mid);
            right = getData(index*2+1,mid+1,to,mid+1,end);
        } else if (from > mid) {
            left = 1;
            right = getData(index*2+1,from,to,mid+1,end);
        }

        return (left*right)%mod;
    }
    public static long change(int index, int target, int num, int start, int end) {
        if (start == end && start == target) {
            segment[index] = num;
            data[target] = num;
            return segment[index];
        }

        int mid = (start +end)/2;
        long left = 0;
        long right = 0;
        if (target <= mid) {
            left = change(index*2,target,num,start,mid);
            right = segment[index*2+1];
        } else if (target > mid) {
            left = segment[index*2];
            right = change(index * 2 + 1, target, num, mid + 1, end);
        }

        return segment[index] = (left*right)%mod;
    }

    public static long initSegment(int index, int start, int end) {
        if (start == end) {
            segment[index] = data[start];
            return data[start];
        }
        int mid = (start+end)/2;
        long left = initSegment(index*2,start,mid);
        long right = initSegment(index*2+1,mid+1,end);
        return segment[index] = (left*right)%mod;
    }

    public static void init(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new long[N+1];
        for (int i = 1; i <= N; i++) {
            data[i] = Long.parseLong(br.readLine());
        }
        S = 4*N;
        segment = new long[S];

        initSegment(1,1,N);
    }
}
