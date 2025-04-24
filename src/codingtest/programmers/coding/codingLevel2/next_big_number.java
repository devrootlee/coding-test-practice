package codingtest.programmers.coding.codingLevel2;
/**
 * TITLE : 다음 큰 숫자
 * LEVEL : 2
 */

//자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.

public class next_big_number {

    public static int solution(int n) {
        int answer = 0;
        int c = n;
        int c0 = 0; // 0의 개수
        int c1 = 0; // 1의 개수

        // n의 끝자리에 있는 0을 모두 찾음
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        // 1의 개수를 셈
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        // 만약 모든 비트가 1로만 되어 있다면 다음 수 없음
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        // n보다 크면서 1의 개수가 같은 수
        int p = c0 + c1; // 바꿔야 할 위치

        n |= (1 << p);        // p번째 비트를 1로 설정
        n &= -(1 << p); // p보다 오른쪽 비트를 모두 0으로 초기화
        n |= (1 << (c1 - 1)) - 1; // 오른쪽에 (c1-1)개의 1을 추가

        answer = n;
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(78);
        solution(15);
    }
}
