package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_1572_중앙값 {
    public static int[] data;
    public static long[] segment;
    public static int[] center;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        data = new int[N+1];
        int max = 0;
        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,data[i]);
        }
        int segSize = 4*max;
        segment = new long[segSize];
        center = new int[segSize];

        int left = 1;
        int right = K;
        long sum = 0;
        for(int i = left; i <= right; i++){
            addCenter(1,0,max,data[i]);
        }

        int target = (K+1)/2;
        while(true){
            int value = getCenter(1,0,max,target);
//            System.out.println("value: "+value);
//            System.out.println(Arrays.toString(center));
            sum += value;
            removeCenter(1,0,max,data[left]);
            left++;
            right++;
            if(right > N) break;
            addCenter(1,0,max,data[right]);
        }
        System.out.println(sum);
    }

    public static int getCenter(int index, int start, int end, int target){
        if(start == end){
            return start;
        }

        int mid = (start+end)/2;
        //기본적으로 왼쪽이 개수가 더 많을 수 밖에 없는데 그 개수가 target보다 작아지면 오른쪽에 값이 위치한다는 것임
        if(target <= center[index*2]){ // 왼쪽 자식의 개수가 중앙 값의 개수(순서)보다 크면 왼쪽으로
            return getCenter(index*2,start,mid,target);
        }else{ // 중앙 값의 개수가 왼쪽보다 커지면 오른쪽으로 보내야 함. (N+1)/2가 중앙값이라서 그럼.
            // 왼쪽으로 안갔으니 그만큼 개수 빼주고 탐색함. 왼쪽은 중앙값보다 작으니까 중앙값 자체가 바뀌는 것임
            return getCenter(index*2+1,mid+1,end,target-center[index*2]);
        }
    }

    public static void addCenter(int index,int start, int end, int target) {
        while(true){
            center[index]++;
            if(start == end && start == target) break;
            int mid = (start+end)/2;
            if(target <= mid){
                index*=2;
                end = mid;
            }else{
                index = index*2+1;
                start = mid+1;
            }
        }
    }



    public static void removeCenter(int index,int start, int end, int target) {
        while(true){
            center[index]--;

            if(start == end && start == target) break;
            int mid = (start+end)/2;
            if(target <= mid){
                index*=2;
                end = mid;
            }else{
                index = index*2+1;
                start = mid+1;
            }
        }
    }


}
