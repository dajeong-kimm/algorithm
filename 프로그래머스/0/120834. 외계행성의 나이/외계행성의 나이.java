class Solution {
    public String solution(int age) {
        String answer = "";
        String[] age_list = {"a","b","c","d","e","f","g","h","i","j"};
        while (age>0){
            answer = age_list[age%10]+answer;
            age = age/10;
        }
        return answer;
    }
}