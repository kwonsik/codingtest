class Solution {
    // 0과 1의 개수를 누적할 전역 변수 (배낭)
    int zeroCount = 0;
    int oneCount = 0;

    public int[] solution(int[][] arr) {
        // 1. 대항해의 시작: (0, 0) 좌표에서 전체 배열의 크기(arr.length)만큼 탐색을 시작합니다.
        quadTree(arr, 0, 0, arr.length);
        
        return new int[]{zeroCount, oneCount};
    }

    // 💡 핵심 로직: 쿼드 트리 재귀 함수
    public void quadTree(int[][] arr, int x, int y, int size) {
        
        // [STEP 1] 검사 (Check): 현재 잘라낸 색종이가 모두 같은 색깔인가?
        if (checkUniform(arr, x, y, size)) {
            // 모두 같은 색이라면 압축 성공! 해당 색깔의 카운트를 올리고 쿨하게 방을 나갑니다 (Return).
            if (arr[x][y] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return; 
        }

        // [STEP 2] 분할 (Divide): 색이 하나라도 섞여 있다면 가위로 반을 자릅니다!
        int newSize = size / 2;

        // [STEP 3] 정복 (Recurse): 잘라진 4개의 색종이(평행우주)로 각각 다시 진입합니다.
        // x는 세로(행), y는 가로(열)를 의미합니다.
        quadTree(arr, x, y, newSize);                     // 1. 왼쪽 위 사분면
        quadTree(arr, x, y + newSize, newSize);           // 2. 오른쪽 위 사분면 (가로로 newSize만큼 이동)
        quadTree(arr, x + newSize, y, newSize);           // 3. 왼쪽 아래 사분면 (세로로 newSize만큼 이동)
        quadTree(arr, x + newSize, y + newSize, newSize); // 4. 오른쪽 아래 사분면 (가로, 세로 모두 이동)
    }

    // 💡 도우미 함수: 주어진 구역이 모두 같은 숫자인지 판별
    public boolean checkUniform(int[][] arr, int x, int y, int size) {
        // 구역의 가장 첫 번째(왼쪽 위) 값을 기준점으로 삼습니다.
        int firstValue = arr[x][y]; 
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 기준점과 하나라도 다른 숫자가 튀어나오면?
                if (arr[i][j] != firstValue) {
                    return false; // "섞여 있어! 가위 가져와!" (압축 불가)
                }
            }
        }
        return true; // 끝까지 무사히 돌았다면 모두 같은 색깔!
    }
}