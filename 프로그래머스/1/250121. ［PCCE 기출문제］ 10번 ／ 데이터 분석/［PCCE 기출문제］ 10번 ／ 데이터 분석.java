import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int index[] = new int[data.length];
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            if("code".equals(ext)) {
                if(data[i][0] < val_ext) {
                    list.add(data[i]);
                }
            } else if("date".equals(ext)) {
                if(data[i][1] < val_ext) {
                    list.add(data[i]);
                }
            } else if("maximum".equals(ext)) {
                if(data[i][2] < val_ext) {
                    list.add(data[i]);
                }
            } else if("remain".equals(ext)) {
                if(data[i][3] < val_ext) {
                    list.add(data[i]);
                }
            }
        }
        
        int tempIdx = 0; 
        if ("code".equals(sort_by)) {
            tempIdx = 0;
        } else if ("date".equals(sort_by)) {
            tempIdx = 1;
        } else if ("maximum".equals(sort_by)) {
            tempIdx = 2;
        } else if ("remain".equals(sort_by)) {
            tempIdx = 3;
        }  
        
        final int sortIdx = tempIdx;
        
        list.sort((a, b) -> a[sortIdx] - b[sortIdx]);   
        
        return list.toArray(new int[0][]);
    }
}