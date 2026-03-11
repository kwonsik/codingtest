import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int length = signals.length;
        int[] sumArr = new int[length];
        
        // 1. 각 신호등의 한 사이클 길이(초록+노란+빨간) 구하기
        for(int i = 0; i < length; i++) {
            int sum = 0;
            for(int j = 0; j < signals[i].length; j++) {
                sum += signals[i][j];
            }
            sumArr[i] = sum; // 각 신호등의 주기 저장
        }
        
        // 2. 전체 사이클의 최소공배수(max) 구하기
        int max = sumArr[0];
        for(int i = 1; i < length; i++) {
            max = lcm(max, sumArr[i]);
        }
        
        // 3. 1초부터 최소공배수(max) 시간까지만 팩트 체크 돌입
        for (int t = 1; t <= max; t++) {
            boolean allYellow = true; // 일단 '모두 노란불'이라고 기분 좋게 가정해 봅니다.
            
            for (int[] signal : signals) {
                int g = signal[0]; // 초록불
                int y = signal[1]; // 노란불
                int r = signal[2]; // 빨간불
                int cycle = g + y + r; // 이 신호등의 총 주기
                
                // 4. 핵심 최적화: ArrayList 대신 나머지(%) 연산으로 현재 위치 파악
                // 시간이 1초부터 시작하므로 (t - 1)을 해줘야 0부터 깔끔하게 계산됩니다.
                int pos = (t - 1) % cycle;
                
                // 노란불이 켜져 있는 구간(g <= pos < g + y)이 아니라면?
                if (!(pos >= g && pos < g + y)) {
                    allYellow = false; // 하나라도 아니면 정전이 안 일어나므로 탈락!
                    break; // 더 이상 다른 신호등을 검사할 필요 없이 조기 퇴근 (Early Return)
                }
            }
            
            // 모든 신호등 검사를 무사히 통과해서 allYellow가 여전히 true라면?
            if (allYellow) {
                return t; // 우리가 찾던 바로 그 시간! 정답 리턴!
            }
        }
        
        // 최소공배수(모든 주기가 리셋되는 시간)까지 다 뒤졌는데도 없으면 영원히 안 나옴
        return -1; 
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}