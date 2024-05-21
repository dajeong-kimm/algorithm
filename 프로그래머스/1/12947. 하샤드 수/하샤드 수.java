class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String[] s = String.valueOf(x).split("");
        int position_sum = 0;
        for (String i : s) position_sum += Integer.parseInt(i);
        if (x%position_sum==0) answer = true;
        else answer = false;
        return answer;
    }
}