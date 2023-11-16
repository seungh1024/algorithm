package algo_202311.kakaointern2020;

import java.util.*;

public class P_보석쇼핑 {
    public static void main(String[] args) {
        P_보석쇼핑 test = new P_보석쇼핑();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = test.solution(gems);
        int[] result = new int[]{3,7};
        if(answer[0] == result[0] && answer[1] == result[1]) System.out.println("success");
        else System.out.println("fail");
    }
    public static Map<String, Integer> gemNumber;
    public static int[] gemCount; // 각 번호의 보석 개수 카운트
    public static int totalCount; // 중복 없이 번호 전체 개수 + 1
    public int[] solution(String[] gems) {

        initData(gems);
        Section result = find(gems);

        return new int[]{result.left+1,result.right+1};
    }

    public static Section find(String[] gems){
        Queue<Section> pq = new PriorityQueue<>();
        int l = 0; //왼쪽 인덱스
        int r = 0; //오른쪽 인덱스
        int length = gems.length;
        int count = 0;
        boolean check = true;
        while(check){
            // System.out.println("l: "+l +", r: "+r);
            int index = gemNumber.get(gems[r]);
            if(gemCount[index] == 0){
                count++;
            }
            gemCount[index]++;


            while(true){

                int leftIndex = gemNumber.get(gems[l]);
                if(r == length-1 && gemCount[leftIndex] == 1){
                    check = false;
                }
                if(gemCount[leftIndex] -1 > 0){
                    gemCount[leftIndex]--;
                    l++;
                }else{
                    break;
                }
            }
            if(count == totalCount-1){
                // System.out.println("count: "+count);
                pq.offer(new Section(l,r,r-l));
            }
            if(r < length){
                r++;
            }
        }

        return pq.poll();
    }

    public static void initData(String[] gems){
        gemNumber = new HashMap<>();
        totalCount = 1;
        for(String gem : gems){
            if(!gemNumber.containsKey(gem)){
                gemNumber.put(gem,totalCount);
                totalCount++;
            }
        }
        gemCount = new int[totalCount];
    }


    //정답 구간 저장 클래스
    public static class Section implements Comparable<Section>{
        int left,right,size;

        public Section(int left, int right, int size){
            this.left = left;
            this.right = right;
            this.size = size;
        }

        @Override
        public int compareTo(Section s){
            if(this.size == s.size){
                return this.left - s.left;
            }else{
                return this.size-s.size;
            }
        }

        @Override
        public String toString(){
            return "left: "+left+", right: "+right +", size: "+size;
        }
    }
}
