import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] room = new int[1450];
        int answer = 0;
        for(int i=0; i<book_time.length; i++) {
            int start = parseTime(book_time[i][0]);
            int end = parseTime(book_time[i][1]) + 10;
            room[start] += 1;
            if(end < 1450) {
                room[end] -= 1;
            }
        }
        int current = 0;
        for(int i : room) {
            current += i;
            answer = Math.max(answer, current);
        }
        return answer;
    }
    
    private int parseTime(String time) {
        String split[] = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return hour * 60 + min;
    }
}