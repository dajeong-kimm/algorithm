import java.util.*;
/**
괄호가 개수는 맞지만 짝이 맞지 않은 형태로 작성되어 오류
모든 괄호를 뽑아서 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램

개수가 같다면 : 균형잡힌 괄호 문자열
짝도 모두 맞다면 : 올바른 괄호 문자열
*/
class Solution {
    public String solution(String p) {
        return executeMini(p);
    }
    
    String executeMini(String w){
        //1. 빈 문자열인 경우, 빈 문자열 반환
        if (w.length() == 0) return "";
        
        //2. w를 두 "균형잡힌 괄호 문자열" u,v로 분리
        int a = 0;
        int b = 0;
        StringBuilder sb = new StringBuilder();
        int i;
        for (i=0;i<w.length();i++){
            char ch = w.charAt(i);
            if (ch == '(') a++;
            else b++;
            
            sb.append(ch);
            
            if (a == b) break;
        }
        String u = sb.toString();
        String v = w.substring(i+1, w.length());
        
        //u가 올바른 괄호 문자열이라면
        if (isCorrect(u)){
            return u+executeMini(v);
        } 
        //u가 올바른 괄호 문자열이 아니라면
        else {
            String tmp = executeMini(v);
            sb = new StringBuilder();
            for (i=1;i<u.length()-1;i++){
                if (u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
                
            }
            return "(" + tmp + ")" + sb.toString();
        }
    }
    
    //올바른 괄호 문자열인지 판단 
    boolean isCorrect(String str){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if (ch == '('){
                stack.add(ch);
            } else {
                if (stack.size() == 0) return false;
                if (stack.peek() == '(') stack.pop();
            }
        }
        
        if (stack.size() == 0) return true;
        return false;
    }
}