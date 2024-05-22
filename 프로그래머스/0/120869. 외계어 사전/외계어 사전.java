class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        for (String d : dic) {
            int tmp = 0;
            for (String s : spell){
                if (d.contains(s)) tmp += 1;
            }
            if (tmp == spell.length) return 1;
        }
        return 2;
    }
}