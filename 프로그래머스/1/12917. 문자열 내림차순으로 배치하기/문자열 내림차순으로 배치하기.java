import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] sol = s.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }
}