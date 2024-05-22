class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int x = 2;
        int y = 0;
        int total = brown+yellow;
        while (true) {
            x += 1;
            if (total%x == 0){
                y = total/x;
                if ((x>=y) && (x-2)*(y-2) == yellow) break;
                
            } else continue;
        }
        return new int[]{x,y};
    }
}