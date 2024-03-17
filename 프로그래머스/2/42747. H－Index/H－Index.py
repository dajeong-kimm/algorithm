def solution(citations):
    citations.sort(reverse=True)
    answer = 0
    for index, value in enumerate(citations):
        if value >= (index+1):
            answer += 1
    
    return answer