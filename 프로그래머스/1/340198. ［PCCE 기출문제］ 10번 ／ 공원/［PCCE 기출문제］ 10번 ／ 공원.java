import java.util.*;

class Solution {
    // 1. 최고 관리자 (전체 흐름 통제)
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats); // 돗자리 크기를 정렬 (오름차순)
        
        // 가장 큰 돗자리부터(뒤에서부터) 역순으로 검사
        for (int i = mats.length - 1; i >= 0; i--) {
            int matSize = mats[i];
            
            // "이 돗자리 깔 수 있어?" 하고 하청을 줍니다.
            if (canPlace(matSize, park)) {
                return matSize; // 깔 수 있다고 하면 바로 정답 리턴!
            }
        }
        return -1; // 아무것도 못 깔면 -1
    }

    // 2. 중간 관리자 (시작점 찾기)
    private boolean canPlace(int size, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        
        // 돗자리가 맵 밖으로 삐져나가지 않도록 범위 설정 (rows - size)
        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                
                // "여기서부터 size만큼 빈칸인지 확인해 줘!" 하고 또 하청을 줍니다.
                if (checkSquare(i, j, size, park)) {
                    return true; // 빈칸이면 즉시 깔 수 있다고 보고!
                }
                
            }
        }
        return false;
    }

    // 3. 실무자 (진짜 맵 뒤지기)
    private boolean checkSquare(int startI, int startJ, int size, String[][] park) {
        for (int i = startI; i < startI + size; i++) {
            for (int j = startJ; j < startJ + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false; // 돌멩이 발견 즉시 보고!
                }
            }
        }
        return true; 
    }
}