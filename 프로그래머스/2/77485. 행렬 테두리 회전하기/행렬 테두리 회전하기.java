import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        List<Integer> list = new ArrayList<>();
        int arr[][] = new int[rows][columns];
        int cnt = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                arr[i][j] = cnt;
                cnt++;
            }
        }
        // 4가지의 경우, 11시에서 1시(2,2 -> 2,4), 1시에서 5시(2,4 -> 5,4), 5시에서 7시(5,4 -> 5,2), 7시에서 11시(5,2 -> 2,2)
        for(int i=0; i<queries.length; i++) {          
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int temp = arr[x1][y1];
            int minVal = temp; 


            for (int x = x1; x < x2; x++) {
                arr[x][y1] = arr[x + 1][y1];
                minVal = Math.min(minVal, arr[x][y1]); // 덮어쓰면서 최솟값 갱신
            }

            for (int y = y1; y < y2; y++) {
                arr[x2][y] = arr[x2][y + 1];
                minVal = Math.min(minVal, arr[x2][y]);
            }

            for (int x = x2; x > x1; x--) {
                arr[x][y2] = arr[x - 1][y2];
                minVal = Math.min(minVal, arr[x][y2]);
            }

            for (int y = y2; y > y1; y--) {
                arr[x1][y] = arr[x1][y - 1];
                minVal = Math.min(minVal, arr[x1][y]);
            }

            arr[x1][y1 + 1] = temp;
            list.add(minVal);
        }
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}