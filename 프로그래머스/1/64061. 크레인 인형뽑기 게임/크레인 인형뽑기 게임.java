import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        int cnt = 0;
        while(cnt<moves.length) {
            for(int i=0; i< board.length; i++) {
                // 뽑는 칸
                int index = moves[cnt] - 1;
                if(board[i][index] != 0) {
                    // 뽑은 인형 추가
                    list.add(board[i][index]);
                    // 해당 칸 인형 제거
                    board[i][index] = 0;
                    break;
                }
            }
            
            // 2개 이상일 때 체크
            if(list.size() > 1) {
                if(list.get(list.size()-1) == list.get(list.size()-2)) {
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    answer++;
                }
            }
            cnt++;
        }
        answer*=2;
        return answer;
    }
}