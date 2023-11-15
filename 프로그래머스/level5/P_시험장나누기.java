package algo_202311.kakaointern2021;

import java.util.*;

public class P_시험장나누기 {
    public static void main(String[] args) {
        P_시험장나누기 test = new P_시험장나누기();
        int k = 3;
        int[] num = {12,30,1,8,8,6,20,7,5,10,4,1};
        int[][] links = {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{8,5},{2,10},{3,0},{6,1},{11,-1},{7,4},{-1,-1},{-1,-1},};
        int result = 40;
        int answer = test.solution(k,num,links);
        if(result == answer){
            System.out.println("success");
        }else{
            System.out.println("fails");
        }
    }

    public static Node[] node;
    public static int root;
    public static int groupCount;

    public int solution(int k, int[] num, int[][] links) {

        initData(num,links);
        int answer = find(num,k);

        return answer;
    }

    public static int find(int[] num, int k){
        int length = num.length;
        int start = num[0]; // 그룹했을 때 나올 수 있는 최소 값
        int end = num[0];
        for(int i = 1; i < length; i++){
            start = Math.max(start, num[i]);
            end += num[i];
        }
        if(k == 1) return end;

        while(start <= end){
            int mid = (start + end)/2; // 그룹한 개수의 최대치

            // 그룹 개수 결과가 K 이하면 최대치 값을 줄여서 그룹 개수가 늘어날 수 있게 조정
            if(getGroupCount(mid) <= k) end = mid-1;
            else start = mid+1;
        }

        return end + 1; // 탈출은 무조건 k일 때니까 mid-1값을 들고 나온다 그러니 +1
    }

    public static int getGroupCount(int limit){
        groupCount = 0;
        dfs(root,limit);
        groupCount++; // 맨 마지막 시험장 카운트
        // System.out.println("groupCount: "+groupCount);
        return groupCount;
    }

    // 부모 + 왼쪽 , 부모 + 오른쪽, 부모 + 왼 + 오 이렇게 세 가지로 그룹 가능한지 탐색
    public static int dfs(int index , int limit){
        // System.out.println("index: "+index);
        // System.out.println("node[index].num: "+node[index].num);
        int leftValue = 0;
        if(node[index].lc != null){
            leftValue = dfs(node[index].lc.index, limit);
        }
        int rightValue = 0;
        if(node[index].rc != null){
            rightValue = dfs(node[index].rc.index, limit);
        }
        if(node[index].num + leftValue + rightValue <= limit){
            return node[index].num + leftValue + rightValue;
        }
        if(node[index].num + Math.min(leftValue,rightValue) <= limit){
            groupCount++; // 둘 중 큰 놈만 그룹 지어서 올려보냄
            return node[index].num + Math.min(leftValue,rightValue);
        }

        groupCount+=2; // 그룹 못했으니 자식들은 각자의 그룹 생성됨
        return node[index].num; // 둘 다 그룹 못지어서 올려보냄
    }

    public static void initData(int[] num, int[][] links){
        int length = num.length;
        node = new Node[length];
        for(int i = 0; i < length; i++){
            node[i] = new Node(i,num[i]);
        }

        int[] count = new int[length];
        for(int i = 0; i < length; i++){
            int left = links[i][0];
            int right = links[i][1];
            if(left != -1){
                node[i].lc = node[left];
                count[left]++;
            }
            if(right != -1){
                node[i].rc = node[right];
                count[right]++;
            }
        }

        root = 0;
        for(int i = 0; i < length; i++){
            if(count[i] == 0){
                root = i;
                break;
            }
        }
    }


    public static class Node{
        Node lc,rc; //left child, right child
        int num; // 시험장 응시자 수
        int index; // 시험장 번호

        public Node(){};
        public Node(int index, int num){
            this.index = index;
            this.num = num;
        }

        @Override
        public String toString(){
            return "index: "+index + ", num: "+num;
        }
    }
}
