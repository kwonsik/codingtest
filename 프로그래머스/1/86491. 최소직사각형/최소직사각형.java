class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int small=0;
        int big=0;
        int max1=0;
        int max2=0;
        
        for(int i=0; i<sizes.length; i++) {
            // 각각 작은 수, 큰 수 순으로 정렬
            if(sizes[i][0] > sizes[i][1]) {
                small = sizes[i][1];
                big = sizes[i][0];
                sizes[i][0] = small;
                sizes[i][1] = big;
            }
            // 앞, 뒤의 최대값 뽑기
            if(sizes[i][0] > max1) {
                max1 = sizes[i][0];
            }
            if(sizes[i][1] > max2) {
                max2 = sizes[i][1];
            }         
        }
        answer = max1 * max2;
        return answer;
    }
}