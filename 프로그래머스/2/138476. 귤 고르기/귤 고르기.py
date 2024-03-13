def solution(k, tangerine):
    t_count = [0 for i in range(10000001)]
    
    for t in tangerine:
        t_count[t] += 1
    
    t_count.sort(reverse=True)
    
    count = 0
    answer = 0
    
    while count<k:
        max_count = t_count[answer]
        count += max_count
        answer += 1
    
        
        
    
    return answer

    