def solution(n, lost, reserve):
    set_lost = set(lost) - set(reserve)
    set_reserve = set(reserve) - set(lost)
    
    for res in set_reserve:
        if res-1 in set_lost:
            set_lost.remove(res-1)
        elif res+1 in set_lost:
            set_lost.remove(res+1)
    
    return n - len(set_lost)