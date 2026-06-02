import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int INF = 500001;
        
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0; 
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            if (c < map[a][b]) {
                map[a][b] = c;
                map[b][a] = c;
            }
        }
        
        // 3. 최단 거리 기록 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; 
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curIdx = current[0];
            int curDist = current[1];
            
            if (curDist > dist[curIdx]) continue;
            
            for (int nextIdx = 1; nextIdx <= N; nextIdx++) {
                if (map[curIdx][nextIdx] == INF) continue;
                
                if (dist[curIdx] + map[curIdx][nextIdx] < dist[nextIdx]) {
                    dist[nextIdx] = dist[curIdx] + map[curIdx][nextIdx];
                    pq.offer(new int[]{nextIdx, dist[nextIdx]});
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}