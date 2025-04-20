package codingtest.programmers.coding.codingLevel2;
/**
 * TITLE : 숫자의 표현
 * LEVEL : 2
 */
public class expression_of_numbers {

    // 투 포인터 방법
    public static int solution(int n) {
        int answer = 1;
        int start =1, end = 1, sum =1;

        while (start <= n / 2) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                // 정답인 경우 ++
                answer++;
                // 다음 경우로 이동
                sum -= start;
                start++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(15);
    }
}
