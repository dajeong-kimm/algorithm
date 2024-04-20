def is_prime(num):
    if num == 1:
        return False
    for i in range(2,int(num**0.5)+1):
        if num%i == 0:
            return False
    return True

def solve(num):
    if len(str(num)) == n:
        if is_prime(num) == True:
            print(num)
            return
    for i in range(10):
        k = num*10+i
        if is_prime(k) == True:
            solve(k)

n = int(input())

for i in [2,3,5,7]:
    solve(i)
