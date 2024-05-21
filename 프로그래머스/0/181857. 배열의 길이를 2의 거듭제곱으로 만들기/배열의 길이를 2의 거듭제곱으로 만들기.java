class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int size = arr.length;
        int num = 1;
        while (num<size){
            num *= 2;
        }
        answer = new int[num];
        for (int i=0;i<arr.length;i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}