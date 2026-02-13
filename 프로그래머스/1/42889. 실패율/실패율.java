import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 스테이지별 머물러 있는 사람 수 구하기
        int[] count = new int[N + 2];
        for (int s : stages) {
            count[s]++;
        }

        // 2. [스테이지 번호, 실패율]을 담을 2차원 배열 만들기
        double[][] failInfo = new double[N][2];
        double remainingPlayers = stages.length; // 해당 스테이지에 도달한 전체 인원

        for (int i = 1; i <= N; i++) {
            failInfo[i - 1][0] = i; // 첫 번째 칸: 스테이지 번호
            
            if (remainingPlayers == 0) {
                failInfo[i - 1][1] = 0; // 도달한 사람이 없으면 실패율은 0
            } else {
                failInfo[i - 1][1] = count[i] / remainingPlayers; // 두 번째 칸: 실패율
                remainingPlayers -= count[i]; // 다음 스테이지 도달 인원에서 현재 탈락자 제외
            }
        }

        // 3. 정렬하기 (이 부분만 조금 집중해서 봐주세요!)
        Arrays.sort(failInfo, (a, b) -> {
            if (a[1] == b[1]) {
                // 실패율이 같으면 스테이지 번호(0번 칸) 기준 오름차순
                return Double.compare(a[0], b[0]);
            }
            // 실패율(1번 칸) 기준 내림차순
            return Double.compare(b[1], a[1]);
        });

        // 4. 정렬된 결과에서 스테이지 번호만 꺼내서 정답 배열에 담기
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failInfo[i][0];
        }

        return answer;
    }
}