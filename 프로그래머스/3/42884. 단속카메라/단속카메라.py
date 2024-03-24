def solution(routes):
    routes = sorted(routes, key = lambda x:x[1])
    cnt = 0
    key = -30001
    
    for start, end in routes:
        if start>key:
            cnt += 1
            key = end
    
    return cnt
        