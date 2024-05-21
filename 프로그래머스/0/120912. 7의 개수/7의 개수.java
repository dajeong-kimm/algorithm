class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int a : array){
            String[] arr = String.valueOf(a).split("");
            for (String ar : arr){
                if (ar.equals("7")) answer += 1;
            }
        }
        return answer;
    }
}