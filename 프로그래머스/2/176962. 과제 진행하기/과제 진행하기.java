import java.util.*;
class Solution {
    static class Plan implements Comparable<Plan> {
        String name;
        int start, time;
        
        Plan(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Plan o) {
            return Integer.compare(start, o.start);
        }
    }
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        
        int idx = 0;
        
        Plan[] arr = new Plan[N];
        for (int i=0;i<N;i++){
            int startTime = timeToMinute(plans[i][1]);
            int time = Integer.parseInt(plans[i][2]);
            arr[i] = new Plan(plans[i][0], startTime, time);
        }
        Arrays.sort(arr);
        
        int curTime = arr[0].start;
        Stack<Plan> stack = new Stack<>();
        for (int i=0;i<N-1;i++) {
            int startTime = arr[i].start;
            int nextTime = arr[i+1].start;
            if (startTime + arr[i].time <= nextTime) { //다 가능하면
                answer[idx++] = arr[i].name;
                curTime = startTime + arr[i].time;
            } else { //가능한 시간만큼 하고 stack에 넣기
                arr[i].time -= (nextTime-startTime);
                stack.add(arr[i]);
                curTime = nextTime;
            }
            
            if (curTime < nextTime) {
                if (stack.isEmpty()) curTime = nextTime;
                else { // 스택에 있는 것 처리
                    while (curTime < nextTime) {
                        if (stack.isEmpty()) {
                            curTime = nextTime;
                            break;
                        }
                        Plan cur = stack.pop();
                        //전부 처리 가능하면
                        if (curTime + cur.time <= nextTime) {
                            curTime += cur.time;
                            answer[idx++] = cur.name;
                        }
                        //일부 처리 가능하면
                        else {
                            cur.time -= (nextTime-curTime);
                            stack.add(cur);
                            curTime = nextTime;
                        }
                    }
                }
            }
        }
        
        //마무리
        curTime += arr[N-1].time;
        answer[idx++] = arr[N-1].name;
        
        while (!stack.isEmpty()) {
            Plan cur = stack.pop();
            answer[idx++] = cur.name;
        }
        
        
        
        return answer;
    }
    
    static int timeToMinute(String time) {
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3));
        return h*60+m;
    }
}