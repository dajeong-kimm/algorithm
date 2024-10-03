import java.util.*;
class Solution {
    Set<Integer> original; //최초카드
    Set<Integer> additional; //추가카드
    public int solution(int coin, int[] cards) {
        int answer = 0; //게임이 진행된 라운드 수를 카운트
        
        int len = cards.length;
        original = new HashSet<>();
        additional = new HashSet<>();
        
        //카드 배열의 1/3만큼의 카드를 original에 추가
        int idx = len/3;
        for (int i=0;i<idx;i++){
            original.add(cards[i]);
        }
        
        int target = len + 1; 
        
        while (true){
            answer++;
            if (idx >= len) break;
            
            //추가 카드 2장
            additional.add(cards[idx]);
            additional.add(cards[idx+1]);
            idx += 2;
            
            boolean flag = false;
            
            //1. original에서 2개를 사용해서 만들기
            for (int i : original){
                if (original.contains(target-i)){
                    original.remove(i);
                    original.remove(target-i);
                    flag = true;
                    break;
                }
            }
            
            //2. 추가 카드 한장 사용
            if (!flag){
                if (coin > 0){
                    for (int i : original){
                        if (additional.contains(target-i)){
                            original.remove(i);
                            additional.remove(target-i);
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            //3. 추가 카드 두장 사용
            if (!flag){
                if (coin>1){
                    for (int i : additional){
                        if (additional.contains(target-i)){
                            additional.remove(i);
                            additional.remove(target-i);
                            coin -= 2;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if (!flag) break;
        }
        
        return answer;
    }
}