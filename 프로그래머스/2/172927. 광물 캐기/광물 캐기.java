import java.util.*;
class Solution {
    static int answer;
    static int[] Picks;
    static String[] Minerals;
    static int N;
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        Picks = picks;
        Minerals = minerals;
        N = minerals.length;
        
        mine(0, 0);
        return answer;
    }
    
    static void mine(int curIdx, int sleep) {
        
        if (curIdx>= N) {
            answer = Math.min(answer, sleep);
            return;
        }
        
        if (sleep > answer) return; //이미 크다면 가지치기
        
        boolean flag = false;
        
        //다이아
        if (Picks[0] > 0) {
            int newSleep = sleep + getSleep(curIdx, 0);
            Picks[0]--;
            mine(curIdx+5, newSleep);
            Picks[0]++;
            flag = true;
        }
        
        //철
        if (Picks[1] > 0) {
            int newSleep = sleep + getSleep(curIdx, 1);
            Picks[1]--;
            mine(curIdx+5, newSleep);
            Picks[1]++;
            flag = true;
        }
        
        //곡괭이
        if (Picks[2] > 0) {
            int newSleep = sleep + getSleep(curIdx, 2);
            Picks[2]--;
            mine(curIdx+5, newSleep);
            Picks[2]++;
            flag = true;
        }
        
        if (!flag) {
            answer = Math.min(answer, sleep);
        }
        
    }
    
    static int getSleep(int from, int which) {
        int result = 0;
        for (int i=from;i<=Math.min(from+4, N-1);i++){
            String cur = Minerals[i];
            if (which == 0) {
                if (cur.equals("diamond")){
                    result += 1;
                } else if (cur.equals("iron")) {
                    result += 1;
                } else {
                    result += 1;
                }
            } else if (which == 1) {
                if (cur.equals("diamond")){
                    result += 5;
                } else if (cur.equals("iron")) {
                    result += 1;
                } else {
                    result += 1;
                }
            } else {
                if (cur.equals("diamond")){
                    result += 25;
                } else if (cur.equals("iron")) {
                    result += 5;
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }
}