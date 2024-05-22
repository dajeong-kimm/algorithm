import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<String>();
        char[] ch = s.toCharArray();
        for (char c : ch){
            if (c=='(') stack.push("(");
            else {
                if (stack.size()==0) return false;
                else {
                    stack.pop();
                }
            }
        }
        if (stack.size()>0) return false;
        return true;
        
    }
}