import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        answer = new int[set.size()];
        Iterator iter = set.iterator();
        int index = 0;
        while(iter.hasNext()){
            answer[index] = (int)iter.next();
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}