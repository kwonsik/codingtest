import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        boolean[][] map = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            map[a][b] = true;
            map[b][a] = true;
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            map[a][b] = false;
            map[b][a] = false;
            
            int count = bfs(1, map, n);

            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);
            
            map[a][b] = true;
            map[b][a] = true;
        }
        
        return minDiff;
    }
    
    private int bfs(int start, boolean[][] map, int n) {
        boolean[] visited = new boolean[n + 1]; 
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start); 
        visited[start] = true; 
        int count = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll(); 
            
            for (int next = 1; next <= n; next++) {
                if (map[current][next] == true && visited[next] == false) {
                    visited[next] = true; 
                    queue.offer(next); 
                    count++; 
                }
            }
        }
        
        return count; 
    }
}