import java.util.*;

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        // 여백으로 둘러쌓인 컨테이너 만들기
        int col = n+2;
        int row = m+2;
        char[][] con = new char[col][row];
        
        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                con[i][j] = '.';
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                con[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        // 컨테이너 꺼내기
        for(int i=0; i<requests.length; i++) {
            char target = requests[i].charAt(0);
            if(requests[i].length() == 2) {
                // 알파벳이 두번 반복된 경우
                for(int j=0; j<col; j++) {
                    for(int k=0; k<row; k++) {
                        if(con[j][k] == target) {
                            con[j][k] = '.';
                        }
                    }
                }
            } else {
                // 한번이면 이제 외부접촉을 bfs로 찾아서 바꿔주기
                boolean[][] visited = new boolean[col][row];
                ArrayDeque<int[]> deque = new ArrayDeque<>();
                deque.offer(new int[]{0,0});
                visited[0][0] = true;
                while(!deque.isEmpty()){
                    int[] current = deque.poll();
                    int curY = current[0];
                    int curX = current[1];
                    for(int d=0; d<4; d++) {
                        int nextY = current[0] + dy[d];
                        int nextX = current[1] + dx[d];
                        // 범위 내인지, 안 들른 곳인지 체크
                        if(nextY < 0 || nextX < 0 || nextY >= col || nextX >= row || visited[nextY][nextX]) {
                            continue;
                        }
                        
                        if(con[nextY][nextX] == '.') {
                            // 빈칸이면 다음 큐에 추가
                            deque.offer(new int[]{nextY, nextX});
                            // 현재칸 들름
                            visited[nextY][nextX] = true;
                        } else {
                            if(con[nextY][nextX] == target) {
                                con[nextY][nextX] = '.';
                                // 현재칸 들름
                                visited[nextY][nextX] = true;
                            }
                        }                                                
                    }
                }
            }
        }
        for(int j=0; j<col; j++) {
            for(int k=0; k<row; k++) {
                if(con[j][k] != '.') {
                    answer++;
                }
            }
        }
        return answer;
    }
}