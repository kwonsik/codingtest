class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        // 1단계: 모든 대문자를 소문자로
        answer = answer.toLowerCase();
        
        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        answer = answer.replaceAll("[^a-z0-9_.-]", "");
        
        // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        // [.]+ 는 마침표가 1개 이상 연속됨을 의미합니다.
        answer = answer.replaceAll("[.]+", ".");
        
        // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
        // ^[.] (시작 마침표) | (또는) [.]$ (끝 마침표)
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5단계: 빈 문자열이라면, "a"를 대입
        if("".equals(answer)) {
            answer = "a";
        }        
        
        // 6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            // 자르고 났더니 끝에 마침표가 남아있다면? 다시 정규식으로 끝 마침표만 날려줍니다.
            answer = answer.replaceAll("[.]$", ""); 
        }
        
        // 7단계: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복
        if(answer.length() <= 2) {
            char lastChar = answer.charAt(answer.length() - 1); 
            while(answer.length() < 3) {
                answer += lastChar;
            }
        }
        
        return answer;
    }
}