package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_14438_수열과쿼리17 {
    public static int N;
    public static int[] data;
//    public static int[] fenwick;
//    public static int[] reverseFenwick;
    public static int[] segment;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
//        initFenwick();
        initSegment();

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                data[b] = c;
                change(1,b,c,1,N);
//                System.out.println(Arrays.toString(segment));
            } else if (a == 2) {
//                System.out.println("-------------");
                int result = getMin(1,b,c,1,N);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int change(int index, int target, int value, int left, int right) {
        if (left == right) {
            return segment[index] = value;
        }

        int mid = (left +right)/2;
        int lv = segment[index*2];
        int rv = segment[index*2+1];
        if (target <= mid) {
            lv = change(index * 2, target, value, left, mid);
        } else {
            rv = change(index*2+1, target, value,mid+1,right);
        }
        return segment[index] = Math.min(lv,rv);
    }

    public static int getMin(int index, int from, int to, int left, int right) {
        if (left == right) {
//            System.out.println("left:"+left +", index: "+index);
            return segment[index];
        }
        if (from == left && to == right) {
//            System.out.println("from: "+from + ", to: "+to + ", left: "+left + ", right: "+right + ",index: "+index);
            return segment[index];
        }

        int mid = (left +right)/2;
        int lv = Integer.MAX_VALUE;
        int rv = Integer.MAX_VALUE;
        if (from <= mid && mid < to) {
//            System.out.println("lvrv");
            lv = getMin(index*2,from,mid,left,mid);
            rv = getMin(index*2+1,mid+1,to,mid+1,right);
        } else if (to <= mid) {
//            System.out.println("lv");
            lv = getMin(index * 2, from, to, left, mid);
        } else if (mid < from) {
//            System.out.println("rv");
            rv = getMin(index * 2 + 1, from, to, mid + 1, right);
        }
//        System.out.println("lv: "+lv + ", rv: "+rv);

        return Math.min(lv,rv);
    }

    public static void initSegment() {
        segment = new int[4*N];
        dfs(1,1,N);
    }

    public static int dfs(int index, int left, int right ){
        if (left == right) {
            return segment[index] = data[left];
        }
        int mid = (left + right)/2;
        int lv = dfs(index*2,left,mid);
        int rv = dfs(index*2+1,mid+1,right);
        return segment[index] = Math.min(lv,rv);
    }

//    public static void change(int target, int value) {
//        data[target] = value;
//        int f = target;
//        while (f <= N) {
////            System.out.println(f);
////            System.out.println("fenwick: "+fenwick[f]);
//            int size = f - (f & -f);
//            int min = Integer.MAX_VALUE;
//            for (int i = f; i > size; i--) {
//                min = Math.min(min,data[i]);
//            }
//            fenwick[f] = min;
//            f = f + (f & -f);
//        }
//        int rf = target;
//        while (rf > 0) {
//            int size = rf + (rf & -rf);
//            if(size > N) size = N+1;
//            int min = Integer.MAX_VALUE;
//            for (int i = rf; i < size; i++) {
//                min = Math.min(min, data[i]);
//            }
//            reverseFenwick[rf] = min;
//            rf = rf - (rf & -rf);
//        }
////        System.out.println(value);
////        System.out.println(Arrays.toString(fenwick));
////        System.out.println(Arrays.toString(reverseFenwick));
////        System.out.println("-----------");
//    }
//
//
//    public static int getMin(int from, int to) {
//        int result = Integer.MAX_VALUE;
//        int range = from + (from & -from);
//        while (range <= to) {
//            result = Math.min(result, reverseFenwick[from]);
//            from = range;
//            range = from + (from & -from);
//        }
//        result = Math.min(result, data[from]);
//        range = to - (to & -to);
//        while (range >= from) {
//            result = Math.min(result, fenwick[to]);
//            to = range;
//            range = to - (to & -to);
//        }
//        return result;
//    }
//
//    public static void initFenwick() {
//        fenwick = new int[N+1];
//        reverseFenwick = new int[N+1];
//        for (int i = 1; i <= N; i++) {
//            int size = i - (i & -i);
//            int min = Integer.MAX_VALUE;
//            for (int j = i; j > size; j--) {
//                min = Math.min(min,data[j]);
//            }
//            fenwick[i] = min;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            int size = i + (i & -i);
//            if(size > N) size = N+1;
//            int min = Integer.MAX_VALUE;
//            for (int j = i; j < size; j++) {
//                min = Math.min(min,data[j]);
//            }
//            reverseFenwick[i] = min;
//        }
//
////        System.out.println(Arrays.toString(fenwick));
////        System.out.println(Arrays.toString(reverseFenwick));
//    }
}
