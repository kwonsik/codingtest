class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int cnt = brown + yellow;
        int w = 0;
        int h = 0;
        for(int i=1; i*i<=cnt; i++) {
            if(cnt % i == 0) {
                w = i;
                h = cnt/i;
                int tempBrown = w * h - (w-2) * (h-2);
                if(tempBrown == brown) {
                    answer[0] = h;
                    answer[1] = w;
                    break;
                }
            }
        }
        return answer;
    }
}