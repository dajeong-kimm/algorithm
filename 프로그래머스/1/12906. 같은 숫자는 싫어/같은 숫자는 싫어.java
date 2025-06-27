import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        
        int n = arr.length;
        for (int i=1;i<n;i++) {
            if (arr[i] == stack.peek()) continue;
            stack.add(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        for (int i=answer.length-1;i>=0;i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}