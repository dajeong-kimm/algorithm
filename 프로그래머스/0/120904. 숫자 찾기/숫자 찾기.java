class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String num_str = String.valueOf(num);
        String k_str = String.valueOf(k);
        
        answer = num_str.indexOf(k_str);
        
        return answer<0 ? -1:answer+1;
    }
}