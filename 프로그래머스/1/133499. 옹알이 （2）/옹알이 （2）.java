class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String s : babbling) {
            // 1. 연속 발음("ayaaya" 등)이 있으면 바로 탈락! (문제의 핵심 조건)
            if(s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) {
                continue;
            }

            // 2. 발음 가능한 단어를 " " (공백)으로 치환
            // 중요: ""(빈문자열)로 바꾸면 글자가 붙어서(wyeoo -> woo) 오답이 됨!
            s = s.replace("aya", " ");
            s = s.replace("ye", " ");
            s = s.replace("woo", " ");
            s = s.replace("ma", " "); // 여기서 s 변수에 다시 담아야 함!

            // 3. 공백을 싹 제거했을 때 길이가 0이면 성공
            if(s.replace(" ", "").equals("")) {
                answer++;
            }
        }
        return answer;
    }
}