class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int number = 0;
        for (int i=0;i<included.length;i++){
            number = a+d*i;
            if (included[i]==true) answer += number;
        }
        return answer;
    }
}