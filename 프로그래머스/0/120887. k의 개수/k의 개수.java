class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int x=i;x<=j;x++){
            String[] str = String.valueOf(x).split("");
            for (String s : str){
                if (Integer.parseInt(s) == k) answer += 1;
            }
        }
        return answer;
    }
}