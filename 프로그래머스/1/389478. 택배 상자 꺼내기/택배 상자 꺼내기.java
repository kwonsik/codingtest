import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int box[][] = new int[(int) Math.ceil((double)n/(double)w)][w];
        int index = 0;
        int floor = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<box.length; i++) {
            floor++;
            if(floor % 2 != 0) {
                for(int j=0; j<box[0].length; j++) {
                    index ++;
                    if(index<=n) {
                        box[i][j] = index;
                    } else {
                        box[i][j] = 0;
                    }
                    if(box[i][j] == num) {
                        x = j;
                        y = i;
                    }
                }
            } else {
                for(int j=box[0].length-1; j>=0; j--) {
                    index ++;
                    if(index<=n) {
                        box[i][j] = index;
                    } else {
                        box[i][j] = 0;
                    }
                    if(box[i][j] == num) {
                        x = j;
                        y = i;
                    }
                }
            }
            
        }
        for(int i=floor-1; i>=y; i--) {
            if(box[i][x] != 0) {
                answer++;
            }
            
        }
        return answer;
    }
}