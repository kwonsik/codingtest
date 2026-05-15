import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        int cnt = (n*(n+1)) / 2;
        int[] answer = new int[cnt];
        
        int dx = 0;
        int dy = 0;
        String way = "down";
        
        for(int i = 1; i <= cnt; i++) {
            arr[dy][dx] = i;
            
            if("down".equals(way)) {
                if(dy == n - 1 || arr[dy+1][dx] != 0) {
                    way = "right";
                    dx++;
                } else {
                    dy++;
                }
                
            } else if("right".equals(way)) {
                if(dx == n - 1 || arr[dy][dx+1] != 0) {
                    way = "up";
                    dy--; dx--;
                } else {
                    dx++;
                }
                
            } else if("up".equals(way)) {

                if(arr[dy-1][dx-1] != 0) {
                    way = "down";
                    dy++;
                } else {
                    dy--; dx--; 
                }
            }
        }
        
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != 0) {
                    answer[index++] = arr[i][j];
                }
            } 
        }
        return answer;
    }
}