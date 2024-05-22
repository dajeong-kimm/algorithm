class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int min_x = dots[0][0];
        int max_x = dots[0][0];
        int min_y = dots[0][1];
        int max_y = dots[0][1];
        
        for (int i=1;i<4;i++){
            min_x = Math.min(min_x,dots[i][0]);
            max_x = Math.max(max_x,dots[i][0]);
            min_y = Math.min(min_y,dots[i][1]);
            max_y = Math.max(max_y,dots[i][1]);
        }
        
        answer = (max_y-min_y)*(max_x-min_x);
        return answer;
    }
}