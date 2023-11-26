package algo_202311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_4803_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int time = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 &&m == 0) break;


            int[] parent = new int[n+1];
            initParent(parent,n);
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                unionParent(parent,a,b, set);
            }


            int count = 0;

            for(int i = 1; i <= n; i++){
                int p = getParent(parent,i);
                if(parent[p] == i){
                    count++;
                }
            }

//            System.out.println(set);
//            System.out.println("parent: " + Arrays.toString(parent));
            sb.append("Case ").append(time);
            time++;
            if(count == 0){
                sb.append(": No trees.");
            }else if(count == 1){
                sb.append(": There is one tree.");
            }else{
                sb.append(": A forest of ").append(count).append(" trees.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void initParent(int[] parent, int n){
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }

    public static int getParent(int[] parent, int index){
        if(index == parent[index]) return index;

        return parent[index] = getParent(parent,parent[index]);
    }

    public static void unionParent(int[] parent, int a, int b, Set<Integer> set){
        int pa = getParent(parent,a);
        int pb = getParent(parent,b);

        if(pa < pb) parent[pb] = pa;
        else if(pa == pb) {
//            set.add(pa);
            parent[pa] = 0;
            parent[pb] = 0;
        }
        else parent[pa] = pb;
    }
}

//6 7
//4 5
//5 6
//6 5
//1 2
//2 3
//3 1
//1 4
//0 0

//6 6
//4 5
//5 6
//6 5
//1 2
//2 3
//3 1
//0 0