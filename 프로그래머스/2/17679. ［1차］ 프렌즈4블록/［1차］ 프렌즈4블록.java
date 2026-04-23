class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 1단계: String 배열을 다루기 쉬운 char 2차원 배열로 변환
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            // 2단계: 파괴 대상 스캔 (지울 블록 표시)
            boolean[][] check = new boolean[m][n];
            boolean isPang = false; // 이번 턴에 지워진 블록이 있는지 확인하는 플래그

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    // 빈칸('-')이 아니고, 2x2가 모두 같은 블록이라면?
                    if (c != '-' && c == map[i][j+1] && c == map[i+1][j] && c == map[i+1][j+1]) {
                        // 4칸 모두 true로 마킹 (겹치는 부분도 자연스럽게 true 덮어쓰기 됨)
                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j] = true;
                        check[i+1][j+1] = true;
                        isPang = true; // 터트릴 게 하나라도 있음을 기록
                    }
                }
            }

            // 💡 더 이상 터트릴 블록이 없으면 무한 루프 탈출! (게임 종료)
            if (!isPang) break;

            // 3단계: 마킹된 블록 무자비하게 폭파 (카운트 증가 + 빈칸 '-' 처리)
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        answer++;
                        map[i][j] = '-';
                    }
                }
            }

            // 4단계: 🚨 대망의 중력 작용 (Gravity) 🚨
            // 가로(행)가 아니라 세로(열) 기준으로, '밑에서부터 위로' 훑어 올라갑니다!
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '-') { // 빈칸을 발견했다면?
                        // 그 빈칸 바로 위부터 꼭대기까지 탐색해서 '진짜 블록'을 찾습니다.
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != '-') { // 진짜 블록을 찾았다!
                                map[i][j] = map[k][j]; // 빈칸 자리로 블록을 끌어내림
                                map[k][j] = '-';       // 끌어내린 원래 자리는 다시 빈칸으로
                                break; // 하나 내렸으니, 다음 빈칸(i)을 찾으러 반복문 탈출!
                            }
                        }
                    }
                }
            }
        } // while 끝

        return answer;
    }
}