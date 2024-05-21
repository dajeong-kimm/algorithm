class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left;i<=right;i++){
            if (count_divide(i)%2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    private int count_divide(int num){
        int answer = 0;
        for (int i=1;i<=num;i++){
            if (num%i==0) answer += 1;
        }
        return answer;
    }
}