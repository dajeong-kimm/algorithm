n = int(input())

def is_prime(num):
    if num == 1:
        return False
    elif num == 2:
        return True
    for i in range(2,int(num**0.5)+1):
        if num%i == 0:
            return False
    return True

result = 0

for i in range(n,1000001):
    if i == 1:
        continue
    if str(i) == str(i)[::-1]:
        if is_prime(i):
            result = i
            break
    
if result == 0:
    result = 1003001

print(result)