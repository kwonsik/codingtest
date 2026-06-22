import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int rows, cols; // 클래스 레벨 변수
    
    public int[] solution(String[] maps) {
        int answer[] = {};
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i< rows; i++) {
            for(int j=0; j<cols; j++) {
                char ch = maps[i].charAt(j);
                if(ch != 'X' && !visited[i][j]) {
                    int result = bfs(maps, i, j);
                    list.add(result);
                }
            }
        }
        if(list.size() == 0) {
            return new int[]{-1};
        }
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public int bfs(String[] maps, int startRow, int startCol) {
        int result = maps[startRow].charAt(startCol) - '0';
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            for(int i=0; i<4; i++) {
                int nextRow = currentRow + dy[i];
                int nextCol = currentCol + dx[i];
                if(nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                    if(!visited[nextRow][nextCol] && maps[nextRow].charAt(nextCol) != 'X') {
                        result += maps[nextRow].charAt(nextCol) - '0';
                        visited[nextRow][nextCol] = true;
                        deque.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
            
        }
        
        
        return result;
    }
}