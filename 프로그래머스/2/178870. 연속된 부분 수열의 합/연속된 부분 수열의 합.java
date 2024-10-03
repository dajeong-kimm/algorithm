class Solution {
    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        
        //가장 짧은 구간의 왼,오 저장
        int left = 0;
        int right = N-1;
        
        int L,R;
        int sum = 0;
        for (L=0, R=0;L<N;L++){
            //R 포인터 이동
            while (R<N){
                if (sum >= k) break;
                sum += sequence[R];
                R++;
            }
            
            //구간의 합이 k와 같으면 구간의 길이 확인
            if (sum == k){
                int range = R-L-1;
                if ((right-left) > range){
                    left = L;
                    right = R-1;
                }
            }
            
            sum -= sequence[L];
            
        }
        int[] answer = {left,right};
        return answer;
    }
}