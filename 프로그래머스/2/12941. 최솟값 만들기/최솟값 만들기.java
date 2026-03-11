import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int arr1[] = new int[A.length];
        
        arr1 = A;
        int arr2[] = new int[B.length];;
        int cnt=0;
        for(int i=B.length-1; i>=0; i--) {
            arr2[cnt] = B[i];
            cnt++;
        }
        
        for(int i=0; i<arr1.length; i++) {
            
            answer += arr1[i] * arr2[i];   
        }  
        
        return answer;
    }
}