class Solution {
    public String solution(int[] food) {
        String answer = "";
        int num = 0;
        for (int f : food) {
            if (f>1) {
                int tmp = f/2;
                for (int i=0;i<tmp;i++){
                    answer += String.valueOf(num);
                }
            }
            num += 1;
        }
        answer += "0";
        for (int i=answer.length()-2;i>=0;i--){
            answer += answer.charAt(i);
        }
        return answer;
    }
}