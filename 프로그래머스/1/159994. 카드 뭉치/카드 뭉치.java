class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 두 카드 뭉치의 현재 위치를 가리키는 포인터(인덱스)
        int idx1 = 0;
        int idx2 = 0;
        
        // goal(목표)의 단어를 하나씩 확인
        for (String target : goal) {
            
            // 1. cards1의 현재 카드와 같은지 확인
            // (주의: 인덱스가 범위를 넘지 않도록 먼저 체크해야 함!)
            if (idx1 < cards1.length && target.equals(cards1[idx1])) {
                idx1++; // 카드 썼으니 다음 장으로
            }
            
            // 2. cards2의 현재 카드와 같은지 확인
            else if (idx2 < cards2.length && target.equals(cards2[idx2])) {
                idx2++; // 카드 썼으니 다음 장으로
            }
            
            // 3. 둘 다 없으면? 실패!
            else {
                return "No";
            }
        }
        
        // 반복문을 무사히 통과했다면 성공!
        return "Yes";
    }
}