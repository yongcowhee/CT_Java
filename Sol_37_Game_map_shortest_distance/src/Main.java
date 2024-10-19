import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 상하좌우(동서남북) 이동을 위한 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    // 입력값
    static int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

    public static void main(String[] args) {
        // 최단거리 저장 및 방문 확인용 2차원 배열
        int[][] dist = new int[maps.length][maps[0].length];

        Queue<Pair> q = new LinkedList<>();

        // 시작점 넣어주기
        q.add(new Pair(0, 0));
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            // 현재 좌표 p의 상하좌우 탐색
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                // 맵 밖으로 나가는 경우
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }

                // 아직 방문하지 않았고, 맵 안의 유효한 길일 경우
                if (dist[nx][ny] == 0 && maps[nx][ny] == 1) {
                    q.add(new Pair(nx, ny));
                    // 현재 좌표의 dist(최단거리)에 1 더해서 최단거리 갱신
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                }
            }
        }
        if (dist[maps.length - 1][maps[0].length - 1] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(dist[maps.length - 1][maps[0].length - 1]);
        }
    }
}