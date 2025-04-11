package codingtest.programmers.coding.codingLevel1;

/**
 * TITLE : 택배 상자 꺼내기
 * LEVEL : 1
 */
public class take_out_the_delivery_box {

    public static int solution(int n, int w, int num) {
        int answer = 0;

        // 세로길이 구하기
        int height = 0;
        if (n % w == 0) height = n / w;
        else height = n / w + 1;

         // 박스 쌓는 배열 셋팅
        int[][] box = new int[height][w];
        int boxInput = 0;

        boolean switching = true;
        for (int i = 0; i < height; i++) {

            if (switching) {
                for (int j = 0; j < w; j++) {
                    boxInput += 1;

                    if (boxInput > n) break;
                    else box[i][j] = boxInput;
                }

                switching = false;
            } else {
                for (int k = w - 1; k >= 0; k--) {
                    boxInput += 1;

                    if (boxInput > n) break;
                    else box[i][k] = boxInput;
                }

                switching = true;
            }
        }

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if (box[i][j] == num) {

                    for (int check = box.length - 1; check >= i; check --) {
                        // 0이 아닌 숫자일때만 더해준다.
                        if (box[check][j] != 0) {
                            answer += 1;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(22, 6, 8);
        solution(13, 3, 6);
        solution(100, 9, 47);
    }
}
