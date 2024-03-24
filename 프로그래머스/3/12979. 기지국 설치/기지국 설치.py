def solution(n, stations, w):
    answer = 0
    
    # 현재 탐색하는 아파트의 위치
    location = 1 
    
    # 설치된 기지국의 인덱스
    idx = 0
    
    while location<=n:
        # 기지국이 설치된 위치에 도달한 경우
        if idx < len(stations) and location >= stations[idx] - w:
            location = stations[idx]+w+1
            idx += 1
        
        # 기지국이 설치되지 않은 위치인 경우
        else:
            location += 2*w+1
            answer += 1
    
    return answer