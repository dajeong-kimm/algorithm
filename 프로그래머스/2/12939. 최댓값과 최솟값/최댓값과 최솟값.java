class Solution {
    public String solution(String s) {
        String[] num = s.split(" ");
        int[] int_num = new int[num.length];
        for (int i=0;i<int_num.length;i++){
            int_num[i] = Integer.parseInt(num[i]);
        }
        int min_value = int_num[0];
        int max_value = int_num[0];
        for (int number : int_num) {
            min_value = Math.min(min_value,number);
            max_value = Math.max(max_value,number);
        }
        return String.valueOf(min_value)+" "+String.valueOf(max_value);
    }
}