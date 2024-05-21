class Solution {
    public String solution(String s) {
        String answer = "";
        int[] alpha = new int[26];
        for (char c : s.toCharArray()){
            alpha[c-'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<26;i++){
            if (alpha[i] == 1) {
                sb.append((char)(i+'a'));
            }
        }
        answer = sb.toString();
        return answer;
    }
}