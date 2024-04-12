def solution(n, s):
    answer = []
    if n>s:
        return [-1]
    tmp = s//n
    na = s%n
    for _ in range(n-(na)):
        answer.append(tmp)
    for _ in range(na):
        answer.append(tmp+1)
    return answer
    