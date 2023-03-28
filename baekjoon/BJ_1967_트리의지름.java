import java.io.*;
import java.util.*;

public class BJ_1967_트리의지름 {
    public static int N;
    public static ArrayList<Point>[] data;
    public static int result;
    public static ArrayList<Integer> parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = new ArrayList<>();
        }
        parent = new ArrayList<>();

        StringTokenizer st;
        int from,to,weight;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            data[from].add(new Point(to,weight));
            parent.add(from);
        }

        result = 0;
        dfs(1);
        System.out.println(result);
    }

    public static int dfs(int node){
        int size = data[node].size();
        if(size == 0) return 0;

        int check[] = new int[size];
        int index = 0;
        int returnValue = 0;
        int now = 0;
        for(Point child : data[node]){
            now = child.weight + dfs(child.to);
            returnValue = Math.max(returnValue,now);

            check[index] = now;
            index++;
        }
        Arrays.sort(check);

        if(size >= 2){
            result = Math.max(result,check[index-1]+check[index-2]);
        }else{
            result = Math.max(result,check[0]);
        }
        return returnValue;
    }

    public static class Point{
        int to,weight;
        public Point(int to, int weight){
            this.to = to;
            this.weight= weight;
        }
    }
}
