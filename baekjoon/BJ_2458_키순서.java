import java.io.*;
import java.util.*;

public class BJ_2458_키순서 {
    public static int N,M;
    public static int[] count;
    public static ArrayList<Integer>[] bottom;
    public static ArrayList<Integer>[] top;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N+1];
        bottom = new ArrayList[N+1];
        top = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            bottom[i] = new ArrayList<>();
            top[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bottom[b].add(a);
            top[a].add(b);
        }


        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            dfs(i,true);
//            System.out.println("i: "+i);
//            System.out.println(Arrays.toString(count));
            visited = new boolean[N+1];
            dfs(i,false);
//            System.out.println(Arrays.toString(count));
//            System.out.println("//////////////////");
        }

        int result = 0;
        for(int i = 1; i <= N; i++){
            if(count[i] == N-1){
                result++;
            }
        }
//        System.out.println(Arrays.toString(count));
        System.out.println(result);
    }

    public static void dfs(int num, boolean check){
        if(check){
            for(int next:bottom[num]){
                if(!visited[next]){
                    visited[next] = true;
                    count[next]++;
                    dfs(next,check);
                }
            }
        }else{
            for(int next:top[num]){
                if(!visited[next]) {
                    visited[next] = true;
                    count[next]++;
                    dfs(next, check);
                }
            }
        }
    }
}
