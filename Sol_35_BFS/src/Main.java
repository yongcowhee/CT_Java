import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] graph = {{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{4,8},{5,8},{6,9},{7,9}};
    static boolean[] visited;
    static int start = 1;
    static int n = 9;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Integer> answer;

    public static void main(String[] args) {
        adjList = new ArrayList[n+1];
        // 인접리스트 초기화
        for(int i = 0; i<adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }
        // graph -> adjList
        for(int[] edge : graph){
            adjList[edge[0]].add(edge[1]);
        }
        visited = new boolean[n+1];
        answer = new ArrayList<>();
        bfs(start);

        System.out.println(Arrays.toString(answer.stream().mapToInt(Integer::intValue).toArray()));
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            answer.add(now);

            for(int next : adjList[now]){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}