package algo_202311;

import java.io.*;
import java.util.*;

public class P_코딩테스트공부 {
    public static void main(String[] args) {
        P_코딩테스트공부 test = new P_코딩테스트공부();
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};
        int result = 15;
        if (result == test.solution(alp, cop, problems)) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        int size = problems.length;
        Problem[] datas = new Problem[size+2];
        for(int i = 0; i < size; i++){
            int[] input = problems[i];

            maxAlp = Math.max(maxAlp, input[0]);
            maxCop = Math.max(maxCop, input[1]);

            if(input[2] == 0 && input[3] == 0) continue;
            Problem p = new Problem(input[0],input[1],input[2],input[3],input[4]);

            datas[i] = p;
        }
        datas[size] = new Problem(0,0,0,1,1);
        datas[size+1] = new Problem(0,0,1,0,1);


        int answer = makeAnswer(alp,cop,maxAlp,maxCop,datas);

        return answer;
    }

    public static int makeAnswer(int alp, int cop, int maxAlp, int maxCop, Problem[] datas){
        if(alp > maxAlp){
            alp = maxAlp;
        }
        if(cop > maxCop){
            cop = maxCop;
        }
        boolean[][] visited = new boolean[maxAlp+1][maxCop+1];
        Queue<Problem> pq = new PriorityQueue<>();
        pq.offer(new Problem(alp,cop,0,0,0));

        int[][] totalCost = new int[maxAlp+1][maxCop+1];
        for(int i = 0; i <= maxAlp; i++){
            Arrays.fill(totalCost[i],Integer.MAX_VALUE);
        }
        totalCost[alp][cop] = 0;

        while(!pq.isEmpty()){
            Problem now = pq.poll();

            if(now.alp == maxAlp && now.cop == maxCop){
                break;
            }

            // 더하면서 150이 넘을 수 있으니까 안넘도록 설정
            int minAlp = Math.min(maxAlp, now.alp);
            int minCop = Math.min(maxCop, now.cop);



            if(visited[minAlp][minCop]) continue;
            visited[minAlp][minCop] = true;

            // System.out.println(now);

            for(Problem next : datas){
                if(next.alp > minAlp || next.cop > minCop) continue;

                int nextAlp = Math.min(maxAlp, minAlp+next.alpRwd);
                int nextCop = Math.min(maxCop, minCop+next.copRwd);
                if(!visited[nextAlp][nextCop] && totalCost[nextAlp][nextCop] > totalCost[minAlp][minCop] + next.cost){

                    totalCost[nextAlp][nextCop] = totalCost[minAlp][minCop]+next.cost;
                    pq.offer(new Problem(nextAlp,nextCop,0,0,totalCost[nextAlp][nextCop]));
                }
            }
        }

        return totalCost[maxAlp][maxCop];
    }

    public static class Problem implements Comparable<Problem>{
        int alp,cop, alpRwd, copRwd, cost;

        public Problem(int alp, int cop, int alpRwd, int copRwd, int cost){
            this.alp = alp;
            this.cop = cop;
            this.alpRwd = alpRwd;
            this.copRwd = copRwd;
            this.cost = cost;
        }

        @Override
        public int compareTo(Problem p){
            return this.cost - p.cost;
        }

        @Override
        public String toString(){
            return "alp: "+alp + ", cop: "+cop + ", cost: "+cost;
        }

    }
}

