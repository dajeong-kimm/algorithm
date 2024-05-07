class Solution {
    public int solution(int[] num_list) {
        int cross = 1;
        int square = 0;
        for (int num:num_list){
            cross *= num;
            square += num;
        }
        square *= square;
        return (cross<square?1:0);
    }
}