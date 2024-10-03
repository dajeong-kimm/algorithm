import java.util.*;
/**
1) 철수가 가진 모든 숫자 나눌 수 있지만 ,, 영희가 가진 카드 나눌 수 없는 a
2) 영희가 가진 ~~ 나눌 수 있고 철수가 ~~ 나눌 수 없는 a

*/
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer1 = 0;
        int answer2 = 0;
        
        int N = arrayA.length;
        
        if (N == 1){
            int a = arrayA[0];
            int b = arrayB[0];
            
            if ((a%b) != 0) answer1 = a;
            if ((b%a) != 0) answer2 = b;
            
            return Math.max(answer1, answer2);
        }
        
        boolean flag1 = true;
        boolean flag2 = true;
        int num = 0;
        
        //A의 최대 공약수 찾기
        num = gcd(arrayA[0],arrayA[1]);
        for (int i=2;i<N;i++){
            num = gcd(num, arrayA[i]);
        }
        //arrayB의 어떤 수도 나누어 떨어지지 않으면?
        for (int i=0;i<N;i++){
            if (arrayB[i]%num == 0) {
                answer1 = 0;
                flag1 = false;
                break;
            } 
        }
        if (flag1) answer1 = num;
        
        num = gcd(arrayB[0], arrayB[1]);
        for (int i=2;i<N;i++){
            num = gcd(num, arrayB[i]);
        }
        //arrayA의 어떤 수도 나누어 떨어지지 않으면?
        for (int i=0;i<N;i++){
            if (arrayA[i]%num == 0) {
                answer2 = 0;
                flag2 = false;
                break;
            } 
        }
        
        if (flag2) answer2 = num;
        return Math.max(answer1, answer2);
    }
    
    //최대 공약수 구하기
    int gcd(int a, int b){
        if (a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        while (b>0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}