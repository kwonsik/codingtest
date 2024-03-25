class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<delete_list.length;j++){
                if(arr[i]==delete_list[j]){cnt++;}
            }
        }
        answer=new int[arr.length-cnt];
        cnt=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<delete_list.length;j++){
                if(arr[i]==delete_list[j]){cnt++;}
                
            }
            if(cnt==0){
                    for(int k=0;k<answer.length;k++){
                        if(answer[k]==0){answer[k]=arr[i];break;}
                    }
                }
            cnt=0;
            
        }
        
        return answer;
    }
}