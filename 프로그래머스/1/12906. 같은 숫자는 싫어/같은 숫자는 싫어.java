import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int a : arr) {
            if (stack.size()==0) stack.push(a);
            else {
                if (stack.peek() != a) stack.push(a);
            }
        }
        answer = new int[stack.size()];
        for (int i=0;i<answer.length;i++){
            answer[i] = stack.get(i);
        }

        return answer;
    }
}