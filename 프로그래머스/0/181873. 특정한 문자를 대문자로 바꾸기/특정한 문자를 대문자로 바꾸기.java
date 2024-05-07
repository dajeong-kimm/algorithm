class Solution {
    public String solution(String my_string, String alp) {
        String up = alp.toUpperCase();
        return my_string.replaceAll(alp,up);
    }
}