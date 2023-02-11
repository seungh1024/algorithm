import java.io.*;
import java.util.*;

public class BJ_3176_도로네트워크 {
    public static int N,K,D;
    public static ArrayList<Road>[] data;
    public static int[] depth;
    public static boolean[] visited;
    public static int[][] parent;
    public static int[][] min;
    public static int[][] max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new ArrayList[N+1];
        depth = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = new ArrayList<>();
        }
        D = 1;
        for(int i = 1; i <= N; i*=2){
            D++;
        }
        parent = new int[N+1][D];
        min = new int[N+1][D];
        max = new int[N+1][D];
//        for(int i = 0; i <= N; i++){
//            Arrays.fill(min[i],Integer.MAX_VALUE);
//        }

        StringTokenizer st;
        int a,b,c;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            data[a].add(new Road(b,c));
            data[b].add(new Road(a,c));
        }


        dfs(1,0);
        connecting();
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(parent[i]));
//        }
//        System.out.println("/////////////");
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(min[i]));
//        }
//        System.out.println("/////////////");
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(max[i]));
//        }

        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            lca(a,b);

        }
    }
    public static class Road{
        int to,weight;
        public Road(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public static void dfs(int road, int deep){
        visited[road] = true;
        depth[road] = deep;
        for(Road next: data[road]){
            if(visited[next.to]) continue;
            parent[next.to][0] = road;
            min[next.to][0] = next.weight;
            max[next.to][0] = next.weight;
            dfs(next.to,deep+1);

        }
    }
    public static void connecting(){
        for(int i = 1; i < D; i++){
            for(int j = 1; j <= N; j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
                min[j][i] = Math.min(min[j][i-1],min[parent[j][i-1]][i-1]);
                max[j][i] = Math.max(max[j][i-1],max[parent[j][i-1]][i-1]);
            }
        }
    }
    public static void lca(int a, int b){
        if(depth[a]<depth[b]){
            int tmp = b;
            b = a;
            a = tmp;
        }

        int minvalue = Integer.MAX_VALUE;
        int maxvalue = 0;

        for(int i = D-1; i >= 0; i--){
            int jump = 1 << i;
            if(depth[a]-depth[b] >= jump){
                minvalue = Math.min(minvalue, min[a][i]);
                maxvalue = Math.max(maxvalue,max[a][i]);
                a = parent[a][i];
            }
        }
        if(a == b){
            System.out.println(minvalue + " "+ maxvalue);
            return;
        }
        for(int i = D-1; i >=0; i--){
            if(parent[a][i] == parent[b][i]) continue;
            minvalue = Math.min(minvalue, Math.min(min[a][i],min[b][i]));
            maxvalue = Math.max(maxvalue,Math.max(max[a][i],max[b][i]));
            a = parent[a][i];
            b = parent[b][i];
        }
//        System.out.println("asdfadsf: "+minvalue + " "+maxvalue);
        minvalue = Math.min(minvalue,Math.min(min[a][0],min[b][0]));
        maxvalue = Math.max(maxvalue,Math.max(max[a][0],max[b][0]));
        System.out.println(minvalue+" "+maxvalue);
    }


}
