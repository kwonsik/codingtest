import java.util.*;

class Solution {
    int dx[] = {0, 0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    public int solution(String[] board) {
        int answer = 0;
        int start[] = new int[2];
        int target[] = new int[2];
        char map[][] = new char[board.length][board[0].length()];
        for(int i=0; i< board.length; i++) {
            char arr[] = board[i].toCharArray();
            for(int j=0; j<arr.length; j++) {
                map[i][j] = arr[j];
                if(arr[j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if(arr[j] == 'G') {
                    target[0] = i;
                    target[1] = j;
                } 
            }
        }
        answer = bfs(start, target, map);
        return answer;
    }
    public int bfs(int[] start, int[] target, char[][] map) {
        int result = 0;
        int width = map[0].length;
        int height = map.length;
        boolean visited[][] = new boolean[height][width];
        
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int currentY = current[0];
            int currentX = current[1];
            int currentCnt = current[2];
            
            if(currentY == target[0] && currentX == target[1]) {
                return currentCnt;
            }
            
            for(int i=0; i<4; i++) {
                int nextY = currentY; 
                int nextX = currentX;
                while(true) {
                    nextY += dy[i];
                    nextX += dx[i];
                    // 탈출 조건
                    if(nextY < 0 || nextY >= height || nextX < 0 || nextX >= width || map[nextY][nextX] == 'D') {
                        break;
                    }
                    
                    
                }   
                nextY -= dy[i];
                nextX -= dx[i];
                if (!visited[nextY][nextX]) {
        visited[nextY][nextX] = true;
        deque.offer(new int[]{nextY, nextX, currentCnt + 1}); 
    }
            }
        }
        return -1;
    }
    
}