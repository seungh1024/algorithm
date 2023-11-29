package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_2263_트리의순회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inOrder = new int[n+1]; // 루트 기준으로 왼쪽 오른쪽으로 분할되어 있음.
        int[] postOrder = new int[n+1]; // 끝 인덱스가 루트임

//        init(inOrder,postOrder,n,br);
        init2(inOrder,postOrder,n,br);

        StringBuilder sb = new StringBuilder();
//        find(inOrder,postOrder,0,n-1, 0,n-1, sb);
        find2(inOrder,postOrder,1,n, 1,n, sb);
        System.out.println(sb);
    }

    private static void init(int[] inOrder, int[] postOrder, int n, BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void init2(int[] inOrder, int[] postOrder, int n, BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int input = Integer.parseInt(st.nextToken());
            inOrder[input] = i; // postOrder의 값으로 바로 인덱스를 찾을 수 있도록 한다.
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void find(int[] inOrder, int[] postOrder,int start, int end, int pStart, int pEnd, StringBuilder sb) {
        if(pStart > pEnd) return;
        sb.append(postOrder[pEnd]).append(" ");
        if(start >= end ) return;

        for(int i = start; i <= end; i++){
            if(inOrder[i] == postOrder[pEnd]){
                int leftCount = i-start;
                int rightCount = end-i;
//                System.out.println("start: "+start + ", end: "+end +", i: "+i);
//                System.out.println("pStart: "+pStart + ", pEnd:"+pEnd);
                find(inOrder,postOrder,start,i-1,pStart,pStart+leftCount-1,sb);
                find(inOrder,postOrder,i+1,end,pStart+leftCount,pStart+leftCount+rightCount-1,sb);
            }
        }
    }

    private static void find2(int[] inOrder, int[] postOrder,int start, int end, int pStart, int pEnd, StringBuilder sb) {
        if(pStart > pEnd) return;
        sb.append(postOrder[pEnd]).append(" ");
        if(start >= end ) return;

        int mid = inOrder[postOrder[pEnd]];
//        System.out.println(mid);
        int leftCount = mid-start;
        int rightCount = end-mid;
        find2(inOrder,postOrder,start,mid-1,pStart,pStart+leftCount-1,sb);
        find2(inOrder,postOrder,mid+1,end,pStart+leftCount,pStart+leftCount+rightCount-1,sb);
    }
}
