package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_17825_주사위윷놀이 {
    public static int[][] map = {{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
                                {0,0,0,0,0,0,0,0,0,0,0,0,0,10,13,16,19,25,30,35,40},
                                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,22,24,25,30,35,40},
                                {0,0,0,0,0,0,0,0,0,0,0,0,0,30,28,27,26,25,30,35,40}};

    public static int[] data;
    public static Point[] points;
    public static int[] choices;
    public static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new int[10];
        for(int i = 0; i <10; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        choices = new int[10]; // 10개의 주사위를 어떤 말들이 선택하는지
        makeChoices(0);
        movePoint();
        System.out.println(result);
    }

    public static void makeChoices(int idx){ // 재귀호출로 4개중에 하나가 선택하도록
        //10개 선택시 루프 탈출 & 말 이동하기
        if(idx == 10){
            movePoint();
            return;
        }

        //makeChoices(~~) 0번말 선택
        choices[idx] = 0;
        makeChoices(idx+1);
        //makeChoices(~~) 1번말 선택
        choices[idx] = 1;
        makeChoices(idx+1);
        //makeChoices(~~) 2번말 선택
        choices[idx] = 2;
        makeChoices(idx+1);
        //makeChoices(~~) 3번말 선택
        choices[idx] = 3;
        makeChoices(idx+1);

    }


    /**
     * 말 이동하기
     */
    public static void movePoint(){
        int moveIndex = 0;
        points = new Point[4]; // 말은 4개
        for(int i = 0; i < 4; i++){
            points[i] = new Point(0,0);
        }

        for(int pointNum : choices){ // 움직일 말 번호
            if(points[pointNum].done){ // 이미 도착한거 또 고르면 리턴
                return;
            }

            points[pointNum].y += data[moveIndex];
            moveIndex++;
            if(points[pointNum].y > 20) {
                points[pointNum].done = true;
                continue;
            }
            int plus = map[points[pointNum].x][points[pointNum].y];

            points[pointNum].plusSum(plus);
            if(points[pointNum].y == 5){
                points[pointNum].x = 1;
                points[pointNum].y = 13;
            }else if(points[pointNum].x == 0 && points[pointNum].y == 10){
                points[pointNum].x=2;
                points[pointNum].y = 14;
            }else if(points[pointNum].x == 0 && points[pointNum].y == 15){
                points[pointNum].x=3;
                points[pointNum].y = 13;
            }
            if((points[pointNum].x >0 && points[pointNum].y >= 17 && points[pointNum].y <= 20) || points[pointNum].y==20){
                points[pointNum].x = 3;
            }


            for(int i = 0; i < 4; i++){ // 다른애들이랑 비교해서 겹치는지 확인
                if(i != pointNum && (points[pointNum].y < 21 && points[i].x == points[pointNum].x && points[i].y == points[pointNum].y)){
                    return;
                }
            }

        }
        int scores = 0;
        for(Point p : points){
            scores += p.sum;
        }
        result = Math.max(result,scores);
    }

    public static class Point{
        int x,y,sum;
        boolean done;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
            this.sum = 0;
            this.done = false;
        }

        public void plusSum(int value){ // sum더해주는 메소드
            this.sum+=value;
        }
    }
}
