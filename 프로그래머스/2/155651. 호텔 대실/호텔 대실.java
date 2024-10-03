import java.util.*;
/**
10분간 청소 -> 다음 손님
코니에게 필요한 최소 객실의 수 
*/

class Solution {
    
    class Node implements Comparable<Node> {
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o){
            return start - o.start;
        }
    }
    
    Node[] hotel;
    int N;
    public int solution(String[][] book_time) {
        int answer = 1;
        
        N = book_time.length;
        hotel = new Node[N];
        
        for (int i=0;i<N;i++){
            int startTime = calTime(book_time[i][0]);
            int endTime = calTime(book_time[i][1]);
            
            hotel[i] = new Node(startTime, endTime);
            
        }
        
        Arrays.sort(hotel);
        
        PriorityQueue<Integer> room = new PriorityQueue<>();
        Node first = hotel[0];
        room.add(first.end+10);
        
        for (int i=1;i<N;i++){
            Node cur = hotel[i];
            int start = cur.start;
            int end = cur.end;
            
            System.out.println("start: "+start+" end: "+end);
            
            int time = room.poll();
            if (time <= start){
                room.add(end+10);
            }
            else {
                room.add(time);
                room.add(end+10);
            }
        }
        
        return room.size();
    }
    int calTime(String str){
        int hour = Integer.parseInt(str.substring(0,2));
        int min = Integer.parseInt(str.substring(3,5));
        
        return hour*60+min;
    }
}