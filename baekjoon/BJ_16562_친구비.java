package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_16562_친구비 {
    public static int[] pay;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        init(br.readLine(),N);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            unionParent(v,w);
        }


        for(int i = 1; i <= N; i++){
            getParent(i);
        }
//        System.out.println(Arrays.toString(pay));
//        System.out.println(Arrays.toString(parent));
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++){
            set.add(parent[i]);
        }
        int sum = 0;
        for(int i : set){
            sum += pay[i];
        }

        if(sum > k){
            System.out.println("Oh no");
        }else{
            System.out.println(sum);
        }
    }

    public static int getParent(int index){
        if(index == parent[index]) return index;

        return parent[index] = getParent(parent[index]);
    }

    public static void unionParent(int a, int b){
        int pa = getParent(a);
        int pb = getParent(b);

        if(pay[pa] <pay[pb]){
            pay[pb] = pay[pa];
            parent[pb] = pa;
        }else{
            pay[pa] = pay[pb];
            parent[pa] = pb;
        }
    }

    public static void init(String input, int N){
        StringTokenizer st = new StringTokenizer(input);
        pay = new int[N+1];
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }
    }
}
