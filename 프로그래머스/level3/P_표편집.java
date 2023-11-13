package algo_202311.kakaointern2021;

import java.io.*;
import java.util.*;

public class P_표편집 {
    public static void main(String[] args) {
        P_표편집 test = new P_표편집();
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4","C", "U 2", "Z", "Z"};
        String value = test.solution(n,k,cmd);
        String result = "OOOOXOOO";
        if(value.equals(result)){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }
    public static Node[] nodes;
    public static Stack<Node> stack;
    public static boolean[] visited;
    public String solution(int n, int k, String[] cmd) {
        initStaticData(n);
        doCmd(n-1, k, cmd);
        return makeResult(n);
    }

    public static String makeResult(int n){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            if(visited[i]){
                sb.append("X");
            }else{
                sb.append("O");
            }
        }
        return sb.toString();
    }

    public static void doCmd(int n, int k, String[] cmd){
        Node now = nodes[k];
        for(String s : cmd){
            char operation = s.charAt(0);

            if(operation == 'U'){
                int num = Integer.parseInt(s.split(" ")[1]);
                now = now.moveBack(num);
            }else if(operation == 'D'){
                int num = Integer.parseInt(s.split(" ")[1]);
                now = now.moveNext(num);
            }else if(operation == 'C'){
                visited[now.num] = true;
                stack.push(now);
                now = now.remove();
            }else if(operation == 'Z'){
                Node returnNode = stack.pop();
                int num = returnNode.back();
                visited[num] = false;
            }
        }
    }



    public static class Node{
        Node prev,next;
        int num;

        public Node(){}

        public Node moveBack(int n){
            Node node = this;
            for(int i = 0; i < n; i++){
                node = node.prev;
            }
            return node;
        }

        public Node moveNext(int n){
            Node node = this;
            for(int i = 0; i < n; i++){
                node = node.next;
            }
            return node;
        }

        public Node remove(){
            Node prevNode = this.prev;
            Node nextNode = this.next;


            if(prevNode != null){
                prevNode.next = nextNode;
            }
            if(nextNode != null){
                nextNode.prev = prevNode;
                return nextNode;
            }

            return prevNode;

        }

        public int back(){
            Node prevNode = this.prev;
            Node nextNode = this.next;
            if(prevNode != null){
                prevNode.next = this;
            }
            if(nextNode != null){
                nextNode.prev = this;
            }
            return this.num;
        }

    }

    public static void initStaticData(int n){
        stack = new Stack<>();
        visited = new boolean[n];
        nodes = new Node[n];
        nodes[0] = new Node();
        nodes[0].num = 0;
        for(int i = 1; i < n; i++){
            nodes[i] = new Node();

            nodes[i-1].next = nodes[i];
            nodes[i].prev = nodes[i-1];
            nodes[i].num = i;
        }
    }
}

