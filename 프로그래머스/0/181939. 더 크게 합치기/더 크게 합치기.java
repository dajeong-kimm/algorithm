class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int num1 = Integer.parseInt(a+""+b);
        int num2 = Integer.parseInt(b+""+a);
        answer = num1>num2?num1:num2;
        return answer;
    }
}