package algo_202311.kakaointern2020;

import java.util.*;

public class P_경주로건설 {
    public static void main(String[] args) {
        P_경주로건설 test = new P_경주로건설();
        int[][] board= {
            {0,0,1,0},
            {0,0,0,0},
            {0,1,0,1},
            {1,0,0,0}
        };
        int result = 2100;
        int answer = test.solution(board);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }

    public int solution(int[][] board) {

        int answer = find(board);
        return answer;
    }

    public static int find(int[][] board){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int r = board.length;
        int c = board[0].length;

        // int result = Integer.MAX_VALUE;

        boolean[][][] visited = new boolean[r][c][4];

        Queue<Car> pq = new PriorityQueue<>();
        pq.offer(new Car(0,0,0,0)); // 오른쪽 방향 보며 시작
        pq.offer(new Car(0,0,2,0)); // 아래 방향 보며 시작

        int result = 0;
        while(!pq.isEmpty()){
            Car now = pq.poll();

            if(visited[now.x][now.y][now.d]) continue;
            visited[now.x][now.y][now.d] = true;

            // System.out.println(now);

            if(now.x == r-1 && now.y == c-1){
                result = now.price;
                break;
            }

            for(int d = 0; d < 4; d++){
                int nx = now.x+dx[d];
                int ny = now.y+dy[d];
                if(nx>=0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny][d] && board[nx][ny] == 0){
                    int price = 100;
                    if(now.d != d) price += 500;
                    pq.offer(new Car(nx,ny,d,now.price+price));
                }
            }
        }




        return result;
    }

    public static class Car implements Comparable<Car>{
        int x,y,d,price;

        public Car(int x, int y, int d, int price){
            this.x = x;
            this.y = y;
            this.d = d;
            this.price = price;
        }

        @Override
        public int compareTo(Car c){
            return this.price - c.price;
        }

        @Override
        public String toString(){
            return "x: "+x+", y: "+y +",d: "+d +", price: "+price;
        }
    }
}
