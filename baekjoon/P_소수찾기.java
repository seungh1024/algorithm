package algo_202304;

import java.io.*;
import java.util.*;

public class P_소수찾기 {
    public static int N;
    public static int[] data;
    public static int[] pick;
    public static boolean[] visited;
    public static Set<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        N = input.length;
        data = new int[N];
        for(int i = 0; i < N; i++){
            data[i] = input[i]-'0';
        }

        pick = new int[N];
        visited = new boolean[N];
        set = new HashSet<>();
        for(int i = 1; i <=N; i++){
            find(0,i);
        }
        int result = 0;
        for(int num : set){
            if(checkNumber(num)){
                result++;
            }
        }
        System.out.println(result);

    }

    public static void find(int idx, int n){
        if(idx == n){
//            System.out.println("n: "+n+", pick: "+Arrays.toString(pick));
            makeNumber(n);
        }

        for(int i = 0; i < N; i++){
            if(idx == 0 && data[i] == 0) continue;
            if(!visited[i]){
                visited[i] = true;
                pick[idx] = data[i];
                find(idx+1,n);
                visited[i] = false;
            }
        }
    }

    public static void makeNumber(int n){
        int number = 0;
        int a = 1;
//        System.out.println("nn: "+n + ", ");
        for(int i = 0; i < n; i++){
            number += a*pick[i];
            a*=10;
        }
        if(number >1){
            set.add(number);
        }
    }

    public static boolean checkNumber(int number){
//        System.out.println("number: "+number);
        int sqrt = (int)Math.sqrt(number);
        for(int i = 2; i <= sqrt; i++){
            if(number%i == 0){
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
}
