import java.io.*;
import java.util.*;

public class BJ_16234_인구이동 {
    public static int N,L,R;
    public static int[][] data;
    public static boolean[][] visited; //하루동안 방문하는 나라 체크
    public static boolean check = false;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static ArrayList<int[]> movePoint;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while(true){
            find();
            if(check) break;
            result++;
        }

        System.out.println(result);

    }

    public static void find(){
        boolean findCheck = false;
        visited = new boolean[N][N];
        int nx,ny;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    boolean startBfs = false;

                    for(int d = 0; d < 4; d++){
                        nx = i + dx[d];
                        ny = j + dy[d];
                        if(nx >= 0 && nx < N && ny >= 0 && ny <N && !visited[nx][ny]
                                && Math.abs(data[nx][ny] - data[i][j]) >= L
                                && Math.abs(data[nx][ny] - data[i][j]) <= R){
                            startBfs = true;
                            break;
                        }
                    }

                    if(startBfs){
                        if(bfs(i,j)){
                            findCheck = true;
                        }
                    }else{
                        visited[i][j] = true;
                    }

                }
            }
        }
//        System.out.println("////////////////////");
        if(findCheck){
            check = false;
        }else{
            check = true; //국경 열기 실패 -> 다들 차이가 없는 것
        }
    }

    public static boolean bfs(int x, int y){
//        System.out.println(x + ","+y);
        boolean[][] bfsCheck = new boolean[N][N]; //근처 국가 방문 체크
        movePoint = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        int cnt = 0; // 합친 나라 수
        int people = 0; //사람 수 합

        int nx,ny;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];
                if(nx>=0 && nx < N && ny >= 0 && ny <N && !visited[nx][ny] && !bfsCheck[nx][ny] && Math.abs(data[nx][ny] - data[now[0]][now[1]]) >= L && Math.abs(data[nx][ny] - data[now[0]][now[1]]) <= R){
                    people += data[nx][ny];
                    cnt ++;
                    visited[nx][ny] = true;
                    bfsCheck[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    movePoint.add(new int[]{nx,ny});
//                    System.out.println("nx: "+nx + ", ny : "+ny);
                }
            }
        }

        if(cnt>0){
            move(people,cnt,bfsCheck);
//            System.out.println(x + ", " + y+ ", " + data[x][y]+" /// "+people + " ," +cnt);
//            printData();
//            System.out.println("//////////////////////");
            return true;
        }
        return false;
    }

    public static void move(int people, int cnt, boolean[][] bfsCheck){
        int num = people/cnt;
        for(int[] next : movePoint){
            if(bfsCheck[next[0]][next[1]]){
                data[next[0]][next[1]] = num;
                cnt --;
            }
            if(cnt == 0){
                return;
            }
        }
    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }
}
