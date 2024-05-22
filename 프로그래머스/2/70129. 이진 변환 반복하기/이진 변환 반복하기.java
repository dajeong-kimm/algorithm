class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int count = 0;
        int zero = 0;
        while (!s.equals("1")) {
            count += 1;
            int new_s = 0;
            for (int i=0;i<s.length();i++){
                if (s.charAt(i) == '1') new_s += 1;
                else zero += 1;
            }
            s = Integer.toBinaryString(new_s);
            
            
        }
        return new int[]{count,zero};
    }
}