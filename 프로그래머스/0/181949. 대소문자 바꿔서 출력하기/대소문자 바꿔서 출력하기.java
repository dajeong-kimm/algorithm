import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String answer = "";
        
        for (Character c : a.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += c.toUpperCase(c);
            } else {
                answer += c.toLowerCase(c);
            }
        }
        System.out.println(answer);
    }
}