class Solution {
    public int solution(String dartResult) {
        int[] arr = new int[3];
        int idx = -1; // 현재 몇 번째 다트인지 추적 (0, 1, 2)

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            // 1. 숫자일 때 (새로운 다트의 시작)
            if (ch >= '0' && ch <= '9') {
                idx++; // 다음 다트로 이동!
                
                // '1'인데 바로 뒤가 '0'이면 10점 처리
                if (ch == '1' && dartResult.charAt(i + 1) == '0') {
                    arr[idx] = 10;
                    i++; // '0'은 처리했으니 한 칸 건너뛰기! (핵심)
                } else {
                    arr[idx] = ch - '0'; // 문자를 숫자로 변환
                }
            } 
            // 2. 보너스 (제곱)
            else if (ch == 'S' || ch == 'D' || ch == 'T') {
                if (ch == 'D') {
                    arr[idx] = arr[idx] * arr[idx];
                } else if (ch == 'T') {
                    arr[idx] = arr[idx] * arr[idx] * arr[idx];
                }
                // 'S'는 1제곱이라 냅둬도 됨
            } 
            // 3. 옵션 (바로바로 계산해 버리기)
            else if (ch == '*') {
                arr[idx] *= 2; // 현재 다트 2배
                if (idx > 0) {
                    arr[idx - 1] *= 2; // 이전 다트도 2배 (첫 번째 다트가 아닐 때만)
                }
            } 
            else if (ch == '#') {
                arr[idx] *= -1; // 현재 다트 마이너스
            }
        }

        // 총합 반환
        return arr[0] + arr[1] + arr[2];
    }
}