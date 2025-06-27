import java.util.*;
class Solution {
    static int answer = 0;
    static int N;
    static int Target;
    static int[] Numbers;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        Target = target;
        Numbers = numbers;
        
        calc(0,0);
        return answer;
    }
    
    static void calc(int idx, int cur) {
        if (idx == N) {
            if (cur == Target) answer++;
            return;
        }
        
        calc(idx+1, cur-Numbers[idx]);
        calc(idx+1, cur+Numbers[idx]);
    }
}