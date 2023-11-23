package algo_202311.kakaorecruitment2023;

import java.util.*;

public class P_이모티콘할인행사 {
    public static void main(String[] args) {
        P_이모티콘할인행사 test = new P_이모티콘할인행사();
        int[][] users = {{40,10000},{25,10000}};
        int[] emoticons = {7000,9000};
        int[] result = {1,5400};
        int[] answer = test.solution(users, emoticons);
        if(Arrays.equals(result,answer)) System.out.println("success");
        else System.out.println("fail");
    }
    public static int totalCount, totalMoney;
    public static int E;
    public int[] solution(int[][] users, int[] emoticons) {

        E = emoticons.length;
        totalCount = 0;
        totalMoney = 0;
        int[] array = new int[E];
        find(0,array,users, emoticons);

        int[] answer = {totalCount,totalMoney};

        return answer;
    }

    public static void find(int index, int[] array, int[][] users, int[] emoticons){
        if(index == E){
            int sum = 0;
            int count = 0;

            for(int[] user : users){
                int dis = user[0];
                int money = user[1];
                int buy = 0;
                for(int e = 0; e < E; e++){
                    if(array[e]*10 >= dis){
                        buy += (emoticons[e]/10*(10-array[e]));
                    }
                }
                // System.out.println("dis: "+dis +", money: "+money+ ", buy: "+buy);
                if(buy >= money){
                    count++;
                }else{
                    sum+=buy;
                }
            }
            // System.out.println("count: "+count +", sum: "+sum);

            if(count > totalCount){
                totalCount = count;
                totalMoney = sum;
            }else if(count == totalCount){
                totalMoney = Math.max(totalMoney,sum);
            }

            return;
        }

        for(int i = 1; i <= 4; i++){
            array[index] = i;
            find(index+1,array,users,emoticons);
        }
    }

    class Solution {
    }
}
