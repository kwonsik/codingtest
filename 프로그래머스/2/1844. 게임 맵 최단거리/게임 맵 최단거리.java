import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // 상, 하, 좌, 우 이동을 위한 나침반
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // 1. 시작점 (0,0)을 큐에 넣고 출발!
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            // 2. 큐의 맨 앞에서 하나를 꺼냅니다 (poll)
            int[] current = queue.poll(); 
            int cx = current[0];
            int cy = current[1];
            

            // (선택) 도착점에 도착했으면 콘솔에 환호성 출력!
            if (cx == n - 1 && cy == m - 1) {
                return maps[cx][cy];
            }

            // 3. 현재 위치에서 상하좌우 4방향을 찔러봅니다.
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 맵 밖으로 안 나갔고 && 아직 안 가본 길(1)이라면?
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    
                    // 큐에 다음 좌표를 줄 세웁니다 (offer)
                    queue.offer(new int[]{nx, ny});
                    
                    // ★ 핵심: 내 이전 걸음 수(maps[cx][cy])에 +1을 해서 다음 발자국을 남깁니다.
                    maps[nx][ny] = maps[cx][cy] + 1; 

                }
            }
        }
        
        // 4. 도착점의 최종 걸음 수 확인
        int answer = maps[n-1][m-1];
        
        // 도착점이 여전히 1이면 한 번도 도달 못한 것이므로 -1 리턴
        if (answer == 1) {
            return -1;
        }
        
        return answer;
    }
}