import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int money : d) {
            if (budget-money>=0){
                budget -= money;
                answer += 1;
            } else break;
        }
        return answer;
    }
}