

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1469
 */
public class Main {

    public static int N;
    public static int[] elements;
    public static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        backtracking();
    }

    public static void backtracking() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        elements = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i < N; i++) elements[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(elements);

        dfs_back(0, new String[N * 2], new boolean[N]);
        System.out.println(list.size() == 0 ? "-1" : list.get(0));

    }

    public static void dfs_back(int depth, String[] answer, boolean[] visited) {
        if (N * 2 == depth) {
            list.add(String.join(" ", answer));
            return;
        }

        if (list.size() > 0) return;

        if (answer[depth] != null) {
            dfs_back(depth + 1, answer, visited);
            return;
        }

        for (int i=0; i < N ; i++) {
            if (!visited[i]) {
                int element = elements[i];
                if (depth + element + 1 < N * 2 && answer[depth] == null && answer[depth + element + 1] == null) {
                    visited[i] = true;
                    answer[depth] = answer[depth + element + 1] = String.valueOf(elements[i]);
                    dfs_back(depth + 1, answer, visited);
                    answer[depth] = answer[depth + element + 1] = null;
                    visited[i] = false;
                }
            }
        }
    }



}