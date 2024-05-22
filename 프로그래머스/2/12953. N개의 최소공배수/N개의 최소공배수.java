class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int before = arr[0];
        for (int i=1;i<arr.length;i++){
            int tmp_gcd = gcd(arr[i],before);
            answer = before*arr[i]/tmp_gcd;
            // System.out.println("gcd " + tmp_gcd);
            // System.out.println(answer);
            before = answer;
        }
        return answer;
    }
    private int gcd(int a, int b){
        while (b>0) {
            // a,b = b,a%b
            int save_a = a;
            int save_b = b;
            a = save_b;
            b = save_a%save_b;
        }
        return a;
    }
}