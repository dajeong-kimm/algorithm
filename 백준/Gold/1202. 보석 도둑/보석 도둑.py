import heapq

n,k = map(int,input().split())
diamond = []

for _ in range(n):
    m,v = map(int,input().split())
    heapq.heappush(diamond,[m,v])
    
bag = []
for _ in range(k):
    tmp = int(input())
    bag.append(tmp)
bag.sort()

answer = 0
tmp_jew = []
for b in bag:
    while diamond and b>=diamond[0][0]:
        heapq.heappush(tmp_jew,-heapq.heappop(diamond)[1])
    if tmp_jew:
        answer -= heapq.heappop(tmp_jew)
    elif not diamond:
        break
print(answer)

