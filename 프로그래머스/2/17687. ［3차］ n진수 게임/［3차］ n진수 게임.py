def make_str(num,n):
    answer=''
    if num == 0:
        return '0'
    if n==10:
        return str(num)
    arr = [str(i) for i in range(10)]
    arr.extend(['A','B','C','D','E','F'])
    while num>0:
        answer += arr[num%n]
        num = num//n
    return answer[::-1]
    
    

def solution(n, t, m, p):
    string = ''
    num = 0
    while len(string)<=(m*t):
        string += make_str(num,n)
        num += 1
    
    string = list(string)
    answer = ''
    count = 0
    while len(answer)<t:
        answer += string[p-1+(count)*m]
        count += 1
    return answer

