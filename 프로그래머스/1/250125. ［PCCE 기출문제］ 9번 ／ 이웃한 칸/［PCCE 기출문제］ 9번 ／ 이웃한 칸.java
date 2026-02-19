class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        // (h-1,w), (h,w-1), (h+1,w), (h,w+1) 
        if(h-1 != -1) {
            if(board[h-1][w].equals(color)) {
                answer++;
            }
        }
        if(w-1 != -1) {
            if(board[h][w-1].equals(color)) {
                answer++;
            }
        }
        if(h+1 != board.length) {
            if(board[h+1][w].equals(color)) {
                answer++;
            }
        }
        if(w+1 != board.length) {
            if(board[h][w+1].equals(color)) {
                answer++;
            }
        }
        return answer;
    }
}