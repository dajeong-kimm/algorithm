import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int N = citations.length;
        Arrays.sort(citations);
        for (int i=0;i<N;i++) {
            int h = citations[N-1-i];
            int upper = i+1;
            answer = Math.max(answer, Math.min(upper, h));
            
        }
        return answer;
    }
}