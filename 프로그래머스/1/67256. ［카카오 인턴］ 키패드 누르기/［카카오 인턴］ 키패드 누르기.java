import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<String, int[]> map = new HashMap<>();
        map.put("1", new int[]{0, 0}); map.put("2", new int[]{0, 1}); map.put("3", new int[]{0, 2});
        map.put("4", new int[]{1, 0}); map.put("5", new int[]{1, 1}); map.put("6", new int[]{1, 2});
        map.put("7", new int[]{2, 0}); map.put("8", new int[]{2, 1}); map.put("9", new int[]{2, 2});
        map.put("*", new int[]{3, 0}); map.put("0", new int[]{3, 1}); map.put("#", new int[]{3, 2});
        String answer = "";
        String left = "*";
        String right = "#";
        StringBuilder sb = new StringBuilder();   
        
        for(int i=0; i<numbers.length; i++) {
            String str = String.valueOf(numbers[i]);
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = str;
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = str;
            } else {                    
                int[] leftPos = map.get(left);
                int[] rightPos = map.get(right);
                int[] targetPos = map.get(str);
                
                int leftDist = Math.abs(leftPos[0] - targetPos[0]) + Math.abs(leftPos[1] - targetPos[1]);
                int rightDist = Math.abs(rightPos[0] - targetPos[0]) + Math.abs(rightPos[1] - targetPos[1]);
                
                if (leftDist < rightDist) {
                    sb.append("L");
                    left = str;
                } else if (rightDist < leftDist) {
                    sb.append("R");
                    right = str;
                } else {
                    if ("right".equals(hand)) {
                        sb.append("R");
                        right = str;
                    } else {
                        sb.append("L");
                        left = str;
                    }
                }
            }
        }
        return sb.toString();
    }
}