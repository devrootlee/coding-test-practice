package codingtest.beakjoon.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE : 평범한 배낭
 * TYPE : DP(동적 계획법)
 */
public class ordinary_backpack {

    public static void main(String[] args) throws IOException {
        // 백준 알고리즘 템플릿(입력)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물건 수: N, 배낭 최대 무게: K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 물건 배열(dp 매칭하기 편하게 1인덱스부터 넣기)
        int[][] items = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());  // 각 줄 새로 읽기
            items[i][0] = Integer.parseInt(st.nextToken()); // 무게
            items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        // dp 시작
        int[][] dp = new int[N + 1][K + 1]; // N + 1 은 물건번호를 1부터 시작위함, K + 1도 마찬가지로 무게를 0 부터 시작위함
        for (int i = 1; i <= N; i++) {
            int weight = items[i][0];
            int value = items[i][1];

            // 가방 무게
            for (int j = 0; j <= K; j++) {
                if (j < weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
