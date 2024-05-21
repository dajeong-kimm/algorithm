class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        int answer_size = 0;
        if (my_str.length() %n == 0) answer_size = my_str.length()/n;
        else answer_size = my_str.length()/n + 1;
        
        answer = new String[answer_size];
        
        for (int i=0;i<answer_size;i++){
            int start = i*n;
            int end = (start+n>my_str.length()) ? my_str.length() : start+n;
            answer[i] = my_str.substring(start,end);
        }
        
        
        return answer;
    }
}