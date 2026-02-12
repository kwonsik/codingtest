class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int max1 = Math.max(wallet[0], wallet[1]);
        int min1 = Math.min(wallet[0], wallet[1]);
        int max2 = Math.max(bill[0], bill[1]);
        int min2 = Math.min(bill[0], bill[1]);
        int a = 0;
        int b = 0;
        while(true) {
            a = max2;
            b = min2;
            min2 = Math.min(a, b);
            max2 = Math.max(a, b);      
            if(max1 >= max2 && min1 >= min2) {
                break;
            } else {              
                max2 = max2 / 2;
                answer++;
            }
            
        }
        return answer;
    }
}