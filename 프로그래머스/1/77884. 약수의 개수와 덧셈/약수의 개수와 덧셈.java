class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            boolean isEven = true;
            for(int j=1; j<=i; j++) {
                if(i <= j*j) {
                        if(i == j*j) {
                            isEven = false;
                        }
                        break;
                    }
            }
            if(isEven) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}