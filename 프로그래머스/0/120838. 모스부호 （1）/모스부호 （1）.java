class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] req = letter.split(" ");
        for (int i=0;i<req.length;i++){
            for (int j=0;j<morse.length;j++){
                if (req[i].equals(morse[j])) {
                    answer += (char)(j+97);
                    break;}
                
            }
        }
        return answer;
    }
}