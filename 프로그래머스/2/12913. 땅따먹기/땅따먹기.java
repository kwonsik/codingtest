class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            // 현재 행의 0열에 = 윗 행의 1, 2, 3열 중 최댓값을 더해줌
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            
            // 현재 행의 1열에 = 윗 행의 0, 2, 3열 중 최댓값을 더해줌
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            
            // 현재 행의 2열에 = 윗 행의 0, 1, 3열 중 최댓값을 더해줌
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            
            // 현재 행의 3열에 = 윗 행의 0, 1, 2열 중 최댓값을 더해줌
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }
        
        // 마지막 행(N-1)에는 각 열에 도달할 수 있는 최대 누적 점수들이 들어있습니다.
        int[] lastRow = land[land.length - 1];
        
        return Math.max(Math.max(lastRow[0], lastRow[1]), Math.max(lastRow[2], lastRow[3]));
    }
}