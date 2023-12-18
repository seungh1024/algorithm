package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_10216_CountCircleGroups {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N];
            Data[] data = new Data[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                data[i] = new Data(x,y,r);
            }
            initParent(parent,N);
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    union(parent,data,i,j);
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                getParent(parent,i);
                set.add(parent[i]);
            }
//            for (int i = 0; i < N; i++) {
//            }
            sb.append(set.size()).append("\n");
//            System.out.println(Arrays.toString(parent));
        }
        System.out.println(sb);

    }

    public static int getParent(int[] parent, int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = getParent(parent,parent[a]);
    }

    public static void union(int[] parent, Data[] data, int a, int b) {
        int ap = getParent(parent, a);
        int bp = getParent(parent, b);
        Data A = data[a];
        Data B = data[b];
        double x = Math.abs(A.x-B.x);
        double y = Math.abs(A.y-B.y);
        double length = Math.sqrt(x*x +y*y);
//        System.out.println(length);

        if (length <= (double)(A.r + B.r)) {
            parent[bp] = ap;
        }
    }

    public static void initParent(int[] parent, int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public static class Data{
        int x,y,r;

        public Data(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }


        @Override
        public String toString() {
            return "x: "+x +", y: "+ y + ", r: "+ r;
        }
    }
}
