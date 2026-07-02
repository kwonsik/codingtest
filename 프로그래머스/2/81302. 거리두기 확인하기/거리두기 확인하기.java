import java.util.*;

class Solution {
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};   
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
            if (checkRoom(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean checkRoom(String[] room) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(room[i].charAt(j) == 'P') {
                    if(!bfs(room, i, j)) {
                        return false; 
                    }
                }
            }  
        }
        return true; 
    }

    public boolean bfs(String[] room, int startRow, int startCol) {
        boolean[][] isVisit = new boolean[5][5]; 
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        isVisit[startRow][startCol] = true;
        deque.offer(new int[]{startRow, startCol, 0}); 

        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int dist = current[2]; 

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dy[i];
                int nextCol = currentCol + dx[i]; 

                if(nextRow >= 0 && nextCol >= 0 && nextRow < 5 && nextCol < 5 && !isVisit[nextRow][nextCol]) {
                    char nextPlace = room[nextRow].charAt(nextCol);

                    if (nextPlace == 'X') continue; 
                    
                    if (nextPlace == 'P' && dist <= 1) return false; 
                    
                    if (nextPlace == 'O' && dist < 2) {
                        isVisit[nextRow][nextCol] = true;
                        deque.offer(new int[]{nextRow, nextCol, dist + 1});
                    }
                }
            }
        }
        return true;
    }
}