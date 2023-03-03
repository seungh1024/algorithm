import java.io.*;
import java.util.*;

public class BJ_1516_게임개발 {
    public static int N;
    public static int[] time;
    public static ArrayList<Integer>[] data;
    public static int[] minTime;
//    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N+1];
        data = new ArrayList[N+1];
        for(int i =1; i <= N; i++){
            data[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int input = Integer.parseInt(st.nextToken());
                if(input == -1){
                    break;
                }
                data[i].add(input);
            }
        }
//        System.out.println(Arrays.toString(time));

        minTime = new int[N+1];
        for(int i = 1; i <= N; i++){
//            visited = new boolean[N+1];
            find(i);
        }

        for(int i = 1; i <= N; i++){
            System.out.println(minTime[i]);
        }
    }

    public static int find(int num){
//        visited[num] = true;
//        if(minTime[num] != 0){
//            return minTime[num];
//        }
        int minimum = 0; //최소로 소비해야하는 시간
        for(int next:data[num]){
//            if(visited[next]) continue;
            if(minTime[next] != 0){
                minimum = Math.max(minimum,minTime[next]); //오래 걸리는 시간이 최소로 소비해야 하는 시간
//                System.out.println("num: "+num + " next: "+next +" minimum: "+minimum);
            }else{
                minimum = Math.max(minimum, find(next));
            }
        }
        minTime[num] = minimum +time[num];

        return minTime[num];
    }
}
