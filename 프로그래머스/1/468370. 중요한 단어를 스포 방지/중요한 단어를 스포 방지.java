import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        // 1. 중복을 알아서 제거해 주는 두 개의 장부(Set)
        Set<String> spoiledSet = new HashSet<>(); // 스포일러가 묻은 단어들
        Set<String> pureSet = new HashSet<>();    // 스포일러가 전혀 안 묻은(생 노출) 단어들

        // 2. 메시지를 공백 기준으로 쪼개
        String[] words = message.split(" ");
        
        // 3. 원본 문자열에서의 '현재 내 위치(인덱스)'를 기억할 변수
        int currentIndex = 0;

        for (String word : words) {
            // '인덱스 매칭'
            int wordStart = currentIndex; 
            int wordEnd = currentIndex + word.length() - 1;
            
            boolean isSpoiled = false; // 일단 이 단어는 스포일러가 아니라고 가정

            // 4. 이 단어의 영토[wordStart, wordEnd]가 스포일러 영토와 겹치는지 검사
            for (int[] range : spoiler_ranges) {
                int spoilerStart = range[0];
                int spoilerEnd = range[1];

                // [핵심 수학 패턴] 두 선분이 겹칠 조건: 내 시작점이 쟤 끝점보다 작거나 같고, 쟤 시작점이 내 끝점보다 작거나 같다
                if (wordStart <= spoilerEnd && spoilerStart <= wordEnd) {
                    isSpoiled = true; // 한 글자라도 겹치면 바로 스포일러 판정!
                    break; // 더 이상 다른 스포일러 구간을 검사할 필요 없음
                }
            }

            // 5. 검사 결과에 따라 흑백 장부에 명확하게 나누어 적기
            if (isSpoiled) {
                spoiledSet.add(word); // 스포일러가 조금이라도 묻었으면 여기로
            } else {
                pureSet.add(word);    // 완전히 깨끗하게 노출되었으면 저기로
            }

            // 6. 다음 단어를 위해 인덱스 전진 (단어 길이 + 공백 1칸)
            currentIndex += word.length() + 1; 
        }

        // 7. 최종 정산: 스포일러 장부에 있는 단어 중, '생 노출 장부(pureSet)'에 없는 것만 카운트!
        int answer = 0;
        for (String spoiledWord : spoiledSet) {
            if (!pureSet.contains(spoiledWord)) { // 한 번이라도 생으로 노출된 적이 없다면?
                answer++; // 진정한 '중요한 단어'로 인정!
            }
        }

        return answer;
    }
}