package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1253_좋다 {
    public static int N;
    public static Map<Integer,Integer> map;
    public static Map<Integer,Integer> mapCnt;
    public static Point[] data;
    public static int result;
    public static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        mapCnt = new HashMap<>();
        data = new Point[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = 0;
        int num = 0;
        for(int i = 0; i < N; i++){
            input = Integer.parseInt(st.nextToken());
            num = 0;
            if(map.get(input) != null){
                num = map.get(input);
            }
            num++;
//            System.out.println("num: "+num);
            map.put(input,num);
            mapCnt.put(input,num);
            data[i] = new Point(input,Math.abs(input));
        }
        Arrays.sort(data);
//        System.out.println(Arrays.toString(data));
        result = 0;
        if(N <2){
            System.out.println(0);
        }else{
            find();
            System.out.println(result);
        }
    }
    public static class Point implements Comparable<Point>{
        int num,abs;
        public Point(int num , int abs){
            this.num = num;
            this.abs = abs;
        }
        @Override
        public int compareTo(Point o){
            return this.abs - o.abs;
        }
        public String toString(){
            return "num: "+ num;
        }
    }
    public static void find(){
        result = 0;
        for(int i = 0; i < N-1; i++){
            int left = data[i].num;
            for(int j = i+1; j < N; j++){
                int right = data[j].num;
                int sum = left+right;
//                System.out.println("sum: "+sum + ", left: "+left +", right: "+right);
                if(map.get(sum) != null){
                    int numCnt = map.get(sum);

                    if(numCnt>0 && sum != left && sum != right){
                        result+=numCnt;
                        numCnt = 0;
                    }else if(numCnt>0 && sum ==left && sum != right){
                        if(mapCnt.get(left)!= null && mapCnt.get(left)>1){
                            result+=numCnt;
                            numCnt = 0;
                        }

                    }else if(numCnt>0 && sum == right && sum != left){
                        if(mapCnt.get(right) != null && mapCnt.get(right)>1){
                            result+=numCnt;
                            numCnt = 0;
                        }

                    }else if(numCnt>0 && sum == right && sum == left){
                        if(mapCnt.get(left) != null && mapCnt.get(left)>2){
                            result+=numCnt;
                            numCnt = 0;
                        }
                    }
                    map.put(sum,numCnt);
                }
            }
        }

    }
}
