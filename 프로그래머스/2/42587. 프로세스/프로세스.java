import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char ch = 'A';
        char target = ' '; 
        for(int i=0; i<priorities.length; i++) {
            stack.push(ch);
            map1.put(ch, priorities[i]);
            ch++;
        }
        target = stack.get(location);
        Arrays.sort(priorities);
        for(int i : priorities) {
            list.add(i);
        }
        int cnt = 1;
        while(stack.size() != 0) {
            int i = map1.get(stack.get(0));
            if(i == list.get(list.size()-1)) {
                map2.put(stack.get(0), cnt);
                stack.remove(0);
                list.remove(list.size()-1);
                cnt++;
            } else {
                stack.push(stack.get(0));
                stack.remove(0);          
            }
            
        }
        System.out.println(map2.get(target));

        answer = map2.get(target);
        
        return answer;
    }
}