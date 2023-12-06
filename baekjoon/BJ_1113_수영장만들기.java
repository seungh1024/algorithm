package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_1113_수영장만들기 {
    public static int N,M;
    public static int[][] data;
    public static boolean[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int result;
    public static boolean[] isOut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            return data[o1[0]][o1[1]] - data[o2[0]][o2[1]];
        }));
        visited = new boolean[N][M];
        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                data[i][j] = input[j]-'0';
            }
        }
        int x = 0;
        int y = 0;
        int d = 0;
        int size = (N+M)*2-4;
        if(N == 1 || M ==1){
            size = N*M;
        }
        isOut = new boolean[10];
        for (int i = 0; i < size; i++) {
            remove(x,y);
            isOut[data[x][y]] = true;
            x+=dx[d];
            y+=dy[d];
            if (x < 0 || x >= N || y < 0 || y >= M) {
                x -=dx[d];
                y -=dy[d];
                d++;
                x+=dx[d];
                y+=dy[d];
            }
        }

//        printData();

        result = 0;
        for (int t = 1; t < 9; t++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(visited[i][j]) continue;
                    if (data[i][j] == t) {
                        find(i,j);
                    }
                }
            }
        }
//        printData();
        System.out.println(result);
    }

    public static void find(int x, int y) {
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check[i][j] = visited[i][j];
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> findQ = new ArrayDeque<>();
        int[] start = {x,y};
        q.offer(start);
        findQ.offer(start);
        check[x][y] = true;

        int target = data[x][y];
        boolean overflow = false;
        int min = 10;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!check[nx][ny] && data[nx][ny] == target) {
                        check[nx][ny] = true;
                        int[] next = {nx,ny};
                        q.offer(next);
                        findQ.offer(next);
                    }
                    if(data[nx][ny] < target) overflow = true; // 외부랑 만나면 흘러나감
                    if(data[nx][ny] != target){
                        min = Math.min(min,data[nx][ny]);
                    }
                    if (data[nx][ny] == target && visited[nx][ny]) {
                        min = Math.min(min,data[nx][ny]);
                    }
                }
            }
        }
        if(min == 10)overflow = true;
        if (overflow) { // 넘치니까 visited 처리
            while (!findQ.isEmpty()) {
                int[] now = findQ.poll();
                visited[now[0]][now[1]] = true;
            }
        } else { // 고인물은 최소값만큼 채워줌
            int plus = min - target;
            int count = 0;
            while (!findQ.isEmpty()) {
                int[] now = findQ.poll();
                data[now[0]][now[1]] = min;
                count++;
                if(plus == 0) visited[now[0]][now[1]] = true;
            }
            result+= plus*count;
        }
//        System.out.println("x: "+x+", y: "+y);
//        System.out.println("target: "+ target+ ", min: "+min + ", overflow: "+overflow);
//        System.out.println("result: "+result);
//        printData();
    }



    public static void remove(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;

        int target = data[x][y];
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[] {x,y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && data[nx][ny] == target) {
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void printData() {
        System.out.println("========  data =============");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("========= data end===========");

        System.out.println("========  visited =============");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println("========= visited end===========");
    }
}

//9 13
//1111111111111
//1555555555551
//1511111111151
//1511199911151
//1511192911151
//1511199911151
//1511111111151
//1555555515551
//1511111111151