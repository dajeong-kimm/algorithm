import java.util.*;
class Solution {
    int N;
    int[][] Dice;
    
    int winCount = 0; //최대일 때 승리 횟수
    List<Integer> answer; //최대일 때 고른 주사위 리스트
    
    List<Integer> listA;
    List<Integer> listB;
    public int[] solution(int[][] dice) {
        N = dice.length;
        Dice = dice;
        
        List<Integer> pick = new ArrayList<>();
        combination(0, pick);
        
        int[] result = new int[answer.size()];
        for (int i=0;i<answer.size();i++){
            result[i] = answer.get(i)+1;
        }
        return result;
    }
    
    void combination(int cur, List<Integer> pick){
        if (pick.size() == N/2){
            CalWin(pick);
            return;
        }
        
        if (cur >= N) return;
        
        for (int i=cur;i<N;i++){
            pick.add(i);
            combination(i+1,pick);
            pick.remove(pick.size()-1);
        }
    }
    
    void CalWin (List<Integer> pick){
        boolean[] a = new boolean[N];
        for (int i=0;i<pick.size();i++){
            a[pick.get(i)] = true;
        }
        List<Integer> nonPick = new ArrayList<>();
        for (int i=0;i<N;i++){
            if (!a[i]) nonPick.add(i);
        }
        
        listA = new ArrayList<>();
        listB = new ArrayList<>();
        
        
        MakeDiceListA(0,0,pick);
        MakeDiceListB(0,0,nonPick);
        
        Collections.sort(listA);
        Collections.sort(listB);
        
        int tmpWin = 0;
        for (int i=0;i<listA.size();i++){
            int aNum = listA.get(i);
            
            int bs = binarySearch(listB, aNum);
            tmpWin += bs;
        }
        
        if (tmpWin > winCount){
            winCount = tmpWin;
            answer = new ArrayList<>(pick);
            System.out.println(winCount);
        }
        
    }
    
    void MakeDiceListA(int idx, int curScore, List<Integer> pick){
        if (idx == N/2){
            listA.add(curScore);
            return;
        }
        
        int[] d = Dice[pick.get(idx)];
        for (int i=0;i<6;i++){
            MakeDiceListA(idx+1, curScore+d[i], pick);
        }
    }
    void MakeDiceListB(int idx, int curScore, List<Integer> pick){
        if (idx == N/2){
            listB.add(curScore);
            return;
        }
        
        int[] d = Dice[pick.get(idx)];
        for (int i=0;i<6;i++){
            MakeDiceListB(idx+1, curScore+d[i], pick);
        }
    }
    
    int binarySearch(List<Integer> list, int num){
        int start = 0;
        int end = list.size()-1;
        
        int result = -1;
        while (start<=end){
            int mid = (start+end)/2;
            
            if (list.get(mid) < num){
                start = mid+1;
                result = mid;
            } else {
                end = mid-1;
            }
        }
        
        return result+1;
    }
}