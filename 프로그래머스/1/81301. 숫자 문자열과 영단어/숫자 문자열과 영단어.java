class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] array = {};
        array = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i=0;i<array.length;i++){
            String tmp = String.valueOf(i);
            s = s.replaceAll(array[i],tmp);
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}