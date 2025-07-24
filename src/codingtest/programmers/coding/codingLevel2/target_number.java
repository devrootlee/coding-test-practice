package codingtest.programmers.coding.codingLevel2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TITLE : 타겟 넘버
 * LEVEL : 2
 */
public class target_number {

    public static int solution(int[] numbers, int target) {
        // bfs
        int bfsAnswer = 0;
        long bfsBeforeTime = System.nanoTime();
        bfsAnswer = bfs(numbers, target);
        long bfsAfterTime = System.nanoTime();
        long bfsSecDiffTime = (bfsAfterTime - bfsBeforeTime);
        System.out.println("bfs 시간차이(m) : " + bfsSecDiffTime);
        System.out.println(bfsAnswer);

        // dfs
        int dfsAnswer = 0;
        long dfsBeforeTime = System.nanoTime();
        dfsAnswer = dfs(numbers, target, 0, dfsAnswer);
        long dfsAfterTime = System.nanoTime();
        long dfsSecDiffTime = (dfsAfterTime - dfsBeforeTime);
        System.out.println("dfs 시간차이(m) : " + dfsSecDiffTime);
        System.out.println(dfsAnswer);


        return dfsAnswer;
    }

    // dfs
    private static int dfs(int[] numbers, int target, int index, int currentSum) {
        // 모든 숫자를 다 사용
        if (index == numbers.length) {
            // 현재 합이 타겟과 같으면 1 반환
            if (currentSum == target) {
                return 1;
            }
            // 타겟과 다르면 0 반환
            return 0;
        }

        int plus = dfs(numbers, target, index + 1, currentSum + numbers[index]);
        int minus = dfs(numbers, target, index + 1, currentSum - numbers[index]);

        return plus + minus;
    }

    static class State {
        int index;
        int currentSum;

        State(int index, int currentSum) {
            this.index = index;
            this.currentSum = currentSum;
        }
    }

    // bfs
    private static int bfs(int[] numbers, int target) {
        int answer = 0;
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0)); // 초기화

        while (!queue.isEmpty()) {
            State curr = queue.poll();
//            System.out.println("처리: index = " + curr.index + ", currentSum = " + curr.currentSum);

            // 숫자 전부 사용
            if (curr.index == numbers.length) {
                if (curr.currentSum == target) {
//                    System.out.println("타겟 도달: currentSum = " + curr.currentSum);
                    answer++;
                }
                continue;
            }

            // 다음 상태: 현재 숫자를 더하거나 더하기
            queue.offer(new State(curr.index + 1, curr.currentSum + numbers[curr.index]));
            queue.offer(new State(curr.index + 1, curr.currentSum - numbers[curr.index]));
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
