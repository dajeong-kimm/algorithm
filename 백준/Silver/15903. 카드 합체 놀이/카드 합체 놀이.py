import heapq

n,m = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()

heapq.heapify(arr)

for _ in range(m):
    tmp1 = heapq.heappop(arr)
    tmp2 = heapq.heappop(arr)
    tmp = tmp1+tmp2
    heapq.heappush(arr,tmp)
    heapq.heappush(arr,tmp)

print(sum(arr))

