import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int cnt1[] = new int [10];
        int cnt2[] = new int [10];
        int arr[] = new int [10];
        int allCnt = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<X.length(); i++) {
            int temp = Integer.valueOf(X.charAt(i)) - 48;
            cnt1[temp]++;
        }
        for(int i=0; i<Y.length(); i++) {
            int temp = Integer.valueOf(Y.charAt(i)) - 48;
            cnt2[temp]++;
        }
        System.out.println("cnt1 : " + Arrays.toString(cnt1));
        System.out.println("cnt2 : " + Arrays.toString(cnt2));
        for(int i=0; i<cnt1.length; i++) {
            arr[i] = Math.min(cnt1[i],cnt2[i]);
        }
        System.out.println("arr : " + Arrays.toString(arr));
        for(int i=0; i<arr.length; i++) {
            int cnt = arr[i];
            while(cnt!=0) {
                list.add(i);
                cnt--;
                allCnt++;
                sum += i;
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        for(Integer i : list) {
            sb.append(i);
        }
        if(allCnt == 0) {
            answer = "-1";
        } else if(sum == 0) {
            answer = "0";
        } else {
            answer = sb.toString();
        }
        return answer;
    }
}