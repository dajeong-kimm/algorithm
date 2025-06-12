class Solution {
    static int curTime;
    static int opStart, opEnd;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        opStart = timeToInt(op_start);
        opEnd = timeToInt(op_end);
        curTime = timeToInt(pos);
        int lastTime = timeToInt(video_len);
        
        opening();
        for (int i=0;i<commands.length;i++){
            if (commands[i].equals("prev")) {
                curTime -= 10;
                if (curTime < 0) curTime = 0;
                opening();
            } else if (commands[i].equals("next")) {
                curTime += 10;
                if (curTime > lastTime) curTime = lastTime;
                opening();
            } 
        }
        return intToTime(curTime);
    }
    
    static void opening() {
        if (curTime >= opStart && curTime < opEnd) {
            curTime = opEnd;
        }
    }
    
    static int timeToInt(String time) {
        String[] arr = time.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        return h*60+m;
    }
    
    static String intToTime(int time) {
        int h = time / 60;
        int m = time % 60;
        
        return attachZero(h)+":"+attachZero(m);
    }
    
    static String attachZero(int num) {
        if (num == 0) return "00";
        else if (num < 10) return "0"+num;
        else return ""+num;
    }
}