import java.io.*;
import java.util.*;

public class BJ_14003_가장긴증가하는부분수열5 {
    public static int N;
    public static int[] data;
    public static int result;
    public static int[] LIS;
    public static int [] dp; // index = 길이. 해당 길이의 제일 마지막 인덱스를 저장
    public static int [] before; // data의 이전 값의 index를 저장

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        result = 0;
        LIS = new int[N];
        dp = new int[N];
        before = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        LIS[0] = data[0];
        before[0] = -1;

        for(int i= 1; i < N; i++){
            if(data[i]>LIS[result]){
                result++;
                LIS[result] = data[i];
                dp[result] = i;
                before[i] = dp[result-1];
            }else if(data[i] <=LIS[result]){
                int idx = binarySearch(0,result,data[i]);
                if(idx == 0){
                    dp[0] = i;
                    before[i] = -1;
                }else{
                    dp[idx] = i;
                    before[i] = dp[idx-1];
//                    System.out.println(dp[idx-1]);
//                    System.out.println("dp: "+dp[idx] + " i:"+i);
                }
                LIS[idx] = data[i];
//                if(idx == result){
//                }
            }
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(before));
        int sort[] = new int[result+1];
        StringBuilder sb = new StringBuilder();
        String s = "";
        int index = dp[result];
        for(int i = result; i >=0 ; i--){
            sort[i] = index;
//            sb.insert(0,data[index]+" ");
//            s = data[index] + " " +s;
            index = before[index];
//            System.out.println(index);
        }
        for(int i = 0; i <= result; i++){
            sb.append(data[sort[i]]).append(" ");
        }
        System.out.println(result+1);
        System.out.println(sb);
    }

    public static int binarySearch(int left, int right, int num){
        int mid;
        while(left <right){
            mid = (left+right)/2;
            if(LIS[mid] >=num){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}
