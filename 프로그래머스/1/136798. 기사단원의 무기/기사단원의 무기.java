class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int count = 0;
            
            // 1. 제곱근까지만 반복 (Math.sqrt 대신 j * j <= i 사용)
            // 이것이 성능 핵심입니다. (실수 연산 제거)
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    count++;        // 제곱수일 경우 (예: 3*3=9) 하나만 카운트
                } else if (i % j == 0) {
                    count += 2;     // 약수는 항상 쌍으로 존재 (예: 1, 12 / 2, 6 ...)
                }
            }

            // 2. 리스트에 담지 않고 바로 철의 무게 계산 (Limit 체크)
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        
        return answer;
    }
}