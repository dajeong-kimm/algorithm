from math import sqrt

def is_prime(num):
    if num==1:
        return False
    if num==2:
        return True
    for i in range(3,int(sqrt(num))+1):
        if num%i == 0:
            return False
    return True

# print(is_prime(7))

def solution(n, k):
    arr = []
    while n>0:
        arr.append(n%k)
        n = n//k
    arr.reverse()
    number = ''
    for a in arr:
        number += str(a)
    num = list(map(str,number.split('0')))
    answer = 0
    for x in num:
        if x:
            if is_prime(int(x)):
                answer += 1
    return answer