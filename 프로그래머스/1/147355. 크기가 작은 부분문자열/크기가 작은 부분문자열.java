class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int t_len = t.length();
        int p_len = p.length();
        long p_num = Long.parseLong(p);
        for (int i=0;i<t_len-p_len+1;i++){
            String tmp = t.substring(i,i+p_len);
            long tmp_num = Long.parseLong(tmp);
            if (tmp_num<=p_num) answer += 1;
            
        }
        return answer;
    }
}