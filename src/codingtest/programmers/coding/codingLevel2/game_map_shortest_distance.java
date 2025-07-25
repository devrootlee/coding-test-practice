package codingtest.programmers.coding.codingLevel2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TITLE : 게임 맵 최단거리
 * LEVEL : 2
 */
public class game_map_shortest_distance {

    public static int solution(int[][] maps) {
        // 상하
        int[] dx = {-1,1,0,0};
        // 좌우
        int[] dy = {0,0,-1,1};

        // 도착좌표
        int goalX = maps.length - 1;
        int goalY = maps[0].length - 1;

        // 각 칸까지의 최단거리를 저장할 예정
        int[][] distances = new int[maps.length][maps[0].length];

        // bfs를 위한 큐
        Queue<int[]> q = new LinkedList<>();
        // start(x좌표, y좌표, 이동거리)
        q.offer(new int[]{0,0,1});
        distances[0][0] = 1;

        while (!q.isEmpty()) {
            // 현재위치
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            int answer = current[2];

            // 현재 좌표가 도착지랑 같으면 return
            if (x == goalX && y == goalY) {
                return answer;
            }

            // 상하좌우 체크
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동할 수 있는지 없는지 체크
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    // 벽 체크&&이동 여부 체크
                    if (maps[nx][ny] == 1 && distances[nx][ny] == 0) {
                        // 다음 칸까지의 거리 업데이트
                        distances[nx][ny] = answer + 1;

                        // 다음 칸의 위치와 업데이트된 거리를 큐에 추가
                        q.offer(new int[]{nx, ny, answer + 1});
                    }
                }
            }
        }

        // 큐가 소진되었는데도 도착이 아니면 -1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }
}
