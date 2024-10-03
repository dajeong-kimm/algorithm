import java.util.*;
/**
비정상적인 방법으로 당첨을 시도한 응모자들 --> 불량 사용자
아이디 당 최소 하나 이상의 '*' -> 제재 아이디
당첨에서 제외되어야 할 제재 아이디 목록은 몇 가지 경우의 수 가능?
*/
class Solution {
    static boolean[] check;
    static HashSet<String> set; //경우의 수
    public int solution(String[] user_id, String[] banned_id) {
        check = new boolean[user_id.length];
        set = new HashSet<String>();
        
        for (int i=0;i<banned_id.length;i++){
            banned_id[i] = banned_id[i].replace("*",".");
        }
        
        combination(0, "", banned_id, user_id);
        
        return set.size();
    }
    
    void combination(int depth, String res, String[] banid, String[] userid){
        if (depth == banid.length){
            String[] arr = res.split(" ");
            Arrays.sort(arr);
            
            String str = "";
            for (String s : arr){
                str += s;
            }
            set.add(str);
            return;
        }
        
        for (int i=0;i<userid.length;i++){
            if (check[i] || !userid[i].matches(banid[depth])) continue;
            
            check[i] = true;
            combination(depth+1, userid[i]+" "+res, banid, userid);
            check[i] = false;
        }
    }
}