class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double sum_value = 0;
        for (int a : arr) sum_value += a;
        answer = sum_value / arr.length;
        return answer;
    }
}