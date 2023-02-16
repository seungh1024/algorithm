import java.io.*;
import java.util.*;

public class BJ_4386_별자리만들기 {
    public static int N;
    public static ArrayList<Star>[] stars;
    public static double[][] point;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stars = new ArrayList[N+1];
        point = new double[N][2];
        for(int i = 0; i <= N; i++){
            stars[i] = new ArrayList<>();
        }
        StringTokenizer st;
        double x,y,nx,ny,xx,yy,length;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            point[i][0] = x;
            point[i][1] = y;
            for(int j = 0; j < i; j++){
                nx = point[j][0];
                ny = point[j][1];
                xx = Math.abs(x-nx);
                yy = Math.abs(y-ny);
                xx = xx*xx;
                yy = yy*yy;
                length = Math.sqrt(xx+yy);
                stars[i].add(new Star(j,length));
                stars[j].add(new Star(i,length));
            }
        }
        System.out.format("%.2f",mst());

    }
    public static double mst(){
        double result = 0;
        int cnt = 0;
        PriorityQueue<Star> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        pq.offer(new Star(0,0));

        while(!pq.isEmpty()){
            Star now = pq.poll();
            if(visited[now.to]) continue;
            cnt++;
            visited[now.to] = true;
            result += now.length;
            if(cnt == N)break;
            for(Star next:stars[now.to]){
                if(!visited[next.to]){
                    pq.offer(next);
                }
            }
        }
        return result;
    }
    public static class Star implements Comparable<Star>{
        int to;
        double length;
        public Star(int to, double length){
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Star o){
            if(this.length - o.length < 0){
                return -1;
            }else if(this.length == o.length){
                return 0;
            }else{
                return 1;
            }
        }
    }
}
