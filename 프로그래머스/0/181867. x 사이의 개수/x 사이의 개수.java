import java.util.Arrays;
class Solution {
    public int[] solution(String myString) {
        return Arrays.stream(myString.split("x",myString.length()))
            .mapToInt(x -> x.length())
            .toArray();
    }
}