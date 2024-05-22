class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0,0};
        int a = board[0]/2;
        int b = board[1]/2;
        for (String key : keyinput){
            if (key.equals("left")) {
                if (answer[0]-1>=-a) answer[0] -= 1;
            } else if (key.equals("right")) {
                if (answer[0]+1<=a) answer[0] += 1;
            } else if (key.equals("up")) {
                if (answer[1]+1<=b) answer[1] += 1;
            } else{
                if (answer[1]-1>=-b) answer[1] -= 1;
            }
        }
        return answer;
    }
}