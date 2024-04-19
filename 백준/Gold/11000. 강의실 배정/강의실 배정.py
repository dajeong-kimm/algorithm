import heapq

n = int(input())
time = [list(map(int,input().split())) for _ in range(n)]
sorted_time = sorted(time,key=lambda x:(x[0],x[1]))

heap = [sorted_time[0][1]]

for i in range(1,n):
    if heap[0]<=sorted_time[i][0]:
        heapq.heappop(heap)
    heapq.heappush(heap,sorted_time[i][1])

print(len(heap))