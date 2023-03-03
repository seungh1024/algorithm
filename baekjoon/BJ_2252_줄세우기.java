import java.io.*;
import java.util.*;

public class BJ_2252_줄세우기 {
    public static int N,M;
    public static ArrayList<Integer>[] data;
    public static int [] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N+1];
        data = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data[a].add(b);
            count[b] ++;
        }

        run();

    }

    public static void run(){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i =1 ; i <= N; i++){
            if(count[i] ==0){
                queue.offer(i);
                sb.append(i).append(" ");
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : data[now]){
                count[next] --;
                if(count[next] == 0){
                    queue.offer(next);
                    sb.append(next).append(" ");
                }
            }
        }

        System.out.println(sb);
    }
}
