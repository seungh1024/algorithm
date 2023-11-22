package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_2357_최솟값과최댓값세그 {
    public static int[] data;
    public static int[] maxSegment;
    public static int[] minSegment;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        data = new int[N+1];

        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        int segSize = 4*N;
        maxSegment = new int[segSize];
        minSegment = new int[segSize];
        Arrays.fill(minSegment,Integer.MAX_VALUE);
        initSegment(1,1,N);


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getMin(1,1,N,a,b)).append(" ").append(getMax(1,1,N,a,b)).append("\n");
        }
        System.out.println(sb);
    }

    public static int getMin(int index,int start, int end, int left, int right){
        if(start>right || end < left) return Integer.MAX_VALUE;


        if(left<=start && start <= right && left <= end && end <= right){
            return minSegment[index];
        }

        int mid = (start + end)/2;
        int a = getMin(index*2,start,mid,left,right);
        int b = getMin(index*2+1,mid+1,end,left,right);

        return Math.min(a,b);
    }

    public static int getMax(int index, int start, int end, int left, int right){
        if(start>right || end < left) return 0;

        if(left<=start && start <= right && left <= end && end <= right){
            return maxSegment[index];
        }
        int mid = (start + end)/2;
        int a = getMax(index*2,start,mid,left,right);
        int b = getMax(index*2+1,mid+1,end,left,right);

        return Math.max(a,b);
    }

    public static void initSegment(int index, int start, int end){
        if(start == end){
            maxSegment[index] = data[start];
            minSegment[index] = data[start];
            return;
        }
        int mid = (start+end)/2;

        initSegment(index*2,start,mid);
        initSegment(index*2+1,mid+1,end);
        maxSegment[index] = Math.max(maxSegment[index*2],maxSegment[index*2+1]);
        minSegment[index] = Math.min(minSegment[index*2], minSegment[index*2+1]);
    }
}
