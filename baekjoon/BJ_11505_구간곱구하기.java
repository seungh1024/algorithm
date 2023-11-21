package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_11505_구간곱구하기 {
    public static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] data = new long[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = Long.parseLong(br.readLine());
        }

        int sectionSize = 4*N;
        long[] sectionInfo = new long[sectionSize];
        initSection(1,N,1,data,sectionInfo);

        int length = M+K;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1){
                changeData(1,1,N,b,c,sectionInfo);
//                System.out.println(Arrays.toString(sectionInfo));
            }else if(a == 2){
                sb.append(getInfo(1,1,N,b,c,sectionInfo)).append("\n");
            }
//            System.out.println("data: "+Arrays.toString(data));
        }
        System.out.println(sb);

    }
    public static void changeData(int node, int start, int end, int index, int number, long[] sectionInfo){
        if(start == end){
            sectionInfo[node] = number;
            return;
        }

        int mid = (start+end)/2;
        if(start <= index && index <= mid){
            changeData(node*2,start,mid,index,number,sectionInfo);
        }else if(mid < index && index <= end){
            changeData(node*2+1,mid+1,end,index,number,sectionInfo);
        }

        sectionInfo[node] = (sectionInfo[node*2] * sectionInfo[node*2+1])%mod;
    }

    public static long getInfo(int index, int start, int end, int left, int right, long[] sectionInfo){
        if(right < start || end < left) return 1;

        if(left <= start && start <= right && left <= end && end <= right){
            return sectionInfo[index];
        }


        int mid = (start+end)/2;

        return (getInfo(index*2,start,mid,left,right,sectionInfo) * getInfo(index*2+1,mid+1,end,left,right,sectionInfo))%mod;

    }

    public static long initSection(int start, int end,int index, long[] data, long[] sectionInfo) {
        if(start == end){
            sectionInfo[index] = data[start];
            return sectionInfo[index];
        }

        int mid = (start +end) / 2;
        sectionInfo[index] = (initSection(start,mid, index * 2, data,sectionInfo) * initSection(mid + 1, end, index*2+1,data,sectionInfo))%mod;

        return sectionInfo[index];
    }
}
