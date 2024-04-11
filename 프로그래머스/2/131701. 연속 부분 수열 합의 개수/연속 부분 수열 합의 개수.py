def solution(elements):
    n = len(elements)
    elements = elements*2
    answer = set()
    for i in range(1,n+1):
        for j in range(n):
            tmp = sum(elements[j:j+i])
            answer.add(tmp)
    
    return len(answer)