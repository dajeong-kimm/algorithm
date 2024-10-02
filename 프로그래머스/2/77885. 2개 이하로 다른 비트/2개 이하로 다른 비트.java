class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i=0;i<numbers.length;i++){
            //짝수일때
            if (numbers[i]%2 == 0){
                answer[i] = numbers[i]+1;
            }
            //홀수일때
            else{
                String binary = Long.toBinaryString(numbers[i]);
                
                int idx = binary.lastIndexOf("0");
                //0이 없을때
                if (idx == -1){
                    String tmp = "10"+binary.substring(1,binary.length());
                    answer[i] = Long.parseLong(tmp,2);
                }
                //뒤에서부터 처음 등장하는 0의 인덱스 이용
                else{
                    String tmp = binary.substring(0,idx)+"10"+binary.substring(idx+2,binary.length());
                    answer[i] = Long.parseLong(tmp,2);
                }
                
            }
        }
        return answer;
    }
}