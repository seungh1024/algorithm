package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_1572_중앙값 {
    public static int[] segment;
    public static int[] data;
    public static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N+1];
        int maxTemp = 0;
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(br.readLine());
            maxTemp = Math.max(maxTemp,data[i]);
        }

        int size = 4*maxTemp;
        segment = new int[size];

        for (int i = 1; i < K; i++) {
            changeValue(1,data[i],1,0,maxTemp);
        }


        long result = 0;
        int lastIndex = 1;
        int target = (K+1)/2;
        for (int i = K; i <= N; i++) {
            changeValue(1, data[i], 1, 0, maxTemp);
            result += (long)getCenter(1,0,maxTemp,target);
            changeValue(1, data[lastIndex], -1, 0, maxTemp);
            lastIndex++;
        }
        System.out.println(result);
    }

    public static int getCenter(int index, int start, int end, int target) {
        if (start == end) {
            return start;
        }

        int mid = (start+end)/2;
        int left = segment[index*2];
//        int right = segment[index*2+1];

        if (target <= left) {
            return getCenter(index * 2, start, mid, target);
        } else {
            return getCenter(index*2+1,mid+1,end,target-left);
        }

    }
    public static void changeValue(int index, int target, int value, int start, int end) {
        segment[index] += value;
        if (start == end) {
            return;
        }
        int mid = (start+end)/2;

        if (target <= mid) {
            changeValue(index*2,target,value,start,mid);
        } else if (target > mid) {
            changeValue(index*2 + 1, target, value, mid+1, end);
        }
    }
}
