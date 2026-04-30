class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String str = Long.toString(numbers[i], 2);
                // 가장 오른쪽에 있는 0을 찾기?
                int zeroIdx = str.lastIndexOf("0"); 

if (zeroIdx == -1) {
    
    str = "10" + str.substring(1); 
} else {
    
    str = str.substring(0, zeroIdx) + "10" + str.substring(zeroIdx + 2);
}

                answer[i] = Long.parseLong(str, 2);
            }

        }
        return answer;
    }
}