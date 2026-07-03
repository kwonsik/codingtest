import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);
        
        List<int[]> chunks = new ArrayList<>();

        for (int i = 0; i < maxMinerals; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            
            for (int j = i; j < i + 5 && j < maxMinerals; j++) {
                if (minerals[j].equals("diamond")) dia++;
                else if (minerals[j].equals("iron")) iron++;
                else stone++;
            }
            
            int stoneCost = dia * 25 + iron * 5 + stone * 1;
            
            chunks.add(new int[]{dia, iron, stone, stoneCost});
        }

        chunks.sort((a, b) -> b[3] - a[3]);

        for (int[] chunk : chunks) {
            if (picks[0] > 0) { 
                answer += chunk[0] * 1 + chunk[1] * 1 + chunk[2] * 1;
                picks[0]--;
            } else if (picks[1] > 0) { 
                answer += chunk[0] * 5 + chunk[1] * 1 + chunk[2] * 1;
                picks[1]--;
            } else if (picks[2] > 0) { 
                answer += chunk[0] * 25 + chunk[1] * 5 + chunk[2] * 1;
                picks[2]--;
            }
        }

        return answer;
    }
}