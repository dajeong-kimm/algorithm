a,b = map(int,input().split())
m = int(input())
arr = list(map(int,input().split()))
arr.reverse()
num = 0
mul = 1
idx = 0
# print(arr)
while idx<m:
    num += arr[idx]*mul
    idx += 1
    mul *= a
# print(num)
answer = []
while num>0:
    answer.append(num%b)
    num //= b

answer.reverse()
print(*answer)