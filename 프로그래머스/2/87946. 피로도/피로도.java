class Solution {
    // 가장 많이 탐험한 던전 수를 기록할 전역 변수
    int maxDungeons = 0; 
    // 방문 여부를 체크할 출입증 명부
    boolean[] visited;   

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        // 탐험 시작 (지금까지 돈 던전 수: 0, 현재 남은 피로도: k)
        dfs(0, k, dungeons); 
        
        return maxDungeons;
    }

    // 모든 경우의 수를 파헤칠 재귀 함수 
    public void dfs(int depth, int fatigue, int[][] dungeons) {
        // DFS가 호출될 때마다, 지금까지 들어온 깊이를 갱신합니다.
        maxDungeons = Math.max(maxDungeons, depth);

        // 던전 개수만큼 반복문을 돕니다
        for (int i = 0; i < dungeons.length; i++) {
            
            // 1. 아직 방문하지 않은 던전이고 && 2. 내 피로도가 최소 필요 피로도 이상이면?
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                
                // 문 열고 들어갑니다 (방문 체크)
                visited[i] = true; 
                
                // 피로도를 깎고, 깊이(탐험 횟수)를 1 늘려서 다음 던전을 향해 다시 파고듭니다
                dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
                
                // 탐험을 마치고 빠져나왔으니, 다른 루트로도 와볼 수 있게 방문 기록을 지웁니다!
                visited[i] = false; 
            }
        }
    }
}