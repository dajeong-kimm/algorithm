class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] factorial = new int[11];
        factorial[0] = 1;
        factorial[1] = 1;
        factorial[2] = 2;
        for (int i=3;i<=10;i++){
            factorial[i] = factorial[i-1]*i;
        }
        for (int i=0;i<=10;i++){
            if (factorial[i] == n) answer = i;
            if (factorial[i]>n && factorial[i-1]<n) answer = i-1;
        }
        return answer;
    }
}