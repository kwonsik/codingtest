import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        char[][] map = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            char[] arr = maps[i].toCharArray();
            for(int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if(map[i][j] == 'L') {
                    lever = new int[]{i, j};
                } else if(map[i][j] == 'E') {
                    end = new int[]{i, j};
                }
            }
        }

        int toLever = bfs(start, lever, map);
        if (toLever == -1) return -1; 
        
        int toEnd = bfs(lever, end, map);
        if (toEnd == -1) return -1;
        

        return toLever + toEnd;
    }
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int bfs(int[] start, int[] target, char[][] map) {
        int height = map.length;
        int width = map[0].length;
    
        boolean visited[][] = new boolean[height][width];

        ArrayDeque<int[]> deque = new ArrayDeque<>();        
    
        deque.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
    
        while(!deque.isEmpty()) {
            int current[] = deque.poll();
            int curY = current[0];
            int curX = current[1];
            int curTime = current[2];
            if (curY == target[0] && curX == target[1]) {
                return curTime;
            }
            
            for(int i=0; i<4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                
                // 🛑 [방어 로직 1] 미로의 바깥 낭떠러지로 떨어지는가? (IndexOutOfBounds 예외 방어)
                if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
                    continue; // 이 방향은 건너뛰고 다음 방향 검사
                }
            
                // 🛑 [방어 로직 2] 벽('X')에 부딪히거나, 이미 가본 곳(visited)인가?
                if (map[nextY][nextX] == 'X' || visited[nextY][nextX] == true) {
                    continue; // 건너뜁니다.
                }
                
                visited[nextY][nextX] = true;
                deque.offer(new int[]{nextY, nextX, curTime + 1});
            }
        }

        

    return -1;
    }
}