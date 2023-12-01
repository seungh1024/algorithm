package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_1208_부분수열의합2 {
    public static Map<Integer,Long> map = new HashMap<>();
    public static int[] data;
    public static int N, S;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        makeKey(0,N/2,0); // 왼쪽 부분들 부분 수열 합을 구해서 map에 넣어준다.
//        map.remove(0);
//        System.out.println(map);
        result = 0;
        find(N/2,N,0);
        if(S == 0) result--;
        System.out.println(result);
    }

    public static void find(int index, int end, int sum) {
        if (index == end) {
            if (map.containsKey(S-sum)) {
                result += map.get(S-sum);
//                System.out.println("sum: "+sum);
//                System.out.println(result);
            }
            return;
        }

        find(index + 1, end, sum + data[index]);
        find(index + 1, end, sum);
    }

    public static void makeKey(int index, int end, int sum) {
        if (index == end) {
            if (map.containsKey(sum)) {
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1L);
            }
            return;
        }

        makeKey(index+1,end,sum+data[index]); // 선택한 경우
        makeKey(index+1,end,sum); // 선택하지 않은 경우
    }
}
