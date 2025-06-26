import java.util.*;
class Solution {
    static Map<Integer, Integer> robotMap; //충돌 여부를 확인하기 위한 map
    static int n; //n개의 운송 포인트
    static int m; //운송 경로 m개의 포인트
    static int x; //로봇 갯수
    static class Robot {
        int curX, curY;
        int toIdx;
        boolean isFinished;
        
        Robot(int curX, int curY, int toIdx, boolean isFinished) {
            this.curX = curX;
            this.curY = curY;
            this.toIdx = toIdx;
            this.isFinished = isFinished;
        }
    }
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int count = 0;
        n = points.length;
        m = routes[0].length;
        x = routes.length;
        
        Robot[] robot = new Robot[x];
        
        robotMap = new HashMap<>();
        //로봇의 첫 위치 셋팅
        for (int i=0;i<x;i++){
            int num = routes[i][0];
            int curX = points[num-1][0];
            int curY = points[num-1][1];
            robot[i] = new Robot(curX, curY, 1, false);
            int hashNum = robot[i].curX * 100 + robot[i].curY;
                if (!robotMap.containsKey(hashNum)) {
                    robotMap.put(hashNum, 0);
                }
                robotMap.put(hashNum, robotMap.get(hashNum)+1);
        }
        
        //이동
        int curTime = 1;
        while (true) {
            for (int hashNum : robotMap.keySet()){
                if (robotMap.get(hashNum) >= 2) {
                    answer++;
                }
            }
            if (count == x) break; //모든 운송 완료
            robotMap = new HashMap<>(); //충돌 여부 체크를 위한 map
            
            for (int i=0;i<x;i++){
                if (robot[i].isFinished) continue; //이미 운송 완료했으면 skip
                int toIdx = robot[i].toIdx;
                int toX = points[routes[i][toIdx]-1][0];
                int toY = points[routes[i][toIdx]-1][1];
                if (Math.abs(robot[i].curX - toX) > 0) { //r방향 이동
                    if (toX > robot[i].curX) {
                        robot[i].curX += 1;
                    } else {
                        robot[i].curX -= 1;
                    }
                } else { //c방향 이동
                    if (toY > robot[i].curY) {
                        robot[i].curY += 1;
                    } else {
                        robot[i].curY -= 1;
                    }
                }
                
                int hashNum = robot[i].curX * 100 + robot[i].curY;
                if (!robotMap.containsKey(hashNum)) {
                    robotMap.put(hashNum, 0);
                }
                robotMap.put(hashNum, robotMap.get(hashNum)+1);
                
                
                //원하는 spot에 도착했는지
                if (robot[i].curX == toX && robot[i].curY == toY) {
                    if (toIdx == m-1) { //마지막 spot에 도착
                        count++;
                        robot[i].isFinished = true;
                    } else {
                        robot[i].toIdx += 1;
                    }
                }
            }
            
            
        }
        
        return answer;
    }
}