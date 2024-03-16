from itertools import product
def solution(word):
    word_list = []
    for i in range(1,6):
        for p in product(['A','E','I','O','U'],repeat=i):
            word_list.append(''.join(p))
    
    word_list.sort()
    
    answer = word_list.index(word) + 1
    
    return answer