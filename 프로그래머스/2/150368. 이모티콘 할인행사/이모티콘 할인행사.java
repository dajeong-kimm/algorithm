class Solution {
    static int[] sale;
    static int n, m;
    static int maxNum, maxPrice;
    static int[][] users;
    static int[] emoticons;
    
    public int[] solution(int[][] Users, int[] Emoticons) {
        n = Users.length;
        m = Emoticons.length;
        
        users = Users;
        emoticons = Emoticons;
        
        sale = new int[m];
        
        makeArr(0);
        return new int[]{maxNum, maxPrice};
    }
    
    static void test() {
        int num = 0;
        int price = 0;
        for (int i=0;i<n;i++) {
            int curPrice = 0;
            for (int j=0;j<m;j++) {
                if (sale[j] >= users[i][0]) {
                    curPrice += emoticons[j]*(100-sale[j])/100;
                }
            }
            if (curPrice >= users[i][1]) {
                num++;
            } else {
                price += curPrice;
            }
        }
        
        if (num > maxNum) {
            maxNum = num;
            maxPrice = price;
        } else if (num == maxNum && price > maxPrice) {
            maxPrice = price;
        }
    }
    
    static void makeArr(int idx) {
        if (idx == m) {
            test();
            return;    
        }
        
        for (int i=1;i<=4;i++) {
            sale[idx] = i*10;
            makeArr(idx+1);
        }
        
    }
}