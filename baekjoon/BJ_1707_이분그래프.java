import java.io.*;
import java.util.*;

public class BJ_1707_이분그래프 {
    public static int K,V,E,start;
    public static ArrayList<Integer>[] data;
    public static boolean[] visited;
    public static int[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            data = new ArrayList[V+1];
            for(int i = 1; i <= V; i++){
                data[i] = new ArrayList<>();
            }
            int a,b;
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                data[a].add(b);
                data[b].add(a);
                start = a;
            }
//            visited = new boolean[V+1];
            String result = "YES";
            check = new int[V+1];
            for(int i = 1; i <= V; i++){
                if(check[i] == 0){
                    if(dfs(i,1)){
                        result = "YES";
                    }else{
                        result = "NO";
                        break;
                    }
                }
//            System.out.println(Arrays.toString(check));
            }
            System.out.println(result);
        }
    }

    public static boolean dfs(int node, int isSame){
//        visited[node] = true;
//        if(check[node] == isSame) return false;
        check[node] = isSame;

        for(int next :data[node]){
            if(check[node] == check[next]) {
//                System.out.println("node: "+ node+", "+check[node] + " , "+ check[next]);
                return false;
            }else if(check[next] == 0){
//                System.out.println("node: "+ node+", "+check[node] + " , "+ check[next]);
                if(!dfs(next,isSame * -1)){
                    return false;
                }
//                return true;
            }

        }
        return true;
    }
}
