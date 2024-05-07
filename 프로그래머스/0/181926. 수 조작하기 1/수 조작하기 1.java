class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for (char s:control.toCharArray()){
            if (s == 'w') answer += 1;
            else if (s == 's') answer -= 1;
            else if (s == 'd') answer += 10;
            else answer -= 10;
        }
        return answer;
    }
}