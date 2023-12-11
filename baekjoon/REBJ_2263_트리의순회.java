package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_2263_트리의순회 {
    public static int[] inOrder;
    public static int[] postOrder;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inOrder = new int[N+1];
        postOrder = new int[N+1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st1.nextToken());
            inOrder[input] = i;
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        find(1,N,1,N,sb);
        System.out.println(sb);
    }

    public static void find(int is, int ie, int ps, int pe, StringBuilder sb) {
        int target = postOrder[pe];
        sb.append(target).append(" ");
        if (is == ie || ps == pe) {
            return;
        }
        int mid = inOrder[postOrder[pe]];
        int leftSize = mid-is;
        int rightSize = ie - mid;
//        System.out.println("inIndex: "+inIndex + ", leftSize: "+leftSize + ", rightSize: "+rightSize);
//        System.out.println(sb);
        if (leftSize > 0) {
            find(is,mid-1,ps,ps+leftSize-1,sb);
        }
        if (rightSize > 0) {
            find(mid+1,ie,ps+leftSize,ps+leftSize+rightSize-1,sb);
        }
    }
}
