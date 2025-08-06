package codingtest.beakjoon.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * TITLE : 가운데를 말해요.
 * TYPE : Primary Queue(우선순위 큐)
 */
public class say_center {
    public static void main(String[] args) throws IOException {
        // 백준 알고리즘 템플릿(입력)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());

            // 1 처음에는 max queue 에 넣기
            if (max.isEmpty() || number <= max.peek()) {
                max.offer(number);
            } else {
                min.offer(number);
            }

            // 2 두 힙의 균형 조정
            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            } else if (min.size() > max.size()) {
                max.offer(min.poll());
            }

            // 3 중앙값은 항상 max 의 top
            System.out.println(max.peek());
        }
    }
}
