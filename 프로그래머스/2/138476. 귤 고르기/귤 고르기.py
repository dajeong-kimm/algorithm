from collections import Counter
def solution(k, tangerine):
    answer = 0
    count = Counter(tangerine)
    
    sorted_count = count.most_common()
    
    for num, cnt in sorted_count:
        k -= cnt
        answer += 1
        if k < 1:
            break
    
    return answer