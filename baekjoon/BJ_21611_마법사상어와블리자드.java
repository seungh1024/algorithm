package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_21611_마법사상어와블리자드 {
    public static int N,M;
    public static int[][] data;
    public static ArrayList<Point> list; // 번호대로 좌표 넣은 리스트
    public static int[] ix = {0,1,0,-1};
    public static int[] iy = {-1,0,1,0};
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int size;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        initList();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int cnt = blizard(d,s); // 파괴된 수
//            System.out.println("break;");
//            printData();
            move(cnt);
//            printData();
            while(true){
                cnt = bomb();
                if(cnt == 0) break;
//                printData();
                move(cnt);
//                printData();
            }
//            printData();
            change();
//            printData();
        }
        System.out.println(result);
    }
    public static void change(){
        ArrayList<Integer> next = new ArrayList<>();
        int length = 0;
        int cnt = 0;
        for(int i = 1; i < size; i++){
            Point last = list.get(i-1);
            Point now = list.get(i);
            if(data[now.x][now.y] == 0) break;
            if(data[last.x][last.y] == data[now.x][now.y] && data[last.x][last.y] != 0){
                cnt++;
            }else{
                if(cnt > 0){
                    next.add(cnt+1);
                    next.add(data[last.x][last.y]);
                    length += cnt+1;
                }else{
                    next.add(1);
                    next.add(data[last.x][last.y]);
                    length++;
                }
                cnt= 0;
            }
        }

        if(cnt > 0){
//            System.out.println("zz");
            next.add(cnt+1);
            length += cnt+1;
            Point now = list.get(length-1);
            next.add(data[now.x][now.y]);
        }else if(cnt == 0 &&length > 0){
            next.add(1);
            length++;
            Point now = list.get(length-1);
            next.add(data[now.x][now.y]);
        }
//        System.out.println("length: "+length);

        int idx = 0;
        for(Integer i : next){
//            System.out.println("next:"+i);
            if(idx == size) break;
            Point p = list.get(idx);
            data[p.x][p.y] = i;
            idx++;
        }
        for(int i = idx; i <size; i++){
            Point p = list.get(i);
            data[p.x][p.y] = 0;
        }


    }
    public static int bomb(){
        ArrayList<Point> remove = new ArrayList<>();
        int total = 0;
        int cnt = 0;
        for(int i = 1; i < size; i++){
            Point last = list.get(i-1);
            Point now = list.get(i);
            if(data[last.x][last.y] == data[now.x][now.y] && data[last.x][last.y] != 0){
                cnt++;
            }else{
                if(cnt >= 3){
                    for(int c = i-cnt-1; c < i; c++){
                        remove.add(list.get(c));
                    }
                }
                cnt = 0;
            }
        }
        if(cnt >= 3){
            for(int c = size-cnt-1; c < size; c++){
                remove.add(list.get(c));
            }
        }
        for(Point p :remove){
            int x = p.x;
            int y = p.y;
            result += data[x][y];
            data[x][y] = 0;
            total++;
        }
        return total;
    }
    public static void move(int cnt){
//        for(int i = 0; i < cnt; i++){
//            for(int l = 1; l < size; l++){
//                Point last = list.get(l-1);
//                Point now = list.get(l);
//                if(data[last.x][last.y] == 0){
//                    data[last.x][last.y] = data[now.x][now.y];
//                    data[now.x][now.y] = 0;
//                }
//            }
//        }
        ArrayList<Integer> number = new ArrayList<>();
        int length = 0;
        for(int i = 0; i < size; i++){
            Point now = list.get(i);
            if(data[now.x][now.y] != 0){
                number.add(data[now.x][now.y]);
                length++;
            }
        }
        for(int i = 0; i < length; i++){
            Point now = list.get(i);
            data[now.x][now.y] = number.get(i);
        }
        for(int i = length; i < size; i++){
            Point now = list.get(i);
            data[now.x][now.y] = 0;
        }

    }
    public static int blizard(int d, int s){
        int x = N/2;
        int y = N/2;
        int cnt = 0;
        for(int i = 0; i < s; i++){
            int nx = x+dx[d];
            int ny = y +dy[d];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                data[nx][ny] = 0;
                x = nx;
                y = ny;
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }
    public static void initList(){
        int d = 0;
        int x = N/2;
        int y = N/2;
        boolean[][] visited = new boolean[N][N];
        visited[x][y]= true;
        list = new ArrayList<>();
        while(true){
            int nx = x+ix[d];
            int ny = y+iy[d];
            if(nx >= 0 && nx < N && ny >= 0 && ny <N){
                list.add(new Point(nx,ny));
                visited[x][y] = true;
                x = nx;
                y = ny;
                size++;
            }else{
                break;
            }
            nx = nx +ix[(d+1)%4];
            ny = ny +iy[(d+1)%4];
            if(!visited[nx][ny]){
                d = (d+1)%4;
            }
        }
//        for(Point p : list){
//            System.out.println(p);
//        }
    }

    public static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "x : "+ x + ", y: "+y;
        }
    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("=====================");
    }
}

//0 0 0 0 0 0
//3 2 1 3 2 3
//2 1 2 1 2 1
//2 1 1 0 2 1
//3 3 2 3 2 1
//3 3 3 1 3 3