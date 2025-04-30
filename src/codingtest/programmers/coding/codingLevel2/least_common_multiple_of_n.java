package codingtest.programmers.coding.codingLevel2;
/**
 * TITLE : n개의 최소공배수
 * LEVEL : 2
 */

// 두 수의 최소공배수(Least Common Multiple)란
// 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를
// 의미합니다.
// 예를 들어 2와 7의 최소공배수는 14가 됩니다.
// 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의
// 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
// n개의 숫자를 담은 배열 arr이 입력되었을 때
// 이 수들의 최소공배수를 반환하는 함수,
// solution을 완성해 주세요.
public class least_common_multiple_of_n {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{2,6,8,14});
        solution(new int[]{1,2,3});
        solution(new int[]{1,2,3,4,6});
    }
}
