import java.io.*;
import java.util.*;

public class BJ_1167_트리의지름 {
    public static int V,start;
    public static ArrayList<Point>[] data;
    public static boolean[] parentCheck;
    public static int[] childCheck;
    public static int result;

    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        data = new ArrayList[V+1];
        for(int i = 1; i <= V; i++){
            data[i] = new ArrayList<>();
        }
        parentCheck = new boolean[V+1];
        childCheck = new int[V+1];
        StringTokenizer st;
        int parent,child,weight;
        for(int i = 0 ; i < V; i++){
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            while(true){
                child = Integer.parseInt(st.nextToken());
                if(child == -1) break;
                weight = Integer.parseInt(st.nextToken());
                data[parent].add(new Point(child,weight));
                parentCheck[parent] = true;
                childCheck[child]++;
            }
        }

        start = 0;
        for(int i = 1; i <= V; i++){
            if(parentCheck[i] && childCheck[i] ==1){
                start = i;
                break;
            }
        }
        visited = new boolean[V+1];
//        System.out.println(Arrays.toString(parentCheck));
//        System.out.println(Arrays.toString(childCheck));

        dfs(start);
        System.out.println(result);
    }

    public static int dfs(int node){
        int size = data[node].size();
        if(size ==0) return 0;
        visited[node] = true;

        int index = 0;
        int[] weightValue = new int[size];
        for(Point next : data[node]){
            if(!visited[next.to]){
//                System.out.println(next.to);
                weightValue[index] = next.weight +dfs(next.to);
                index++;
            }
        }
        Arrays.sort(weightValue);

        if(size > 1){
            result = Math.max(result, weightValue[size-1] + weightValue[size-2]);
        }else{
            result = Math.max(result, weightValue[size-1]);
        }

        return weightValue[size-1];
    }

    public static class Point{
        int to, weight;
        public Point(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
