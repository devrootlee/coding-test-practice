package codingtest.programmers.coding.codingLevel2;
/**
 * TITLE : 예상 대진표
 * LEVEL : 2
 */
public class expected_bracket {

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        solution(8, 4, 7);
    }
}
