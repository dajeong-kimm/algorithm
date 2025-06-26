import java.util.*;
class Solution {
    static int m, N;
    static int answer = 0;
    static boolean[] visited;
    static int[][] Q;
    static int[] Ans;
    static Set<Integer> setList[];
    static int[] number;
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        m = q.length;
        visited = new boolean[n+1];
        Q = q;
        Ans = ans;
        
        //query에서 사용된 숫자 set 
        setList = new HashSet[m];
        for (int i=0;i<m;i++){
            setList[i] = new HashSet<>();
            for (int j=0;j<5;j++){
                setList[i].add(q[i][j]);
            }
        }
        
        number = new int[5];
        for (int i=1;i<=N-5+1;i++){
            numberList(number, 0, i);
        }
        
        return answer;
    }
    static void numberList(int[] number, int idx, int curNum) {
        number[idx] = curNum;
        
        if (idx == 4) {
            testNum(number);
            return;
        }
        
        for (int num=curNum+1;num<=N;num++) {
            if (!visited[num]) {
                visited[num] = true;
                numberList(number, idx+1, num);
                visited[num] = false;
            }
        }
    }
    
    static void testNum(int[] number) {
        for (int i=0;i<m;i++){
            int cnt = 0;
            for (int j=0;j<5;j++){
                if (setList[i].contains(number[j])) cnt++;
            }
            if (cnt != Ans[i]) return;
        }
        answer++;
    }
}