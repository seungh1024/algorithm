package algo_202311;

import java.io.*;
import java.util.*;

public class P_등산코스정하기 {
    public static void main(String[] args) {
        P_등산코스정하기 test = new P_등산코스정하기();
        int n = 6;
        int[][] paths = {{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}};
        int[] gates = {1,3};
        int[] summits = {5};
        int[] result = {5,3};
        int[] answer = test.solution(n,paths,gates,summits);
        int answerSize = answer.length;

        for(int i = 0; i < answerSize; i++){
            if(result[i] != answer[i]){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    public static boolean[] isSummits; // 봉우리 확인
    public static boolean[] isGates;
    public static List<Point>[] list; // 경로 저장
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        initStaticData(n,paths, gates, summits);
        find(n, gates, answer);

        return answer;
    }

    public static void find(int n, int[] gates, int[] answer){
        Queue<Point> q = new PriorityQueue<>();
        boolean[] isVisited = new boolean[n+1];

        int[] minIntensity = new int[n+1];
        Arrays.fill(minIntensity, Integer.MAX_VALUE);

        for(int gate : gates){
            q.offer(new Point(gate,0,0));
            minIntensity[gate] = 0;
        }

        long min = Long.MAX_VALUE;
        int summit = 0;
        int intensity = Integer.MAX_VALUE;


        while(!q.isEmpty()){
            Point now = q.poll();

            if(isSummits[now.to]){
                if(intensity > now.intensity){
                    intensity = now.intensity;
                    summit = now.to;
                }else if(intensity == now.intensity){
                    summit = Math.min(summit, now.to);
                }
                continue;
            }

            if(isVisited[now.to]) continue;
            isVisited[now.to] = true;

            for(Point next : list[now.to]){
                if(!isVisited[next.to] && minIntensity[next.to] > next.weight){
                    minIntensity[next.to] = next.weight;
                    q.offer(new Point(next.to, next.weight, Math.max(next.weight, now.intensity)));

                    // System.out.println("now: "+now);
                    // System.out.println("next: "+next);
                }
            }
        }

        answer[0] = summit;
        answer[1] = intensity;


    }

    public static void initStaticData(int n, int[][] paths, int[] gates, int[] summits){
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            list[path[0]].add(new Point(path[1],path[2],0));
            list[path[1]].add(new Point(path[0],path[2],0));
        }
        isSummits = new boolean[n+1];
        for(int summit : summits){
            isSummits[summit] = true;
        }

        isGates = new boolean[n+1];
        for(int gate : gates){
            isGates[gate] = true;
        }

    }

    public static class Point implements Comparable<Point>{
        int to, weight, intensity;

        public Point(int to, int weight, int intensity){
            this.to = to;
            this.weight = weight;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Point p){
            return this.weight-p.weight;
        }

        @Override
        public String toString(){
            return "to: "+ to + ", weight: "+ weight + ", intensity: " + intensity;
        }
    }
}
