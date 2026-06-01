import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = getGCD(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for(int i = 1; i < arrayB.length; i++) {
            gcdB = getGCD(gcdB, arrayB[i]);
        }
        
        int ansA = canDivide(gcdA, arrayB) ? gcdA : 0;
        int ansB = canDivide(gcdB, arrayA) ? gcdB : 0;
        
        return Math.max(ansA, ansB);
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private boolean canDivide(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) return false; 
        }
        return true;
    }
}