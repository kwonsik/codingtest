class Solution {
    public String solution(int a, int b) {
        String answer = "";
        // 월별로 정리
        int dates[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String days[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int sum = 0;
        int monthDiff = a - 1;
        int dayDiff = b - 1;
        // 1월 1일과 a월 b일 차이 = (1월 1일과 a월 1일과의 차이) + (a월 1일과 a월 b일의 차이)
        // 1월 1일과 a월 1일과의 차이
        for(int i=0; i< monthDiff; i++) {
            sum += dates[i];
        }
        // a월 1일과 a월 b일의 차이
        sum += dayDiff;
        // FRI의 index는 5
        int index = (sum + 5) % 7;
        answer = days[index];
        return answer;
    }
}