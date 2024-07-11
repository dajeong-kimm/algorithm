import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double sumValue = Arrays.stream(numbers).sum();
        answer = sumValue/numbers.length;
        return answer;
    }
}