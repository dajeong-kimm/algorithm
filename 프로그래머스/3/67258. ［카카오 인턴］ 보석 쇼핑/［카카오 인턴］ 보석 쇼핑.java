import java.util.*;
/**
모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간
가장 짧은 구간이 여러개라면 시작 진열대 번호가 가장 작은 구간 return
*/
class Solution {
    public int[] solution(String[] gems) {
        int N = gems.length;
        
        HashSet<String> set = new HashSet<>();
        for (int i=0;i<N;i++){
            set.add(gems[i]);
        }
        
        int count = set.size();
        
        //가장 짧은 구간 저장
        int left = 0;
        int right = N-1;
        
        int L=0;
        int R=0;
        HashMap<String, Integer> map = new HashMap<>();
        while (R < N){
            String cur = gems[R];
            map.put(cur, map.getOrDefault(cur,0)+1);
            R++;
            
            //모든 보석 종류를 포함햇는지
            while (map.size() == count){
                if ((R-L-1) < (right-left)){
                    left = L;
                    right = R-1;
                }
                
                String leftGem = gems[L];
                map.put(leftGem, map.get(leftGem)-1);
                
                if (map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }
                L++;
            }
        }
        
        return new int[]{left+1,right+1};
    }
}