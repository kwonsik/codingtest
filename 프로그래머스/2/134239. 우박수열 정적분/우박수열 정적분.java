import java.util.*;

class Solution {
    List<Double> list = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        // 우박수열 구하기
        int cnt=0;
        while(true) {
            list.add((double)k);
            if(k%2==0) {
                k /= 2;
            } else {
                k = 3*k +1;
            }
            cnt++;
            if(k==1) {
                list.add((double)k);
                break;
            }
            
        }
        for(int i=0; i<ranges.length; i++) {
            answer[i] = calc(ranges[i][0], list.size() + ranges[i][1] - 1);
        }
        
        return answer;
    }
    // 정적분 구하기
    public double calc(int from, int to) {
        double result = 0;
        // 예외 처리
        if(from>to) {
            return -1.0;
        }
        
        for(int i=from; i<to; i++) {
            // 넓이 구하기
            result += (list.get(i) + list.get(i+1))/2;
        }
        return result;
    }
}