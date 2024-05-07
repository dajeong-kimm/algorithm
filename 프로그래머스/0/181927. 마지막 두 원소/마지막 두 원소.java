class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        int idx = 0;
        for (int i=0;i<num_list.length;i++){
            answer[idx++] = num_list[i];
        }
        if (num_list[num_list.length-1]>num_list[num_list.length-2])
            answer[idx] = num_list[num_list.length-1]-num_list[num_list.length-2];
        else
            answer[idx] = num_list[num_list.length-1]*2;
        return answer;
    }
}