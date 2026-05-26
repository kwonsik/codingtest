import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 하루는 24시간 = 1440분. 청소 시간 10분을 더해 넉넉히 1450칸짜리 타임라인 배열 생성
        int[] room = new int[1450];
        
        for (String[] time : book_time) {
            int start = parseTime(time[0]);
            int end = parseTime(time[1]) + 10;

            room[start] += 1;

            if (end < 1450) {
                room[end] -= 1; 
            }
        }
        int answer = 0;
        int currentRooms = 0; 
        
        for (int i = 0; i < 1450; i++) {
            currentRooms += room[i]; 
            answer = Math.max(answer, currentRooms);
        }
        
        return answer;
    }
    
    private int parseTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }
}