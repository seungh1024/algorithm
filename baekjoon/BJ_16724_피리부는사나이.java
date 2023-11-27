package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_16724_피리부는사나이 {
    public static Map<Character,Integer> map;
    public static int[] parent;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1}; // U, D, L, R
    public static int[][] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        init(N,M);
        for(int i = 1; i <= N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 1; j <= M; j++){
                int d = map.get(input[j-1]); // 이동 인덱스
//                System.out.println("d: "+d);
                int a = data[i][j];
//                System.out.println("i: "+i+", j: "+j + ", ni: "+(i+dx[d]) + ", nj: "+(j+dy[d]));
                int b = data[i+dx[d]][j+dy[d]];
                unionParent(a,b);
            }
        }

        Set<Integer> set = new HashSet<>();
        int size = N*M;
        for(int i = 1; i <= size; i++){
            getParent(i);
            set.add(parent[i]);
        }

        System.out.println(set.size());
    }

    public static int getParent(int index){
        if(index == parent[index]) return index;
        return parent[index] = getParent(parent[index]);
    }

    public static void unionParent(int a, int b){
        int pa = getParent(a);
        int pb = getParent(b);

        if(pa < pb){
            parent[pb] = pa;
        }else{
            parent[pa] = pb;
        }
    }

    public static void init(int N, int M){
        map = new HashMap<>();
        map.put('U',0);
        map.put('D',1);
        map.put('L',2);
        map.put('R',3);

        int size = N*M;
        parent = new int[size+1];
        for(int i = 1; i <= size; i++){
            parent[i] = i;
        }

        data = new int[N+1][M+1];
        int input = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                data[i][j] = input++;
            }
        }

    }
}
