def solution(land):
    n = len(land)
    
    for i in range(1,n):
        for j in range(4):
            land[i][j] += max(land[i-1][:j] + land[i-1][j+1:])
    
    return max(land[-1])