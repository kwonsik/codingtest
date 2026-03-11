class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int result = 0;
        int sum = 0;
        int cnt = 0;
        int length1 = s.length(); // replaceAll 전 길이
        int length2 = s.length(); // replaceAll 후 길이
        String str = s;
        // 1이 될 때까지 반복
        while(true) {
            length1 = str.length(); // 초기화
            str = str.replaceAll("0", ""); // 0 제거
            
            length2 = str.length();
            sum += length1 - length2; // 0 갯수 더하기
            
            // 이진변환
            str = Integer.toBinaryString(length2);   
            cnt++;
            if("1".equals(str)) {
                break;
            }
            
        }
        answer[0] = cnt;
        answer[1] = sum;
        return answer;
    }
    
}