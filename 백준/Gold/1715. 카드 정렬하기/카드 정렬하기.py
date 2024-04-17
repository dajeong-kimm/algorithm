import heapq
n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

if n==1:
    print(0)
    exit()
elif n==2:
    print(sum(arr))
    exit()

heapq.heapify(arr)

answer = 0
while len(arr) != 1:
    x = heapq.heappop(arr)
    y = heapq.heappop(arr)
    answer += x+y
    heapq.heappush(arr,x+y)

print(answer)
