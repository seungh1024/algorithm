package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_1113_수영장만들기 {
    public static int N,M;
    public static int[][] data;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static boolean[][] outCheck;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                data[i][j] = input[j] - '0';
            }
        }
        outCheck = new boolean[N][M];
        int sx = 0;
        int sy = 0;
        int outline = 2*(N+M) - 4;
        int d = 0;
        for (int i = 0; i < outline; i++) {
            if (!outCheck[sx][sy]) {
                remove(sx,sy);
            }
            sx += dx[d];
            sy += dy[d];
            if (sx < 0 || sx >= N || sy < 0 || sy >= M) { // 범위 벗어나면
                sx -= dx[d];
                sy -= dy[d];
                d++;
                sx += dx[d];
                sy += dy[d];
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(outCheck[i]));
//        }

        int xLength = N-1;
        int yLength = M-1;
        int result = 0;
        for (int t = 1; t < 9; t++) {
            visited = new boolean[N][M];
            for (int i = 1; i < xLength; i++) {
                for (int j = 1; j < yLength; j++) {
                    if (!visited[i][j] && !outCheck[i][j] && data[i][j] == t) {
                        int value = find(i,j);
                        result += value;
//                        System.out.println("t: "+ t + ", i: "+ i +", j: "+j);
//                        printData();
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static int find(int x, int y) {
        int target = data[x][y];
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> list = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        list.offer(new int[]{x,y});

//        visited = new boolean[N][M];
        visited[x][y] = true;
        int min = 10;
        while (!q.isEmpty()) {
            int[] now = q.poll();
//            System.out.println(Arrays.toString(now));
            for (int d = 0; d < 4; d++) {
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (data[nx][ny] != target || outCheck[nx][ny]) {
                        min = Math.min(min, data[nx][ny]);
                    }
                    if (!outCheck[nx][ny] && !visited[nx][ny] && target == data[nx][ny]) {
                        q.offer(new int[]{nx,ny});
                        list.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        int count = 0;
        int plus = min - target;
        if (min != 10 && target < min) {
            while (!list.isEmpty()) {
                int[] now = list.poll();
                data[now[0]][now[1]] = min;
                count++;
            }
        }
//        System.out.println("target: "+target + ", min: "+min);
//        System.out.println(plus);
//        System.out.println(count);
        return count*plus;


    }
    public static void remove(int x, int y) {
        int target = data[x][y];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        outCheck[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !outCheck[nx][ny] && target == data[nx][ny]) {
                    outCheck[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }

    public static void printData() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("================");
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
//1555555555151
//1111111111111