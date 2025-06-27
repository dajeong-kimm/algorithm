import java.util.*;

class Solution {
    public int[] solution(int[] price) {
        int n = price.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] answer = new int[n];
        
        for (int i=1;i<n;i++) {
            while(!stack.isEmpty() && price[i] < price[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i-j;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n-1-j;
        }
        return answer;
    }
}