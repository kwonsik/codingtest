import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int rows, cols; // 클래스 레벨 변수
    
    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        List<Integer> list = new ArrayList<>();
        visited = new boolean[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int result = bfs(maps, i, j);
                    list.add(result); 
                }              
            }
        }
        
        if(list.isEmpty()) return new int[]{-1};
        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    public int bfs(String[] maps, int startRow, int startCol) {
        int result = maps[startRow].charAt(startCol) - '0';
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        while(!deque.isEmpty()) {
            int cur[] = deque.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dy[i];
                int nextCol = curCol + dx[i]; 
                
                if(nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                    if(!visited[nextRow][nextCol] && maps[nextRow].charAt(nextCol) != 'X') {
                        visited[nextRow][nextCol] = true;
                        deque.offer(new int[]{nextRow, nextCol});
                        result += maps[nextRow].charAt(nextCol) - '0';
                    }
                }
            }
        }
        return result;
    }
}