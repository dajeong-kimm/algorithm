import java.util.*;
/**
1) 자연수만 존재
2) 모든 수를 1 2 4 만 사용해서 표현

*/
class Solution {
    String[] arr = {"1","2","4"};
    public String solution(int n) {
        String answer = "";
        StringBuilder makeNum = new StringBuilder();
        
        while (n>0){
            int remain = n%3;
            if (remain == 1) {
                makeNum.append("1");
            } else if (remain == 2){
                makeNum.append("2");
            } else {
                makeNum.append("4");
                
            }
            n = (n-1)/3;
        }
        
        return makeNum.reverse().toString();
    }
}