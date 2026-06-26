class Solution {
    public String solution(String p) {
        if (isCorrect(p)) {
            return p;
        }
        
        return convert(p);
    }

    // 재귀함수
    private String convert(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
        if (w.isEmpty()) {
            return "";
        }

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int balance = 0;
        int splitIdx = 0;
        for(int i=0; i<w.length(); i++) {
            char ch = w.charAt(i);
            if(ch == '(') {
                balance++;
            } else {
                balance--;
            }
            
            if(balance == 0) {
                splitIdx = i;
                break;
            }
        }
        String u = w.substring(0, splitIdx+1);
        String v = w.substring(splitIdx+1);
        
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
        if(isCorrect(u)) {
            return u + convert(v);
        } else {
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            StringBuilder sb = new StringBuilder();
            
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
            sb.append('(');
            
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
            sb.append(convert(v));
            
            // 4-3. ')'를 다시 붙입니다.
            sb.append(')');
            
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
            String temp = u.substring(1, u.length()-1);
            for(int i=0; i<temp.length(); i++) {
                char ch = temp.charAt(i);
                if(ch == '(') {
                    ch = ')';
                } else {
                    ch = '(';
                }
                sb.append(ch);
            }
            
            return sb.toString();
            
        }
    }

    // 올바른 괄호 문자열 판단 함수
    private boolean isCorrect(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}