class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int cnt = 0;
        for (String st : str){
            cnt = (st.contains(" ")) ? 0 : cnt +1;
            answer += (cnt%2==1) ? st.toUpperCase() : st.toLowerCase();
        }
        return answer;
    }
}