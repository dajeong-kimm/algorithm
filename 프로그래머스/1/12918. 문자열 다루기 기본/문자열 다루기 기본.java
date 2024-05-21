class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length()==4 || s.length()==6){
            int tmp = 0;
            for (int i=0;i<s.length();i++){
                if ('0'<=s.charAt(i) && s.charAt(i)<='9') tmp += 1;
            }
            if (tmp == s.length()) return true;
        }
        return false;
    }
}