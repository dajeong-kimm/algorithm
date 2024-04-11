from collections import Counter

def solution(str1, str2):
    set1 = []
    set2 = []
    str1 = str1.lower()
    str2 = str2.lower()
    
    for i in range(len(str1)-1):
        tmp = str1[i:i+2]
        if tmp.isalpha():
            set1.append(tmp)
    
    for i in range(len(str2)-1):
        tmp = str2[i:i+2]
        if tmp.isalpha():
            set2.append(tmp)
    
    Counter1 = Counter(set1)
    Counter2 = Counter(set2)
    
    inter = list((Counter1&Counter2).elements())
    union = list((Counter1|Counter2).elements())
    
    if len(union) == 0 and len(inter)==0:
        return 65536
    else:
        return int(len(inter)/len(union)*65536)
    
