class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n<m) {
            if(m%n == 0) {
                answer[0] = n;
                answer[1] = m;
            } else {
                int max = 1;
                for(int i=1; i<=m/2; i++) {
                    if(n%i == 0 && m%i ==0) {
                        max = i;
                    }
                }
                answer[0] = max;
                answer[1] = m*n/max;
            }
        } else {
            if(n%m == 0) {
                answer[0] = m;
                answer[1] = n;
            } else {
                int max = 1;
                for(int i=1; i<=n/2; i++) {
                    if(n%i == 0 && m%i ==0) {
                        max = i;
                    }
                }
                answer[0] = max;
                answer[1] = m*n/max;
            }
        }
        return answer;
    }
}