class Solution {
    public int solution(int n) {
        int answer = 0;
        String a = "";
        while (n>0) {
            a = (n%3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();
        
        answer = Integer.parseInt(a,3);
        
        return answer;
    }
}