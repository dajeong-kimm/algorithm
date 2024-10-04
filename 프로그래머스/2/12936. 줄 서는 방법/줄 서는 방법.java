import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        
        long factorial = 1;
        
        //1부터 n까지의 숫자를 리스트에 넣기
        for (int i=1;i<=n;i++){
            numbers.add(i);
            factorial *= i;
        }
        
        //K번째 순열을 구하기 위해 K-1로 변환
        k--;
        
        //각 자리에 올 숫자를 결정
        for (int i=0;i<n;i++){
            factorial /= (n-i); //남은 숫자들의 팩토리얼
            int index = (int) (k/factorial); //자리에 올 숫자의 인덱스 계산
            answer[i] = numbers.remove(index); //숫자를 선택하고 리스트에서 제거
            k %= factorial; //K값을 업데이트하여 다음 자리를 결정
        }
        
        return answer;
    }
}