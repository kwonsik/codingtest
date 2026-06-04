import java.util.*;

class Solution {
    // 조합과 그 조합의 주문 횟수를 저장할 전역 Map
    Map<String, Integer> map;
    // 현재 코스 길이에서 가장 많이 주문된 횟수를 추적할 변수
    int maxCount;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        // 1. [핵심 방어선] 모든 단품메뉴 주문을 알파벳 오름차순으로 정렬 (WX와 XW를 같게 취급하기 위함)
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        // 2. course 배열에 정의된 코스 요리 길이(예: 2, 3, 4)를 하나씩 탐색
        for(int targetLength : course) {
            // 코스 길이마다 초기화
            map = new HashMap<>();
            maxCount = 0;
            for(String order : orders) {
                if(order.length() >= targetLength) {
                    dfs(order, targetLength, "", 0);
                }
            }
            
            
            // 3. 탐색이 끝난 후, Map을 순회하며 가장 많이 주문된 코스(maxCount)를 찾음
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= 2 && entry.getValue() == maxCount) {
                    answerList.add(entry.getKey());
                }
            }
        }

        // 4. 최종 정답 리스트를 사전순으로 정렬 후 String 배열로 변환
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    // 🌟 [DFS 엔진] 문자열에서 targetLength 만큼의 조합을 생성하는 재귀 함수
    private void dfs(String order, int targetLength, String current, int index) {
        // 탈출조건
        if(current.length() == targetLength) {
            int count = map.getOrDefault(current, 0) + 1;
            map.put(current, count);
            maxCount = Math.max(maxCount, count);
            return;
        }
        // 재귀루프
        
        for(int i=index; i<order.length(); i++) {
            dfs(order, targetLength, current + order.charAt(i), i + 1);
        }
    }
}