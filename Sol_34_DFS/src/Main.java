import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] graph = {{1,2},{2,3},{3,4},{4,5}};
    static ArrayList<Integer>[] adjList; // 인접리스트
    static int n = 5;
    static int start = 1;
    static boolean[] visited;
    static ArrayList<Integer> answer;
    public static void main(String[] args) {
        // 인접리스트 초기화
        adjList = new ArrayList[n+1];
        for(int i = 0; i<adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }

        // 그래프 배열 -> 인접리스트 변환
        for(int[] edge : graph){
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n+1];
        answer = new ArrayList<>();
        dfs(start);

        answer.stream().mapToInt(Integer::intValue).toArray();

        for(int i = 0; i<answer.size(); i++){
            System.out.printf(answer.get(i) + " ");
        }
    }
    static void dfs(int now){
        // 방문 처리
        visited[now] = true;
        // answer에 삽입
        answer.add(now);

        // 인접리스트 돌면서 다음 노드 탐색
        for(int next : adjList[now]){
            // 방문하지 않은 노드에 한해서 다시 dfs 재귀
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}