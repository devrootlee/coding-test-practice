package codingtest.programmers.coding.codingLevel1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * TITLE : 동영상 재생기
 * LEVEL : 1
 */
public class video_player {

    // mm:ss 포맷 출력용 헬퍼
    public static String formatAsMmSs(LocalTime time) {
        int totalSeconds = time.toSecondOfDay();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        // String 을 시간 형식으로 변경
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // zero
        LocalTime zero = LocalTime.parse("00:00:00", formatter);
        // 전체 재생시간
        LocalTime allTime = LocalTime.parse("00:" + video_len, formatter);
        // 재생 시작시간
        LocalTime posTime = LocalTime.parse("00:" + pos, formatter);
        // 오프닝 시작 시간
        LocalTime opStartTime = LocalTime.parse("00:" + op_start, formatter);
        // 오프닝 종료 시간
        LocalTime opEndTime = LocalTime.parse("00:" + op_end, formatter);

        for (String command : commands) {
            // next 일때는 +10초
            if (command.equals("next")) {

                // 현재 시간이 오프닝 중간에 있을 때이고 next 일때
                if (!posTime.isBefore(opStartTime) && !posTime.isAfter(opEndTime)) {
                    posTime = opEndTime;
                    posTime = posTime.plusSeconds(10);

                    // 동영상의 남은 시간이 10초 미만일 경우 영상의 미지막 위치로 이동
                    if (posTime.isAfter(allTime)) {
                        posTime = allTime;
                    }
                } else {
                    posTime = posTime.plusSeconds(10);

                    // 동영상의 남은 시간이 10초 미만일 경우 영상의 미지막 위치로 이동
                    if (posTime.isAfter(allTime)) {
                        posTime = allTime;

                    } else if (!posTime.isBefore(opStartTime) && !posTime.isAfter(opEndTime)) { // next 하고 나서 시작시간과 종료시간 사이면 종료시간으로 건너뛰기
                        posTime = opEndTime;
                    }
                }
            } else { //prev 일때는 -10초
                int seconds = posTime.getSecond();
                int minutes = posTime.getMinute();

                // 00:00:00 초 아래로 가면 00:00:00 초로 초기화
                if (minutes == 0 && seconds - 10 <= 0) {
                    posTime = zero;
                } else {
                    posTime = posTime.minusSeconds(10);
                }

                // 현재 시간이 오프닝 중간에 있을 때이고 prev 일때
                if (!posTime.isBefore(opStartTime) && !posTime.isAfter(opEndTime)){
                    posTime = opEndTime;
                }
            }
        }

        answer = formatAsMmSs(posTime);
        return answer;
    }

    public static void main(String[] args) {
        solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"});
        solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"});
        solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"});
        solution("30:00", "00:08", "00:00", "00:05", new String[]{"prev"});
    }
}
