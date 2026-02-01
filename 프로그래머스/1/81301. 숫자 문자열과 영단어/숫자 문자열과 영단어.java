class Solution {
    public int solution(String s) {
        // 1. 영단어 배열 (인덱스와 값이 일치하도록 배치)
        // words[0] = "zero", words[1] = "one" ...
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // 2. 0부터 9까지 돌면서 해당 영단어가 있으면 숫자로 바꿈
        for(int i = 0; i < words.length; i++) {
            // 예: s가 "one4seveneight"일 때
            // i=1이면: s.replaceAll("one", "1") -> "14seveneight"
            // i=7이면: s.replaceAll("seven", "7") -> "147eight"
            s = s.replaceAll(words[i], Integer.toString(i));
        }
        
        // 3. 문자열을 정수로 변환해서 리턴
        return Integer.parseInt(s);
    }
}