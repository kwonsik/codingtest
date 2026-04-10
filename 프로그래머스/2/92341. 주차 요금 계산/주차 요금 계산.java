import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        Set<String> carSet = new HashSet<>();

        for(String str : records) {
            String[] split = str.split(" ");
            String[] timeSplit = split[0].split(":");
            int time = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]); 
            String carNum = split[1];
            carSet.add(carNum);

            if("IN".equals(split[2])) {
                inMap.put(carNum, time);
            } else {
                int inTime = inMap.remove(carNum);
                int duration = time - inTime;
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + duration);
            }
        }

        for(String carNum : inMap.keySet()) {
            int inTime = inMap.get(carNum);
            int duration = (23 * 60 + 59) - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + duration);
        }

        // 차량 번호 오름차순 정렬
        List<String> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);

        int[] answer = new int[sortedCars.size()];
        for(int i = 0; i < sortedCars.size(); i++) {
            String carNum = sortedCars.get(i);
            int totalTime = totalTimeMap.get(carNum);
            
            int fee = fees[1];
            if(totalTime > fees[0]) {
                int extraTime = totalTime - fees[0];
                fee += Math.ceil((double)extraTime / fees[2]) * fees[3];
            }
            answer[i] = fee;
        }
        
        return answer;
    }
}