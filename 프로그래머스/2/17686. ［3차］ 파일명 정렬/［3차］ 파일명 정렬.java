import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 1. 자바 정렬 엔진(Arrays.sort) 호출 + 람다식 주입
        Arrays.sort(files, (s1, s2) -> {
            // A. 두 파일명을 HEAD와 NUMBER로 분리 (Helper 메서드 호출)
            String[] f1 = split(s1);
            String[] f2 = split(s2);

            // B. HEAD 비교 (대소문자 무시)
            int headComp = f1[0].compareToIgnoreCase(f2[0]);

            // C. HEAD가 같을 경우에만 NUMBER 비교
            if (headComp == 0) {
                int num1 = Integer.parseInt(f1[1]);
                int num2 = Integer.parseInt(f2[1]);
                // 숫자를 오름차순으로 비교
                return Integer.compare(num1, num2);
            }

            // D. HEAD가 다르면 그 결과를 반환
            return headComp;
        });

        return files;
    }

    // 2. 문자열을 HEAD와 NUMBER로 쪼개는 "착한" Helper 메서드 (StringBuilder 적용)
    private String[] split(String s) {
        StringBuilder head = new StringBuilder();
        StringBuilder num = new StringBuilder();
        int i = 0;

        // 숫자가 나오기 전까지는 HEAD
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) break;
            head.append(c);
        }

        // 숫자 구간 (최대 5자)
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) && num.length() < 5) {
                num.append(c);
            } else break;
        }

        return new String[]{head.toString(), num.toString()};
    }
}