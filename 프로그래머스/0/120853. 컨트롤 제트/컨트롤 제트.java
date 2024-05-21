import java.util.*;
class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0;
        int tmp = 0;
        String[] strArray = s.split(" ");
        for (String i : strArray) {
            if (!i.equals("Z")){
                answer += Integer.parseInt(i);
                stack.push(Integer.parseInt(i));
            } else if (stack.size()>0) {
                tmp = stack.pop();
                answer -= tmp;
            }
        }
        return answer;
    }
}