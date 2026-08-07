import java.util.*;

class Solution {
    public int solution(String s) {
        // 예외 처리: 문자열 길이가 1이면 자를 것도 없이 길이가 1
        if (s.length() == 1) return 1;

        int answer = s.length(); // 최악의 경우: 압축이 전혀 안 된 원래 길이

        // 1. 자르는 단위(count)를 1부터 문자열 길이의 절반까지 늘려갑니다.
        for (int count = 1; count <= s.length() / 2; count++) {
            StringBuilder result = new StringBuilder(); // 이번 단위로 압축을 완료한 문자열을 담을 통
            
            // 2. 맨 앞 블록을 prev로 설정
            String prev = s.substring(0, count);
            int repeat = 1; // prev가 연속으로 몇 번 나왔는지 세는 변수

            // 3. prev 다음 블록부터 끝까지 'count 단위로 점프'하며 확인!
            for (int i = count; i < s.length(); i += count) {
                // 남은 자투리가 count보다 짧을 수 있으니, Math.min으로 인덱스 초과 에러 방지
                int endIdx = Math.min(i + count, s.length());
                String curr = s.substring(i, endIdx);
                
                // 조건 1: prev와 curr가 같다면?
                if (prev.equals(curr)) {
                    repeat++; // 반복 횟수 1 증가
                } 
                // 조건 2: prev와 curr가 다르다면?
                else {
                    // 여태까지 누적된 걸 result에 붙임
                    if (repeat >= 2) {
                        result.append(repeat).append(prev);
                    } else {
                        result.append(prev);
                    }
                    
                    // 기준 블록(prev)을 방금 자른 curr로 바꿔치기
                    prev = curr;
                    // 새로운 기준 블록이 생겼으니 repeat은 다시 1로 초기화
                    repeat = 1;
                }
            }
            
            // 4. 마지막으로 남은 자투리 블록 털어내기 (for문 끝난 후 처리)
            if (repeat >= 2) {
                result.append(repeat).append(prev);
            } else {
                result.append(prev);
            }

            // 5. 이번 단위(count)로 압축한 결과의 길이와, 기존 answer 중 더 짧은 것으로 갱신
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}