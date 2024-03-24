def solution(strs, t):
    n = len(t)
    
    # 각 위치에서 필요한 최소 조각수를 저장할 배열
    dp = [float("inf")] * (n+1)
    
    # 빈 문자열을 위해 필요한 최소 조각수는 0
    dp[0] = 0
    sizes = set(len(s) for s in strs)
    
    for i in range(1,n+1):
        for size in sizes:
            # 이미 구한 해와 strs 조각들을 추가해서 문자열을 만들 수 있다면
            if (i-size>=0 and t[i-size:i] in strs):
                dp[i] = min(dp[i], dp[i-size]+1)
    
    return dp[n] if dp[n] < float("inf") else -1