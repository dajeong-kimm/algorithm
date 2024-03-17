def solution(files):
    answer = []
    for index, value in enumerate(files):
        head_bool = False
        head=[]
        number=[]
        for v in value:
            if head_bool == False and (not v.isdigit()):
                head.append(v)
            elif v.isdigit():
                number.append(v)
                head_bool = True
            elif head_bool == True and (not v.isdigit()):
                break
        head = ''.join(head)
        number = ''.join(number)
        answer.append([head, number, index, value])
    
    answer = sorted(answer, key=lambda x:(x[0].lower(), int(x[1]), x[2]))
    
    result = []
    for ans in answer:
        result.append(ans[3])
    
    return result