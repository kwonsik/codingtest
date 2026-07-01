import java.util.*;

class Solution {
    // 3가지 연산자로 만들 수 있는 모든 우선순위 조합 (3! = 6가지)을 미리 정의
    private final String[][] priorities = {
        {"+", "-", "*"}, {"+", "*", "-"},
        {"-", "+", "*"}, {"-", "*", "+"},
        {"*", "+", "-"}, {"*", "-", "+"}
    };

    public long solution(String expression) {
        long maxResult = 0;

        // 데이터 분리
        List<Long> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        StringBuilder numSb = new StringBuilder();
        
        for(int i=0; i<expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '-' || ch == '+' || ch == '*') {
                operators.add(String.valueOf(ch));
                numbers.add(Long.parseLong(numSb.toString()));
                numSb.setLength(0);
            } else {
                numSb.append(ch);
            }
        }
        // 마지막 숫자 넣어주기
        numbers.add(Long.parseLong(numSb.toString()));
        // 6가지 우선순위 조합을 하나씩 적용
        for(String[] priority : priorities) {
            List<Long> newNumbers = new ArrayList<>(numbers);
            List<String> newOperators = new ArrayList<>(operators);
            for(String op : priority) {
                for(int i=0; i<newOperators.size(); i++) {
                    if(op.equals(newOperators.get(i))) {
                        Long result = calculate(newNumbers.get(i), newNumbers.get(i+1), op);
                        newNumbers.set(i, result);
                        newNumbers.remove(i+1);
                        newOperators.remove(i);
                        i--;
                    }
                }
            }
            maxResult = Math.max(maxResult, Math.abs(newNumbers.get(0)));
        }

        return maxResult;
    }

    // 순수 연산 수행 메서드
    private long calculate(long num1, long num2, String op) {
        switch (op) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
        }
        return 0;
    }
}