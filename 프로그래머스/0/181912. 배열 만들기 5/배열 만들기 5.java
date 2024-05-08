import java.util.ArrayList;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=0;i<intStrs.length;i++){
            String tmp = intStrs[i].substring(s,s+l);
            int number = Integer.parseInt(tmp);
            if (number>k) al.add(number);
        }
        int[] answer = new int[al.size()];
        for (int i=0;i<al.size();i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}