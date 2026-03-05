class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = 51;
        int maxX = 0;
        int minY = 51;
        int maxY = 0;
        for(int i=0; i< wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {                  
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                    maxY = Math.max(maxY, i);
                    maxX = Math.max(maxX, j);
                }
            }
        }
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;
        return answer;
    }
}